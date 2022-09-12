package factories;

import constants.FrameworkConstants;
import driver.Driver;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitFactory {

    //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.MINUTES);
    //wait.until(d->d.findElement(link_logout).isEnabled()); //java 8
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement element=null;
        if(waitStrategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait())) // old way
                    .until(ExpectedConditions.elementToBeClickable(by));
        }else if(waitStrategy ==  WaitStrategy.PRESENTS){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait())) // old way
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }else if(waitStrategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait())) // old way
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }else if(waitStrategy == WaitStrategy.CLICKABLE){
            System.out.println("No need for explicit wait");
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }

    public static List<WebElement> performExplicitWaitForListOfElements(String xpath){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(50)) // old way
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
