package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class travelPolicyHomePage extends BasePage {

    private String firstTimeCustomerButton = "//button[contains(@data-hrl-bo,'new-customer')]";

    public destinationPage clickFirstTimePurchaseButton(){
        click(By.xpath(firstTimeCustomerButton), WaitStrategy.CLICKABLE,"First Time Purchase Button Is clicked");
        return new destinationPage();

    }

}
