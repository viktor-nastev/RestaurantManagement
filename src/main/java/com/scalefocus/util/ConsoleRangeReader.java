package com.scalefocus.util;

public final class ConsoleRangeReader {
    public static final String INVALID_RANGE_MESSAGE = "Min. > Max. / no good";
    public static final String NOT_WITHIN_RANGE_MESSAGE = "Input must be within %d & %d";
    private ConsoleRangeReader (){
        throw new UnsupportedOperationException();
    }

    public static int readInt (int minValue, int maxValue){
        if (minValue > maxValue){
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
        int input;
        boolean isWithinRange;

        do{
            input  = ConsoleReader.readInt();
                    isWithinRange = input>=minValue && input<=maxValue;
                    if (!isWithinRange){
                        System.out.printf(NOT_WITHIN_RANGE_MESSAGE, minValue, maxValue);

                    }
        } while (!isWithinRange);
        return input;

    }
}
