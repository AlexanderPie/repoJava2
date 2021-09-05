import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson6TestsTask2 {

    private Lesson6Tests dz;

    @Before
    public void prepare(){
        dz = new Lesson6Tests();
    }

    @Test
    public void test_task2_empty_array(){
        Assert.assertFalse(dz.doTask2(new int[]{}));
    }

    @Test
    public void test_task2_only_1_and_4(){
        Assert.assertTrue(dz.doTask2(new int[]{1, 4, 4, 1}));
    }

    @Test
    public void test_task2_1_and_4_and_others(){
        Assert.assertFalse(dz.doTask2(new int[]{1, 2, 4, 4}));
    }

    @Test
    public void test_task2_without_1_and_4(){
        Assert.assertFalse(dz.doTask2(new int[]{5, 6, 7}));
    }

    @Test
    public void test_task2_only_1(){
        Assert.assertFalse(dz.doTask2(new int[]{1, 1, 1}));
    }

    @Test
    public void test_task2_only_4(){
        Assert.assertFalse(dz.doTask2(new int[]{4, 4}));
    }

}
