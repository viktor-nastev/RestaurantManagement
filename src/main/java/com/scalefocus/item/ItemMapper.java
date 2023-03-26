package com.scalefocus.item;

import java.util.List;

public class ItemMapper {
    public Item mapStringToItem(String string) {
        String[] tokens = string.split("_");
        int id;
        String name = tokens[1];
        int size;
        double price;
        try {
            id = Integer.parseInt(tokens[0]);
            size = Integer.parseInt(tokens[2]);
            price = Double.parseDouble(tokens[3]);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Item with name: " + name + "saved with invalid state");
        }
        return new Item(id, name, size, price);
    }

    public String mapItemToString(Item item) {
        int id = item.getId();
        String name = item.getName();
        int size = item.getSize();
        double price = item.getPrice();
        return String.join("_", Integer.toString(id), name, Integer.toString(size), Double.toString(price));
    }


    public String mapItemListToString (List<Item> itemList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : itemList) {
            String itemString = mapItemToString(item);
            stringBuilder.append(itemString).append("\n");
        }
        return stringBuilder.toString();
    }
}