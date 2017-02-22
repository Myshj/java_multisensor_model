package actors.base.broadcasters.messages.listener_actions;

import akka.actor.ActorRef;

/**
 * Сообщение о необходимости удаления слушателя из списка слушателей.
 */
public class RemoveListener extends ListenerAction {
    RemoveListener(ActorRef sender, ActorRef listener) {
        super(sender, listener);
    }

    @Override
    public String toString() {
        return "RemoveListener{" +
                "listener=" + getListener() +
                '}';
    }
}
