package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class LoadCommand implements Command{
    private InputOutput io;

    private SaveGameFactory saveFactory;

    public LoadCommand (InputOutput io, SaveGameFactory saveFactory) {
        this.io = io;
        this.saveFactory = saveFactory;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if(parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("load");
    }

    @Override
    public void execute(String input, Game game) {

        input = input.trim().substring(5);
        saveFactory.load(input, game);

        String currentLocation = game.getPlayer().getLocation().getName();

        io.displayText("You're loading " + input);
        io.displayText("You're now at " +  currentLocation);
    }
}
