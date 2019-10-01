package org.improving.tag;

import org.improving.tag.commands.InventoryCommand;

public class Player {
    private String name;
    private int hitPoints = 100;
    private Location location;
    private Inventory inventory = new Inventory();

    public Player(Location location) {
        this.location = location; // constructor is only called the first time, therefore setting in the first location
        //setters are used to constantly change, constructor can only be run once.
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHitPoints() { return hitPoints; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public Inventory getInventory() {
        return inventory;
    }


}
