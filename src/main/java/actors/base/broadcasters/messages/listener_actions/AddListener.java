package actors.base.broadcasters.messages.listener_actions;

import akka.actor.ActorRef;

/**
 * Created by Alexey on 15.02.2017.
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
