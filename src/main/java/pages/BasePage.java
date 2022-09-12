package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import reports.ExtentLogger;

public class BasePage {

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    protected void click(By by, WaitStrategy waitStrategy,String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        element.click();
        try {
            System.out.println(elementName + " is clicked");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys(By by,String value,WaitStrategy waitStrategy,String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy,by);
        element.sendKeys(value);
        System.out.println("The value "+ value + " was sent to " + elementName);

    }

    protected String getText(By by,WaitStrategy waitStrategy,String textAttribute){

        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy,by);

        if(textAttribute.equalsIgnoreCase("text")){
            return element.getText();
        }else  if(textAttribute.equalsIgnoreCase("value")){
            return element.getAttribute("value");
        }else{
            System.out.println("attribute : " + textAttribute + "not supported . using text attribute");
            return element.getText();
        }

    }
}
