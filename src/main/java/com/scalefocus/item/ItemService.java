package com.scalefocus.item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    public static final ItemAccessor itemAccessor = new ItemAccessor();
    public static final ItemMapper itemMapper = new ItemMapper();

    public List<Item> getAllItems() {
        List<String> itemStrings = itemAccessor.readAllItems();
        List<Item> items = new ArrayList<>();
        for (String itemString : itemStrings) {
            Item item = itemMapper.mapStringToItem(itemString);
            items.add(item);
        }
        return items;
    }

    public void addItem(String name, int size, double price) {
        int id = itemAccessor.readAllItems().size() + 1;
        Item item = new Item(id, name, size, price);
        String itemString = itemMapper.mapItemToString(item);
        itemAccessor.addItem(itemString);
    }

    public void editItem(int id, String name, int size, double price) {

        List<Item> items = getAllItems();
        Item itemToEdit = getItemByIdFromList(id, items);

/*        if (id > items.size() || id < 1) {
            System.out.println("Id doesn't exist");
            return;
        } else {
            Item itemToEdit = null;
            for (Item item : items) {
                if (item.getId() == id) {
                    itemToEdit = item;
                    break;
                }
            }*/
//        Item itemToEdit = getItemByIdFromList(id);
        if (itemToEdit == null) {
            return;
        }

        itemToEdit.setName(name);
        itemToEdit.setSize(size);
        itemToEdit.setPrice(price);

        String itemsString = itemMapper.mapItemListToString(items);
        itemAccessor.overwriteFile(itemsString);

    }


    public void removeItem(int id) {
        List<Item> items = getAllItems();
        Item itemToRemove = getItemByIdFromList(id, items);

        items.remove(itemToRemove);
        for(int i = itemToRemove.getId()-1; i < items.size(); i++){
            items.get(i).setId(i+1);

        }

        String itemsString = itemMapper.mapItemListToString(items);
        itemAccessor.overwriteFile(itemsString);


    }

    private Item getItemByIdFromList(int id, List<Item> items) {
//        List<Item> items = getAllItems();
        if (id >= items.size() || id < 1) {
            System.out.println("Id doesn't exist");
            return null;
        }
        Item item = null;
        for (Item itemInList : items) {
            if (itemInList.getId() == id) {
                item = itemInList;
                break;
            }
        }
        return item;
    }
}