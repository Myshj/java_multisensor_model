package actors.base.values.int32.messages;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о выдаче значения в виде целого числа.
 */
public class HereIsMyValueAsInt extends Message {
    private final int value;

    public HereIsMyValueAsInt(
            final ActorRef sender,
            final int value
    ) {
        super(sender);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
