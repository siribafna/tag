package org.improving.tag.commands;

import org.improving.tag.Game;

public interface Command { // because API is public, no need to identify access: always public
    boolean isValid(String input, Game game);
    void execute(String input, Game game);

}
