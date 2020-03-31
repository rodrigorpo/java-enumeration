package com.rpolnx.basic;

import java.util.Arrays;

enum CardinalPoint {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

enum DayOfWeek {
    SUNDAY(1, true),
    MONDAY(2, false),
    TUESDAY(3, false),
    WEDNESDAY(4, false),
    THURSDAY(5, false),
    FRIDAY(6, false),
    SATURDAY(7, true);

    DayOfWeek(int number, boolean isWeekend) {
        this.number = number;
        this.isWeekend = isWeekend;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    private int number;
    private boolean isWeekend;
}

public class Basic {
    public static void main(String[] args) {
        CardinalPoint east = CardinalPoint.EAST;
        CardinalPoint west = CardinalPoint.WEST;
        CardinalPoint north = CardinalPoint.NORTH;
        CardinalPoint south = CardinalPoint.SOUTH;

        //How to get all values?
        CardinalPoint[] allValues = Basic.getAllFromEnum();

        //How to get an enum from String?
        CardinalPoint singleValue = Basic.getEnumFromString("NORTH");

        //How to iterate on them?
        Basic.iterateOnEnum();
    }

    private static void iterateOnEnum() {
        //Traditional for style
        for (CardinalPoint point : CardinalPoint.values()) {
            //Do what you want
        }

        //Functional style
        Arrays.stream(CardinalPoint.values())
                .map(Object::toString) //Do some functional job
                .forEach(System.out::println);
    }

    /**
     * @param point a string to find as enum
     * @return a single CardinalPoint
     * @throws IllegalArgumentException in case of string not mapped as enum
     */
    private static CardinalPoint getEnumFromString(String point) {
        try {
            return CardinalPoint.valueOf(point);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @return an array containing all enumerations
     */
    private static CardinalPoint[] getAllFromEnum() {
        return CardinalPoint.values();
    }
}
