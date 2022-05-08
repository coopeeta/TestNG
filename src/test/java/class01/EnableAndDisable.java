package class01;

import org.testng.annotations.Test;

public class EnableAndDisable {

    // used to disable a test case (e.g. if there's a defect)
    @Test(enabled = false)
    public void FirstTest() {
        System.out.println("1st");
    }

    @Test
    public void SecondTest() {
        System.out.println("2nd");
    }

    @Test
    public void ThirdTest() {
        System.out.println("3rd");
    }
}