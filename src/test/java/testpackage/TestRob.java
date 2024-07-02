package testpackage;

import com.practice.challenges.singleChallengeClasses.HouseRobber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestRob {
    HouseRobber h = new HouseRobber();

    @Test
    public void testRob1() {
        assertEquals(4, h.rob_FUNCTIONAL_ATTEMPT(new int[]{1,2,3,1}));
    }

    @Test
    public void testRob2() {
        assertEquals(12, h.rob_FUNCTIONAL_ATTEMPT(new int[]{2,7,9,3,1}));
    }

    @Test
    public void testRob4() {
        assertNotEquals(12, h.rob_FUNCTIONAL_ATTEMPT(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    }

    @Test
    public void testRob_FORK1() {
        assertEquals(4, h.rob_FORK(new int[]{1,2,3,1}));
    }

    @Test
    public void testRob_FORK2() {
        assertEquals(12, h.rob_FORK(new int[]{2,7,9,3,1}));
    }

    @Test
    public void testRob_FORK3() {
        assertNotEquals(12, h.rob_FORK(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    }

    @Test
    public void testRob_MEMO1() {
        assertEquals(4, h.rob(new int[]{1,2,3,1}));
    }

    @Test
    public void testRob_MEMO2() {
        assertEquals(12, h.rob(new int[]{2,7,9,3,1}));
    }

    @Test
    public void testRob_MEMO3() {
        assertNotEquals(12, h.rob(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    }

}
