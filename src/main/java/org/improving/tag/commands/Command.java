package org.improving.tag.commands;

public interface Command { // because API is public, no need to identify access: always public
    boolean isValid(String input);
    void execute(String input);

}
