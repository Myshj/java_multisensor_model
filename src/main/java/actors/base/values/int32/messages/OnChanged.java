package actors.base.values.int32.messages;

import actors.base.Message;
import akka.actor.ActorRef;

/**
 * Сообщение о том, что актор Int32 изменил своё состояние.
 */
public class OnChanged extends Message {
    private final int oldValue;
    private final int newValue;

    public OnChanged(
            ActorRef sender,
            final int oldValue,
            final int newValue
    ) {
        super(sender);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public int getOldValue() {
        return oldValue;
    }

    public int getNewValue() {
        return newValue;
    }
}
