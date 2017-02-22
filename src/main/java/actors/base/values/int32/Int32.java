package actors.base.values.int32;

import actors.base.broadcasters.Broadcaster;
import actors.base.broadcasters.messages.Broadcast;
import actors.base.values.int32.messages.GiveMeYourValueAsInt;
import actors.base.values.int32.messages.HereIsMyValueAsInt;
import actors.base.values.int32.messages.OnChanged;
import actors.base.values.int32.messages.SetYourValueFromInt;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Хранит целое число.
 */
public class Int32 extends UntypedActor {

    private ActorRef onChangedBroadcaster;

    private int value;

    public Int32() {
        this.initializeValue();
        this.initializeOnChangedBroadcaster();
    }

    public static Props props() {
        return Props.create(Int32.class);
    }

    public void onReceive(Object message) throws Throwable {
        if (message instanceof SetYourValueFromInt) {
            this.onSetYourValueFromInt(((SetYourValueFromInt) message).getValue());
        } else if (message instanceof GiveMeYourValueAsInt) {
            this.onGiveMeYourValueAsInt(((GiveMeYourValueAsInt) message).getSender());
        }
    }

    /**
     * Инициализация размножителя сообщений об изменении значения.
     */
    private void initializeOnChangedBroadcaster() {
        this.onChangedBroadcaster = getContext().actorOf(Broadcaster.props());
    }

    /**
     * Инициализация значения.
     */
    private void initializeValue() {
        this.value = 0;
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости установки нового значения.
     *
     * @param value Новое значение для установки.
     */
    private void onSetYourValueFromInt(final int value) {
        this.setFromInt(value);
    }

    /**
     * Устанавливает новое значение.
     * Если оно отличается от старого, то активирует onChangedBroadcaster.
     *
     * @param value Новое значение для установки.
     */
    private void setFromInt(final int value) {
        int oldValue = this.getValueAsInt();

        if (value == oldValue) {
            return;
        }

        this.value = value;
        this.onChangedBroadcaster.tell(
                new Broadcast(
                        getSelf(),
                        new OnChanged(
                                getSelf(),
                                oldValue,
                                value
                        )
                ),
                getSelf()
        );
    }

    /**
     * Вызывается каждый раз при получении сообщения о необходимости выдачи текущего значения.
     *
     * @param sender Желающий получить текущее значение.
     */
    private void onGiveMeYourValueAsInt(final ActorRef sender) {
        this.sendValueAsInt(sender);
    }

    /**
     * Выслать текущее значение актору.
     *
     * @param target Актор, которому текущее значение высылается.
     */
    private void sendValueAsInt(final ActorRef target) {
        target.tell(
                new HereIsMyValueAsInt(
                        this.getSelf(),
                        this.getValueAsInt()
                ),
                this.getSelf()
        );
    }

    /**
     * Возвращает текущее значение.
     *
     * @return Текущее значение.
     */
    private int getValueAsInt() {
        return value;
    }
}
