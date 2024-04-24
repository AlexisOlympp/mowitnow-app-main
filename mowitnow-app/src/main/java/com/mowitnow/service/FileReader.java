package com.mowitnow.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class FileReader {
	
	private final Logger logger = Logger.getLogger(FileReader.class);
    private int maxX;
    private int maxY;

    private List<String> commandList;

    public FileReader() {

    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public List<String> getCommandList() {
        return commandList;
    }

    public void read(final String fileName) throws FileNotFoundException {
        List<String> fileLine = new ArrayList<>();

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileLine.add(line);
            }

        } catch (FileNotFoundException e) {
            logger.error("Le fichier est introuvable !");
            throw e;
        }

        String size = fileLine.removeFirst();
        String[] xy= size.split(" ");
        maxX = Integer.parseInt(xy[0]);
        maxY = Integer.parseInt(xy[1]);

        commandList = fileLine;

    }
}
