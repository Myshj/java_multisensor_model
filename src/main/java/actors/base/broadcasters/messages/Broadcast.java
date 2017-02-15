package actors.base.broadcasters.messages;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Created by Alexey on 15.02.2017.
 */
public class Broadcast extends Message {
    private final Message message;

    public Broadcast(
            final ActorRef sender,
            final Message message
    ) {
        super(sender);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
