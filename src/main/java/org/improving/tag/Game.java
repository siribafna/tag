package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Game {

    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private final SaveGameFactory saveFactory;
    public Game(Command [] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }
    public Location getStartingLocation() { return startingLocation; }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() { return startTime; }
    private void setStartTime(Date val) { this.startTime = val; }

    public Date getEndTime() { return endTime; }
    private void setEndTime(Date endTime) { this.endTime = endTime; }

    public void run() {

        this.setStartTime(new Date());
        boolean loop = true;

        while(loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();

            Command validCommand = getValidCommand(input);
            if (null != validCommand)
                validCommand.execute(input, this);
            else if (input.equalsIgnoreCase("exit")) {
                saveFactory.save(this); // saving the path now onto the class
                io.displayText("Goodbye.");
                loop = false; // leave the loop
            }
            else {
                io.displayText("Huh, I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        Command validCommand = null;
        for(Command eachCommand: commands) {
            if(eachCommand.isValid(input, this))
                return eachCommand;
        }
        return null;
    }

    private Location buildWorld() {

        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
        td.setName("The Desert");

        var ta = new Location();
        ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese Shop");

        var tict = new Location();
        tict.setName("The Ice Cream Truck");

        var air = new Location();
        air.setName("The Airport");

        var tmo = new Location();
        tmo.setName("The Mountains");

        var tr = new Location();
        tr.setName("The Reef");

        var tma = new Location();
        tma.setName("The Mall");

        var md = new Location();
        md.setName("Mountain Doom");

        var tvm = new Location();
        tvm.setName("THe Velvet Moose");

        var tvod = new Location();
        tvod.setName("The Volcano of Death");

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "deathly", "brownie"));

        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("The Dock", air, "dock", "tdock"));
        td.getExits().add(new Exit("Rocky Road", tict, "rocky", "rroad", "rr"));

        tmcs.getExits().add(new Exit("Highway 121", ta, "hwy", "121", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Highway 21", tvod, "hwy21", "21", "hwy 21", "h21"));
        tmcs.getExits().add(new Exit("Paradise Road", tr, "paradise", "proad"));

        tict.getExits().add(new Exit("Magic Portal", md, "magic", "portal", "mp"));

        air.getExits().add(new Exit("Flight to the Mall", tma, "flight", "flight2mall", "f2m"));
        air.getExits().add(new Exit("Flight 121", tmo, "flight", "f121"));

        tmo.getExits().add(new Exit("The Lava Flow", tvod, "lava", "flow", "lf"));
        tmo.getExits().add(new Exit("The Narrow Trail", md, "narrow", "trail", "nt"));
        tmo.getExits().add(new Exit("The Plane", ta, "plane", "theplane", "tp"));
        tmo.getExits().add(new Exit("Bike Trail", tr, "bike", "trail", "bt"));

        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "am", "amazing", "moose", "am"));

        tr.getExits().add(new Exit("The City Walk", tma, "city", "walk", "citywalk", "cw"));
        tr.getExits().add(new Exit("The Scenic Route", tvm, "scenic", "route", "sr", "tsr"));

        tma.getExits().add(new Exit("Path to Doom", md, "path", "doom", "p2d", "path2doom"));
        tma.getExits().add(new Exit("An Escalator to Doom", tvod, "escalator", "doom", "e2d", "escalator2doom"));

        md.getExits().add(new Exit("Jump Into Lava", tvod, "jump", "into", "lava", "j2l"));
        md.getExits().add(new Exit("The Cab", tma, "cab", "c", "tcab", "tc"));

        tvm.getExits().add(new Exit("The Pudding Slide", air, "pudding", "slide", "ps"));
        tvm.getExits().add(new Exit("The Front Door", ta, "front", "door", "fd", "tfd"));

        return tdh;
    }
}

