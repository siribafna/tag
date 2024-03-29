package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import org.springframework.stereotype.Component;

@Component
public class MoveCommand extends BaseAliasedCommand {
    private InputOutput io;
    public MoveCommand(InputOutput io) {
        super(io,"move", "m", "mov", "mo");
        this.io = io;
    }
    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        if(parts.length == 1) throw new UnsupportedOperationException();
        return parts[0];
    }
    @Override
    public String getErrorMessage() {
        return "That route is unavailable.";
    }
    @Override
    public void childExecute(String input, Game game) {
        input = input.trim();
        var destination = input.substring(input.indexOf(" ") + 1);
        if (game.getPlayer().getLocation().getAdversary() != null) {
            System.out.println("You shall not pass!!!");
            return;
        }
        Exit exit = null;
        for(var e: game.getPlayer().getLocation().getExits()) {
            if (e.getName().equalsIgnoreCase(destination)) { // if e equals to any destination that was handed in move command, then set exit = e;
                exit = e;
            }
            else {
                for (var a : e.getAlias()) {
                    if (a.equalsIgnoreCase(destination)) {
                        exit = e;
                        break;
                    }
                }
            }
            if (exit != null) { break; }
        }
        if (exit == null) throw new UnsupportedOperationException();

        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You travel " + exit.getName() + ".");
    }

}
