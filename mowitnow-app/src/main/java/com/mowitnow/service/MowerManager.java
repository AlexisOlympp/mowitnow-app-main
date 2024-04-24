package com.mowitnow.service;

import org.apache.log4j.Logger;

import java.util.List;

public class MowerManager {
    private final int MIN_X = 0;
    private final int MIN_Y = 0;

    private final Logger logger = Logger.getLogger(MowerManager.class);

    private int maxX;
    private int maxY;

    private List<String> commandList;

    public MowerManager(int maxX, int maxY, List<String> commandList) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.commandList = commandList;
    }

    public void execute() {
        for (String command : commandList) {
            String[] commandData = command.split(" ");
            int x = Integer.parseInt(commandData[0]);
            int y = Integer.parseInt(commandData[1]);
            String orientation = commandData[2];
            String orders = commandData[3];

            Mower mower = new Mower(x, y, orientation);

            char[] ordersArray = orders.toCharArray();

            for (char ch : ordersArray) {
                switch (ch) {
                    case 'G':
                        mower.rotate("G");
                        break;
                    case 'D':
                        mower.rotate("D");
                        break;
                    case 'A':
                        if (isMoveBlocked(mower)) {
                            logger.info("The move is blocked.");
                            continue;
                        } else {
                            mower.advance();
                        }
                        break;
                    default:
                        logger.error("Order must be G,D or A.");
                }
            }

            System.out.println(mower.describe());
        }
    }

    public boolean isMoveBlocked(Mower mower) {
        return (mower.getY() == maxY && mower.getOrientation().equals("N"))
                || (mower.getX() == maxX && mower.getOrientation().equals("E"))
                || (mower.getY() == MIN_Y && mower.getOrientation().equals("S"))
                || (mower.getX() == MIN_X && mower.getOrientation().equals("W"));
    }
}
