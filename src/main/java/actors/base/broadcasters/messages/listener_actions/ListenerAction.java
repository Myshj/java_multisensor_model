package actors.base.broadcasters.messages.listener_actions;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о действии со слушателем.
 */
abstract class ListenerAction extends Message {
    private final ActorRef listener;

    ListenerAction(
            final ActorRef sender,
            final ActorRef listener
    ) {
        super(sender);
        this.listener = listener;
    }

    public ActorRef getListener() {
        return listener;
    }

    @Override
    public String toString() {
        return "ListenerAction{" +
                "listener=" + listener +
                '}';
    }
}
