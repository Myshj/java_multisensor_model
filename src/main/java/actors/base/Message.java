package actors.base;

/**
 * Created by Alexey on 15.02.2017.
 */

import akka.actor.ActorRef;

/**
 * Базовый класс для всех сообщений.
 */
public abstract class Message {

    private final ActorRef sender;

    public Message(final ActorRef sender) {
        this.sender = sender;
    }

    public ActorRef getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                '}';
    }
}
