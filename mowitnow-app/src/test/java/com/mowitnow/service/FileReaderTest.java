package com.mowitnow.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FileReaderTest {

	@Test
	public void readTest() {
		FileReader reader = new FileReader();

		List<String> wrongFileResult = reader.read("./src/test/resources/toto.txt");

		assertNotNull(wrongFileResult);
		assertEquals(0, wrongFileResult.size());
		
		List<String> rightFileResult = reader.read("./src/test/resources/input.txt");

		assertNotNull(rightFileResult);
		assertEquals(3, rightFileResult.size());
	}
}
