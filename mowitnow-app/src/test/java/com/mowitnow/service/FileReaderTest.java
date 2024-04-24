package com.mowitnow.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FileReaderTest {

	@Test
	public void readTest() {
		FileReader reader = new FileReader();
		
		
		File directory = new File("./src/test/resources/");
		   System.out.println(directory.getAbsolutePath());
		try {
			reader.read("./src/test/resources/toto.txt");
		} catch(IOException e) {
			//Assert
		}
		
		try {
			reader.read("./src/test/resources/input.txt");
		} catch(IOException e) {
			//Assert
		}
		
		assertEquals(5, reader.getMaxX());
		assertEquals(5, reader.getMaxY());
		assertNotNull(reader.getCommandList());
		assertEquals(2, reader.getCommandList().size());
	}
}
