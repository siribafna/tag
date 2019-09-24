package org.improving.tag.commands;

import org.improving.tag.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAliasedCommand implements Command{
    private List<String> aliases = new ArrayList<>();

    public BaseAliasedCommand(String...aliases) {
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game) {

        var trimmedInput = input.trim();

       return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase); // calls equalIgnoreCase for each array list member
        //find first that you care about, input has method on it that is equals ignore case, hand in pointer to a method
        //that returns a boolean, if u get a true, it will be filtered into result list
        //could replace instead of a for loop
    }

}
