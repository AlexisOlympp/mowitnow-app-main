package com.mowitnow.service;

import org.apache.log4j.Logger;

import java.util.List;

public class MowerManager {
	private final Logger logger = Logger.getLogger(MowerManager.class);

	private Garden garden;
	private List<String> commandList;

	public MowerManager() {

	}

	public void initialize(List<String> fileLines) {
		String size = fileLines.removeFirst();
		String[] xy = size.split(" ");

		garden = new Garden();

		garden.setMaxX(Integer.parseInt(xy[0]));
		garden.setMaxY(Integer.parseInt(xy[1]));

		commandList = fileLines;
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
		return (mower.getY() == garden.getMaxY() && mower.getOrientation().equals("N"))
				|| (mower.getX() == garden.getMaxX() && mower.getOrientation().equals("E"))
				|| (mower.getY() == garden.getMIN_Y() && mower.getOrientation().equals("S"))
				|| (mower.getX() == garden.getMIN_X() && mower.getOrientation().equals("W"));
	}
}
