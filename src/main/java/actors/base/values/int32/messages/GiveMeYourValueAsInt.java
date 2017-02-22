package actors.base.values.int32.messages;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о том, что кто-то желает получить текущее значение в виде целого числа.
 */
public class GiveMeYourValueAsInt extends Message {
    public GiveMeYourValueAsInt(ActorRef sender) {
        super(sender);
    }
}
