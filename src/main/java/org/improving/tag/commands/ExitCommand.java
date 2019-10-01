package org.improving.tag.commands;
import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {

   private SaveGameFactory saveGameFactory; // final, should do when trying to get a dependency

   public ExitCommand (SaveGameFactory saveGameFactory, InputOutput io) {
       super(io, "exit", "leave", "bye", "peace");
       this.saveGameFactory = saveGameFactory;
   }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        return (input.equalsIgnoreCase("exit"));
    }

    public void childExecute(String input, Game game) {
       saveGameFactory.save(game);
       io.displayText("Goodbye.");
       throw new GameExitException();
    }
}
