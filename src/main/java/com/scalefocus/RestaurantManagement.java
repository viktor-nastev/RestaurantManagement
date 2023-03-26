package com.scalefocus;

import com.scalefocus.item.ItemAccessor;
import com.scalefocus.item.ItemPresenter;
import com.scalefocus.util.ConsoleRangeReader;
import com.scalefocus.util.ConsoleReader;

import java.util.List;
import java.util.Scanner;

public class RestaurantManagement {
    private static final String GREETING_MESSAGE = "Please choose what to do:\n" + "1: Items";
    public static final String PLACEHOLDER_1 = "Add more functionality here";
    public static final String PLACEHOLDER_2 = "Add even more functionality here";
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 3;

    public static final ItemPresenter itemPresenter = new ItemPresenter();
//    private static final Scanner scanner = new Scanner(System.in);


//    private static final ItemAccessor itemAccessor = new ItemAccessor();
//        itemAccessor.addItem("Hello World");
//        System.out.println("Writing successfully...");
//        List<String > allItemsList = itemAccessor.readAllItems();
//        System.out.println(allItemsList);

    public static void main(String[] args) {
        while (true) {
            System.out.println(GREETING_MESSAGE);
            int choice = ConsoleRangeReader.readInt(MIN_MENU_OPTION, MAX_MENU_OPTION);
            switch (choice){
                case 1:
                    itemPresenter.showItemMenu();
                    break;
                case 2:
                    System.out.println(PLACEHOLDER_1);
                    break;
                case 3:
                    System.out.println(PLACEHOLDER_2);
                    break;


            }

        }
    }
}
