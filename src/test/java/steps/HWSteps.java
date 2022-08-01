package steps;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;


public class HWSteps extends CommonMethods {
    private int count = 0;
    @Test(groups = "smoke")
    public void testHW() {
        openBrowserAndLaunchApplication();
        click(CTCoHWPage.careersMenu);
        click(CTCoHWPage.vacanciesBtn);
        click(CTCoHWPage.testAutoEngVacancy);
        for (WebElement skill : CTCoHWPage.skillsOfTestAutoEng) {
            count++;
        }
        System.out.println("The count of skills is " + count);
        Assert.assertEquals(8, count);
        tearDown();
    }
}
