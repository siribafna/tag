package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Inventory() {
        items.add(UniqueItems.EGGO_WAFFLE);
  //      items.add(UniqueItems.THE_ONE_RING);
     //   items.add(UniqueItems.BLUE_SHELL);
        items.add(UniqueItems.UNFORGETTABLE_MUSHROOM);
        items.add(UniqueItems.EVERLASTING_GOBSTOPPER);
      //  items.add(UniqueItems.UNFORGETTABLE_MUSHROOM);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You have these items: ";
        items.sort(new ItemComparator());
        for(Item item: items) {
            displayString += "\n" + item;
        }
        return displayString;

    }
}
