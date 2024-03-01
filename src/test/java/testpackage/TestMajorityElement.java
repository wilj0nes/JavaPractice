package testpackage;

import com.practice.challenges.ArrayChallenges;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMajorityElement {
    ArrayChallenges a = new ArrayChallenges();

    @Test
    public void testMajorityElement1() {
        assertEquals(3, a.majorityElement(new int[]{3,2,3}));
    }
    @Test
    public void testMajorityElement2() {
        assertEquals(2, a.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    @Test
    public void testMajorityElement3() {
        assertEquals(6, a.majorityElement(new int[]{6,6,6,7,7}));
    }

    @Test
    public void testMajorityElement4() {
        assertEquals(3, a.majorityElement_ConstantSpace(new int[]{3,2,3}));
    }
    @Test
    public void testMajorityElement5() {
        assertEquals(2, a.majorityElement_ConstantSpace(new int[]{2,2,1,1,1,2,2}));
    }
    @Test
    public void testMajorityElement6() {
        assertEquals(6, a.majorityElement_ConstantSpace(new int[]{6,6,6,7,7}));
    }
}
