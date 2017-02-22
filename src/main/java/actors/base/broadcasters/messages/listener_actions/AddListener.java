package actors.base.broadcasters.messages.listener_actions;

import akka.actor.ActorRef;

/**
 * Сообщение о необходимости принятия слушателя во внимание.
 */
public class AddListener extends ListenerAction {

    public AddListener(ActorRef sender, ActorRef listener) {
        super(sender, listener);
    }

    @Override
    public String toString() {
        return "AddListener{" +
                "listener=" + getListener() +
                '}';
    }
}
