package org.improving.tag;

import org.improving.tag.commands.*;

import java.util.Date;
import java.util.Scanner;

public class Game {

    private Date startTime;
    private Date endTime;

    private BaseEmoteCommand[] commands;

    public Game() {
        commands = new BaseEmoteCommand[]{
                new LookCommand(),
                new DanceCommand(),
                new JumpCommand(),
                new InventoryCommand()
        };

    }

    public Date getStartTime() { return startTime; }
    private void setStartTime(Date val) { this.startTime = val; }

    public Date getEndTime() { return endTime; }
    private void setEndTime(Date endTime) { this.endTime = endTime; }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());
        boolean loop = true;

        while(loop) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            BaseEmoteCommand validCommand = getValidCommand(input);
            if (null != validCommand)
                validCommand.execute(input);
            else if (input.equals("exit")) {
                System.out.println("Goodbye.");
                loop = false; // leave the loop
            }
            else {
                System.out.println("Huh, I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }

    private BaseEmoteCommand getValidCommand(String input) {
        BaseEmoteCommand validCommand = null;
        for(BaseEmoteCommand eachCommand: commands) {
            if(eachCommand.isValid(input))
                return eachCommand;
        }
        return null;
    }
}

