package com.scalefocus.item;

import com.scalefocus.util.ConsoleRangeReader;
import com.scalefocus.util.ConsoleReader;

import java.util.List;

public class ItemPresenter {
    public static final ItemService itemService = new ItemService();
    private static final String OPTIONS = "Choose what to do with the items: \n1: Read all items\n2: Add an item\n3: Edit items\n" +
            "4: Remove an item";
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 4;
    public static final String ITEM_NAME_PROMPT = "Enter Item name:";
    public static final String ITEM_SIZE_PROMPT = "Enter Item size:";
    public static final String ITEM_PRICE_PROMPT = "Enter Item price:";
    public static final String ITEM_ID_PROMPT = "Enter Item ID:";

    public void showItemMenu() {
        System.out.println(OPTIONS);
        int choice = ConsoleRangeReader.readInt(MIN_MENU_OPTION, MAX_MENU_OPTION);
//        int choice = ConsoleRangeReader.readInt(5,1);
        System.out.println("You chose: " + choice);
        switch (choice) {
            case 1:
                printAllItems();
                break;
            case 2:
                addItem();
                break;
            case 3:
                editItem();
                break;
            case 4:
                removeItem();
                break;



        }

    }

    public void addItem() {
        System.out.println(ITEM_NAME_PROMPT);
        String name = ConsoleReader.readString();
        System.out.println(ITEM_SIZE_PROMPT);
        int size = ConsoleReader.readInt();
        System.out.println(ITEM_PRICE_PROMPT);
        double price = ConsoleReader.readDouble();

        itemService.addItem(name, size, price);


    }

    public void printAllItems() {
        List<Item> items = itemService.getAllItems();//
        for(Item item: items){
            System.out.println(item);
        }

    }

    public void editItem() {
        System.out.println(ITEM_ID_PROMPT);
        int id = ConsoleReader.readInt();
        System.out.println(ITEM_NAME_PROMPT);
        String name = ConsoleReader.readString();
        System.out.println(ITEM_SIZE_PROMPT);
        int size = ConsoleReader.readInt();
        System.out.println(ITEM_PRICE_PROMPT);
        double price = ConsoleReader.readDouble();

        itemService.editItem(id, name, size, price);

    }

    public void removeItem() {
        System.out.println(ITEM_ID_PROMPT);
        int id = ConsoleReader.readInt();

        itemService.removeItem(id);

    }


}
