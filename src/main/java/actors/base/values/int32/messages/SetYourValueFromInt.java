package actors.base.values.int32.messages;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о том, что актор должен изменить своё значение, пользуясь предоставленным целым числом.
 */
public class SetYourValueFromInt extends Message {

    private final int value;

    public SetYourValueFromInt(
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
