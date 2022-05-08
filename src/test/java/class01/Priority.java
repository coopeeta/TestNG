package class01;

import org.testng.annotations.Test;

public class Priority {

    // by default priority executes in alphabetical order of the class name
    // or priority can be set next to annnotation --> (priority = 3)
    @Test(priority = 3)
    public void FirstTest() {
        System.out.println("1st");
    }

    @Test(priority = 2)
    public void SecondTest() {
        System.out.println("2nd");
    }

    @Test(priority = 1)
    public void ThirdTest() {
        System.out.println("3rd");
    }
}
