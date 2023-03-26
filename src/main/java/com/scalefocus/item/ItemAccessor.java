package com.scalefocus.item;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ItemAccessor {
    private static final String ITEMS_FILE_PATH = "src/main/Items.txt.txt";
    public static final BufferedWriter writer;
    public static final BufferedReader reader;



    static {
        try {
            writer = new BufferedWriter(new FileWriter(ITEMS_FILE_PATH, true));
            reader = new BufferedReader(new FileReader(ITEMS_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("File not found with path: "+ ITEMS_FILE_PATH, e);
        }
    }

    public void addItem(String string){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter (ITEMS_FILE_PATH, true))){
            writer.write(string + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Issues with adding Item: ", e);
        }
    }


    public List<String> readAllItems(){

        try (BufferedReader reader = new BufferedReader( new FileReader(ITEMS_FILE_PATH))){
            return reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void overwriteFile(String items){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter (ITEMS_FILE_PATH))){
            writer.write(items);
        } catch (IOException e) {
            throw new RuntimeException("Issues with adding Item: ", e);
        }
    }
}
