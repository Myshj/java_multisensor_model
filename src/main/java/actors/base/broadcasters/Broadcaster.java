package actors.base.broadcasters;

import actors.base.Message;
import actors.base.broadcasters.messages.Broadcast;
import actors.base.broadcasters.messages.listener_actions.AddListener;
import actors.base.broadcasters.messages.listener_actions.RemoveListener;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.HashSet;

/**
 * Размножает полученные сообщения среди слушателей.
 */
public class Broadcaster extends UntypedActor {
    private HashSet<ActorRef> listeners = new HashSet<ActorRef>();

    public static Props props() {
        return Props.create(Broadcaster.class);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof AddListener) {
            this.onAddListener(((AddListener) message).getListener());
        } else if (message instanceof RemoveListener) {
            this.onRemoveListener(((RemoveListener) message).getListener());
        } else if (message instanceof Broadcast) {
            this.onBroadcast(((Broadcast) message).getMessage());
        }
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости добавления нового слушателя.
     *
     * @param listener Слушатель, которого нужно принять во внимание.
     */
    private void onAddListener(final ActorRef listener) {
        this.addListener(listener);
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости удаления слушателя.
     *
     * @param listener Слушатель, которого нужно удалить.
     */
    private void onRemoveListener(final ActorRef listener) {
        this.removeListener(listener);
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости размножения сообщения среди слушателей.
     *
     * @param message Сообщение для размножения.
     */
    private void onBroadcast(final Message message) {
        this.broadcast(message);
    }

    /**
     * Размножить сообщение среди слушателей.
     *
     * @param message Сообщение для размножения.
     */
    private void broadcast(final Message message) {
        for (ActorRef listener : this.listeners) {
            listener.tell(message, message.getSender());
        }
    }

    /**
     * Добавить актора в список слушателей.
     *
     * @param listener Актор для добавления.
     */
    private void addListener(final ActorRef listener) {
        this.getListeners().add(listener);
    }

    /**
     * Удалить актора из списка слушателей.
     *
     * @param listener Актор для удаления.
     */
    private void removeListener(final ActorRef listener) {
        this.getListeners().remove(listener);
    }

    /**
     * Возвращает множество слушателей.
     * @return Слушатели.
     */
    private HashSet<ActorRef> getListeners() {
        return listeners;
    }
}
