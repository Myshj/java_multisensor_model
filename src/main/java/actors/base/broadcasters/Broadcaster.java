package actors.base.broadcasters;

import actors.base.Message;
import actors.base.broadcasters.messages.Broadcast;
import actors.base.broadcasters.messages.listener_actions.AddListener;
import actors.base.broadcasters.messages.listener_actions.RemoveListener;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

import java.util.HashSet;

/**
 * Created by Alexey on 15.02.2017.
 */

/**
 * Размножает полученные сообщения среди слушателей.
 */
public class Broadcaster extends UntypedActor {
    private HashSet<ActorRef> listeners = new HashSet<ActorRef>();

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

    private void onAddListener(final ActorRef listener) {
        this.addListener(listener);
    }

    private void onRemoveListener(final ActorRef listener) {
        this.removeListener(listener);
    }

    private void onBroadcast(final Message message) {
        this.broadcast(message);
    }

    private void broadcast(final Message message) {
        for (ActorRef listener : this.listeners) {
            listener.tell(message, message.getSender());
        }
    }

    private void addListener(final ActorRef listener) {
        this.listeners.add(listener);
    }

    private void removeListener(final ActorRef listener) {
        this.listeners.remove(listener);
    }
}
