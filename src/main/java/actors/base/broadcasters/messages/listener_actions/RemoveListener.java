package actors.base.broadcasters.messages.listener_actions;

import akka.actor.ActorRef;

/**
 * Created by Alexey on 15.02.2017.
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
