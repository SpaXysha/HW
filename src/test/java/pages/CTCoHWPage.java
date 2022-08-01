package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CTCoHWPage extends CommonMethods {

    @FindBy(xpath = "//a[@href='https://ctco.lv/careers/']")
    public WebElement careersMenu;

    @FindBy(xpath = "//a[@href='https://ctco.lv/careers/vacancies/']")
    public WebElement vacanciesBtn;

    @FindBy(xpath = "//a[@href='https://ctco.lv/careers/vacancies/test-automation-engineer-3/']")
    public WebElement testAutoEngVacancy;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div[9]/div/div/ul[1]/li")
    public List<WebElement> skillsOfTestAutoEng;


    public CTCoHWPage(){
        PageFactory.initElements(driver,this);
    }
}
