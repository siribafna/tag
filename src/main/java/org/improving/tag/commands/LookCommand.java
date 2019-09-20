package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component // spring context identifies anything that has this as one of the dependencies
public class LookCommand extends BaseEmoteCommand {
    public LookCommand(InputOutput io) {
        super("look", "You look around.", io);
    }
}
