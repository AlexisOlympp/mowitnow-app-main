package com.mowitnow.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class MowerManagerTest {

    @Test
    public void isMoveBlockedTest() {
    	List<String> fileLines = new ArrayList<>();
    	fileLines.add("5 5");
    	fileLines.add("1 2 N GAGAGAGAA");
        MowerManager manager = new MowerManager();
        manager.initialize(fileLines);

        Assert.assertTrue(manager.isMoveBlocked(new Mower(2, 5, "N")));
        Assert.assertTrue(manager.isMoveBlocked(new Mower(5, 2, "E")));
        Assert.assertTrue(manager.isMoveBlocked(new Mower(2, 0, "S")));
        Assert.assertTrue(manager.isMoveBlocked(new Mower(0, 2, "W")));

        Assert.assertFalse(manager.isMoveBlocked(new Mower(2, 2, "N")));
        Assert.assertFalse(manager.isMoveBlocked(new Mower(2, 2, "E")));
        Assert.assertFalse(manager.isMoveBlocked(new Mower(2, 2, "S")));
        Assert.assertFalse(manager.isMoveBlocked(new Mower(2, 2, "W")));
    }
}
