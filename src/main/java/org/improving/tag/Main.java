package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class); // go to spring class and find access

        Game game = context.getBean(Game.class); // let me look at game, let me look at constructors for game, let me see what they need,
        // they need a bunch of things that are command, what can i provide them with with commands and plug those in automatically
        game.run();

        long elapsedTicks = game.getEndTime().getTime() - game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;
        System.out.println("We were running for " + elapsedSeconds + " s.");
    }
}

