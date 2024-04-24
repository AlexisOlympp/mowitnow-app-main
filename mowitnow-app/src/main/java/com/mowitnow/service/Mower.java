package com.mowitnow.service;

import org.apache.log4j.Logger;

public class Mower {

    private final Logger logger = Logger.getLogger(Mower.class);
    private int x;
    private int y;

    private String orientation;

    public Mower(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOrientation() {
        return orientation;
    }

    public void rotate(String direction) {
        switch (direction) {
            case "D":
                switch (orientation) {
                    case "N" -> orientation = "E";
                    case "E" -> orientation = "S";
                    case "S" -> orientation = "W";
                    case "W" -> orientation = "N";
                    default -> {
                        logger.error("Orientation is not N,E,S or W.");
                    }
                }
                break;
            case "G":
                switch (orientation) {
                    case "N" -> orientation = "W";
                    case "W" -> orientation = "S";
                    case "S" -> orientation = "E";
                    case "E" -> orientation = "N";
                    default -> {
                        logger.error("Orientation is not N,E,S or W.");
                    }
                }
                break;
            default:
        }
    }

    public void advance() {
        switch (orientation) {
            case "N":
                y = y + 1;
                break;
            case "E":
                x = x + 1;
                break;
            case "S":
                y = y - 1;
                break;
            case "W":
                x = x - 1;
                break;
            default:
                logger.error("Orientation is not N,E,S or W.");
        }
    }

    public String describe() {

        return x + " " + y + " " + orientation;
    }
}
