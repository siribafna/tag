package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exit {
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<>();

    public Exit() {}

    public Exit(String name, Location destination, String...aliases) { // parameter ... shows continuation of what should be under one list
      this.name = name;
      this.destination = destination;
      this.aliases.addAll(Arrays.asList(aliases)); // puts in parameters into the list of aliases as members
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAlias() {
        return aliases;
    }

}
