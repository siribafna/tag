package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command{
    private InputOutput io;

    public AttackCommand (InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        return input.equalsIgnoreCase("a");
    }

    @Override
    public void execute(String input, Game game) {
        //int i = 0;
        Random r = new Random();
        if (game.getPlayer().getLocation().getAdversary() != null){
            int i = r.nextInt(100) + 1;
            if (i <= 20 && i > 0) {
                game.getPlayer().getLocation().getAdversary().setDamageTaken(10);
                io.displayText(("You hit " + game.getPlayer().getLocation().getAdversary().getName()) + "!");
                int hitpoints = (game.getPlayer().getLocation().getAdversary().getHitPoints() - game.getPlayer().getLocation().getAdversary().getDamageTaken());
                if (hitpoints > 0) {
                    io.displayText("HitPoints: " + hitpoints);
                }
                if(hitpoints <= 0) {
                    io.displayText(("You KILLED " + game.getPlayer().getLocation().getAdversary().getName()) + "!");
                    game.getPlayer().getInventory().addItem(game.getPlayer().getLocation().getAdversary().getAdversaryTreasure());
                    game.getPlayer().getLocation().setAdversary(null);
                    //game.getPlayer().getLocation().getAdversary().getAdversaryTreasure();
                }
            }
        }
        else  {
            io.displayText("Attack What?");
            return;
        }



    }
}
