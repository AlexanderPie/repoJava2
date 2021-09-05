import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson6TestsTask1JUnit4 {

    private Lesson6Tests dz;

    @Before
    public void prepare(){
        dz = new Lesson6Tests();
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_empty_array(){
        dz.doTask1(new int[0]);
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_without_4(){
        dz.doTask1(new int[]{1, 1, 1, 3});
    }

    @Test
    public void test_task1_with_some_4_is_not_last(){
        int[] data = {1, 2, 3, 4, 5, 6};
        Assert.assertArrayEquals(new int[]{5, 6}, dz.doTask1(data));
    }

    @Test
    public void test_task1_with_some_4(){
        int[] data = {1, 2, 4, 3, 4, 6, 7, 4};
        Assert.assertArrayEquals(new int[]{}, dz.doTask1(data));
    }

}
