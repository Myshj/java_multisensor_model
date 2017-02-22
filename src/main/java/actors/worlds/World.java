package actors.worlds;

import actors.worlds.messages.actor_actions.RegisterActor;
import actors.worlds.messages.actor_actions.UnregisterActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.HashSet;

/**
 * Представляет собой мир, в котором существуют акторы.
 */
public class World extends UntypedActor {
    private String name;

    private HashSet<ActorRef> relatedActors;

    public static Props props() {
        return Props.create(World.class);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof RegisterActor) {
            this.onRegisterActor(((RegisterActor) message).getActor());
        } else if (message instanceof UnregisterActor) {
            this.onUnregisterActor(((UnregisterActor) message).getActor());
        }
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости регистрации актора.
     *
     * @param actor Актор, которого нужно зарегистрировать в мире.
     */
    private void onRegisterActor(final ActorRef actor) {
        this.registerActor(actor);
    }

    /**
     * Вызывается каждый раз при получении сообщения о удаления актора из мира.
     *
     * @param actor Актор, регистрацию которого нужно отменить.
     */
    private void onUnregisterActor(final ActorRef actor) {
        this.unregisterActor(actor);
    }

    /**
     * Добавить актора в мир.
     *
     * @param actor Актор для добавления.
     */
    private void registerActor(final ActorRef actor) {
        this.getRelatedActors().add(actor);
    }

    /**
     * Удалить актора из списка слушателей.
     *
     * @param actor Актор для удаления.
     */
    private void unregisterActor(final ActorRef actor) {
        this.getRelatedActors().remove(actor);
    }

    /**
     * Возвращает множество акторов, связанных с миром.
     * @return Акторы, связанные с миром.
     */
    private HashSet<ActorRef> getRelatedActors() {
        return relatedActors;
    }
}
