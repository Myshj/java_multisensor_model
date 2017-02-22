package actors.worlds.messages.actor_actions;

import akka.actor.ActorRef;

/**
 * Сообщение о необходимости удаления актора из мира
 */
public class UnregisterActor extends ActorAction {
    UnregisterActor(ActorRef sender, ActorRef actor) {
        super(sender, actor);
    }
}
