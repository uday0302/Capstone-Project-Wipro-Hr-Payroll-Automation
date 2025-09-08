package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementUtils;

import java.time.Duration;

public class EmployeePage {

    private WebDriver driver;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }
    private By empMenu = By.xpath("//span[text()='PIM']");
    private By empSearchMenu = By.xpath("//a[text()='Employee List']"); 

    private By resultRow = By.xpath("//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-card')]");
    private By noRecordMessage = By.xpath("//span[contains(@class,'oxd-text--span') and text()='No Records Found']");

    
    public void navigateToEmployeeSearch() {
        ElementUtils.click(empMenu);         
        ElementUtils.click(empSearchMenu);   
    }

    
 
    private By nameField = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");

   
    private By empIdInput = By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    private By searchButton = By.xpath("//button[contains(@class,'oxd-button') and contains(@class,'orangehrm-left-space')]");

    public void searchEmployeeByName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        ElementUtils.type(nameField, name);
    }

    public void searchEmployeeById(String empId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(empIdInput));
        ElementUtils.type(empIdInput, empId);
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        ElementUtils.click(searchButton);
    }

    public boolean isRecordFound() {
        if (!driver.findElements(noRecordMessage).isEmpty()) {
            return false;
        }
        return !driver.findElements(resultRow).isEmpty();
    }

}
