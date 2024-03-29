package org.improving.tag;

import org.improving.tag.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name = ""; // put an empty string as initialization
    private String description = "";
    private List<String> tags = new ArrayList<>(); // dont have to do <String>, java knows
    private List<Exit> exits = new ArrayList<>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE; // makes a null treasure chest


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public Adversary getAdversary() { return adversary; }

    public void setAdversary(Adversary adversary) { this.adversary = adversary; }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }
    public TreasureChest getTreasureChest() {
        return treasureChest;
    }
    public String getTreasureDescription() {
        return treasureChest.getDescription();
    }

    public Item getTreasureItem() {
        return treasureChest.getItem();
    }

    public Item openTreasureChest() {
        if(TreasureChest.NO_TREASURE.equals(treasureChest))
            throw new UnsupportedOperationException();
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }

    @Override
    public String toString() {
        return this.getName(); //.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }
        return super.equals(obj);
    }
}

