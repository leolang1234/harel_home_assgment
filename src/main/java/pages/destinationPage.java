package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import utils.DynamicXpathUtils;
import utils.TimeAndDate;

import java.text.ParseException;
import java.util.List;

public class destinationPage extends BasePage {


    private String coninentOrigPath = "//div[@data-hrl-bo='%s']";

    private String startDate = "//input[contains(@id,'start')]";
    private String endDate = "//input[contains(@id,'end')]";
    private String monthsHeader = "//div[contains(@class,'switchHeader')]";
    private String nextMonthButton = "//Button[contains(@data-hrl-bo,'forward')]";

    private String selectSingleDate = "//div[@class='MuiPickersSlideTransition-transitionContainer MuiPickersCalendar-transitionContainer'][1]//span[text()='%s']";

    private String totalVacationDays = "//span[@data-hrl-bo='total-days']";

    private String continueToPassengersButton = "//button[@datahrlbo='wizard-next-button']";



    public destinationPage verifyPageTitleContains(String partialPageTitle){
        Assert.assertTrue(getPageTitle().indexOf(partialPageTitle)==0);
        return this;
    }

    public destinationPage selectContinentByName(String continantName){

        String coninentXpath = DynamicXpathUtils.getXpath(coninentOrigPath,continantName);
        click(By.xpath(coninentXpath), WaitStrategy.PRESENTS,"Selected continent : "+continantName);
        return this;
    }

    public String getSelectedFromDate(){
        String value = getText(By.xpath(startDate),WaitStrategy.PRESENTS,"value");
        return value;
    }

    public String getSelectedToDate(){
        String value = getText(By.xpath(endDate),WaitStrategy.PRESENTS,"value");
        return value;
    }

    public destinationPage selectFromDate(int range){
        //get future date from range
        int futureStartDate = TimeAndDate.getDayFromRange(range);

        moveDatePicker(range);

        String newXpath = DynamicXpathUtils.getXpath(selectSingleDate, String.valueOf(futureStartDate));
        click(By.xpath(newXpath),WaitStrategy.CLICKABLE,"Selecting date : "+ futureStartDate);

        return this;
    }

    public destinationPage selectToDate(int range) throws ParseException {
        Integer selectedStartDate = TimeAndDate.getDayFromString(getSelectedFromDate());
        range = range +selectedStartDate;
        int futureEndDate = TimeAndDate.getDayFromRange(range);
        System.out.println("futureEndDate : " + futureEndDate);
        //System.out.println("getSelectedFromDate : " + getSelectedFromDate());
        //System.out.println("using from date : "+ TimeAndDate.getDayFromString(getSelectedFromDate()));

        moveDatePicker(range);

        String newXpath = DynamicXpathUtils.getXpath(selectSingleDate, String.valueOf(futureEndDate));
        futureEndDate=futureEndDate%30;
        click(By.xpath(newXpath),WaitStrategy.CLICKABLE,"Selecting date : "+ futureEndDate);

        return this;
    }

    public void moveDatePicker(int totalDays){
        //get date picker back and forward buttons
        List<WebElement> elements = ExplicitWaitFactory.performExplicitWaitForListOfElements(monthsHeader);

        //move the picker to the relevant start date
        for(int i=0;i<(totalDays)/30;i++){
            elements.get(1).findElement(By.xpath(nextMonthButton)).click();
        }
    }

    public destinationPage verifyTotalDays(){
        System.out.println("from date :" + getSelectedFromDate());
        System.out.println("To date : " +getSelectedToDate());
        System.out.println("Total days : " + getText(By.xpath(totalVacationDays),WaitStrategy.PRESENTS,"text").split(" ")[1]);

        return this;
    }

    public travelersPage clickOnForwardToPassengersButton(){
        click(By.xpath(continueToPassengersButton),WaitStrategy.CLICKABLE,"Click Forward to passengers");
        return new travelersPage();
    }

}
