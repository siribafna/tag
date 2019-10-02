package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {

    public OpenCommand(InputOutput io, String... aliases) {
        super(io, "open", "op", "ope", "expose");
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        return (input.equalsIgnoreCase("open"));
    }

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        if(parts.length == 1) throw new UnsupportedOperationException();
        return parts[0];
    }

    @Override
    public void childExecute(String input, Game game) {
        input = input.trim();
        if (game.getPlayer().getLocation().getTreasureDescription() != "") {
            Item item = game.getPlayer().getLocation().openTreasureChest();
            io.displayText("You have found " + item);
            game.getPlayer().getInventory().addItem(item);
           // return;
        }
        else {
           // io.displayText("Nothing here! Sorry");
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public String getErrorMessage() {
        return "There isn't anything here! Sorry.";
    }

}
