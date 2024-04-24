package com.mowitnow;

import com.mowitnow.service.FileReader;
import com.mowitnow.service.MowerManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        System.out.println("Enter the path of the file: ");


        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        in.close();

        FileReader reader = new FileReader();
        try {
            reader.read(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        MowerManager manager = new MowerManager(reader.getMaxX(), reader.getMaxY(), reader.getCommandList());
        manager.execute();
    }
}