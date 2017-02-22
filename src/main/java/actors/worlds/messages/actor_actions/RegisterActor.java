package actors.worlds.messages.actor_actions;

import akka.actor.ActorRef;

/**
 * Сообщение о необходимости регистрации актора в мире.
 */
public class RegisterActor extends ActorAction {

    public RegisterActor(ActorRef sender, ActorRef actor) {
        super(sender, actor);
    }
}
