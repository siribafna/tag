package org.improving.tag.items;

//enums are basically constants, singletons


public enum UniqueItems implements Item{

    THE_ONE_RING("a golden ring!"), BLUE_SHELL("a blue shell with wings!"), NOTHING("") {
    };

    private final String description;

    UniqueItems(String description) {
        this.description = description;
   }
    @Override
    public String toString() {
        return description;
    }




}
