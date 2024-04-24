package com.mowitnow.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MowerTest {

    @Test
    public void rotateTest() {
        Mower mower = new Mower(0, 0, "N");

        mower.rotate("D");

        Assert.assertEquals("E", mower.getOrientation());

        mower.rotate("D");

        Assert.assertEquals("S", mower.getOrientation());

        mower.rotate("D");

        Assert.assertEquals("W", mower.getOrientation());

        mower.rotate("D");

        Assert.assertEquals("N", mower.getOrientation());

        mower.rotate("G");

        Assert.assertEquals("W", mower.getOrientation());

        mower.rotate("G");

        Assert.assertEquals("S", mower.getOrientation());

        mower.rotate("G");

        Assert.assertEquals("E", mower.getOrientation());

        mower.rotate("G");

        Assert.assertEquals("N", mower.getOrientation());
    }

    @Test
    public void advanceTest() {
        Mower mower = new Mower(1, 1, "N");

        mower.advance();

        Assert.assertEquals(1, mower.getX());
        Assert.assertEquals(2, mower.getY());

        mower = new Mower(1, 1, "E");

        mower.advance();

        Assert.assertEquals(2, mower.getX());
        Assert.assertEquals(1, mower.getY());

        mower = new Mower(1, 1, "S");

        mower.advance();

        Assert.assertEquals(1, mower.getX());
        Assert.assertEquals(0, mower.getY());

        mower = new Mower(1, 1, "W");

        mower.advance();

        Assert.assertEquals(0, mower.getX());
        Assert.assertEquals(1, mower.getY());
    }
}
