package actors.worlds.messages.actor_actions;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о действии с актором.
 */
public abstract class ActorAction extends Message {
    private final ActorRef actor;
    ActorAction(
            ActorRef sender,
            ActorRef actor
            ) {
        super(sender);
        this.actor = actor;
    }

    public ActorRef getActor() {
        return actor;
    }
}
