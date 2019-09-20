package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component // spring context idenitifies anything that has this as one of the dependencies
public class LookCommand extends BaseEmoteCommand {
    public LookCommand() {
        super("look", "You look around.");
    }
}
