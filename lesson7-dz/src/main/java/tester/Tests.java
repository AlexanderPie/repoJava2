package tester;

public class Tests {

    @BeforeSuit
    public void prepare(){
        System.out.println("making prep");
    }

    @Test(priority = Test.Priority.VERY_LOW)
    public void test1(){
        System.out.println("In test 5");
    }

    @Test(priority = Test.Priority.LOW)
    public void test2(){
        System.out.println("In test 4");
    }

    @Test(priority = Test.Priority.MAX_PRIORITY)
    public void test3(){
        System.out.println("In test 1");
    }

    @Test(priority = Test.Priority.HIGHEST)
    public void test4(){
        System.out.println("In test 2");
    }

    @Test
    public void test5(){
        System.out.println("In test 3");
    }

    @AfterSuit
    public void cleanup(){
        System.out.println("making cleanup");
    }


}
