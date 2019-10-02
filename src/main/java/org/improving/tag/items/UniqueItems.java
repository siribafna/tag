package org.improving.tag.items;

//enums are basically constants, singletons


public enum UniqueItems implements Item{

    THE_ONE_RING("a golden ring!", "The One Ring"),
    BLUE_SHELL("a blue shell with wings!", "Blue Shell"),
    UNFORGETTABLE_MUSHROOM("An edible toad", "Unforgettable Mushroom"),
    EGGO_WAFFLE("A healthy breakfast", "Eggo Waffle"),
    EVERLASTING_GOBSTOPPER("A gobstobber that never loses its flavor", "Everlasting Gobstopper"),
    NOTHING("", "") {};

    private final String description;
    private final String name;

    UniqueItems(String description, String name) {
        this.description = description;
        this.name = name;
   }
    @Override
    public String toString() {
        return name + ": " + description;
    }

    @Override
    public String getName() {
        return name;
    }





}
