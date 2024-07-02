package testpackage;

import com.practice.challenges.singleChallengeClasses.FindMaxAverage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFindMaxAverage {
    FindMaxAverage f = new FindMaxAverage();

    @Test
    public void testFindMaxAverage() {
        assertEquals(String.valueOf(12.75000), String.valueOf(f.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)));
    }
    @Test
    public void testFindMaxAverage1() {
        assertEquals(String.valueOf(5.00000), String.valueOf(f.findMaxAverage(new int[]{5}, 1)));
    }
    @Test
    public void testFindMaxAverage2() {
        assertEquals(String.valueOf(-1.00000), String.valueOf(f.findMaxAverage(new int[]{-1}, -1)));
    }
    @Test
    public void testFindMaxAverage3() {
        assertEquals(String.valueOf(3.3333333333333335), String.valueOf(f.findMaxAverage(new int[]{3,3,4,3,0}, 3)));
    }

    @Test
    public void testFindMaxAverage4() {
        assertEquals(String.valueOf(4.00000), String.valueOf(f.findMaxAverage(new int[]{0,4,0,3,2}, 1)));
    }
    @Test
    public void testFindMaxAverage5() {
        assertEquals(String.valueOf(-594.5806451612904), String.valueOf(f.findMaxAverage(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891}, 93)));
    }

    @Test
    public void testFindMaxAverage6() {
        assertEquals(String.valueOf(12.75000), String.valueOf(f.findMaxAverage_improved(new int[]{1,12,-5,-6,50,3}, 4)));
    }
    @Test
    public void testFindMaxAverage7() {
        assertEquals(String.valueOf(5.00000), String.valueOf(f.findMaxAverage_improved(new int[]{5}, 1)));
    }
    @Test
    public void testFindMaxAverage8() {
        assertEquals(String.valueOf(-1.00000), String.valueOf(f.findMaxAverage_improved(new int[]{-1}, 1)));
    }
    @Test
    public void testFindMaxAverage9() {
        assertEquals(String.valueOf(3.3333333333333335), String.valueOf(f.findMaxAverage_improved(new int[]{3,3,4,3,0}, 3)));
    }

    @Test
    public void testFindMaxAverage10() {
        assertEquals(String.valueOf(4.00000), String.valueOf(f.findMaxAverage_improved(new int[]{0,4,0,3,2}, 1)));
    }
    @Test
    public void testFindMaxAverage11() {
        assertEquals(String.valueOf(-594.5806451612904), String.valueOf(f.findMaxAverage_improved(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891}, 93)));
    }
}
