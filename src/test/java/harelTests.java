import org.testng.annotations.Test;
import pages.travelPolicyHomePage;

import java.text.ParseException;

public class harelTests extends BaseTest{

    private harelTests(){

    }

    @Test
    public void exercise() throws ParseException {

        new travelPolicyHomePage()
                .clickFirstTimePurchaseButton()
                .verifyPageTitleContains("רכישת ביטוח נסיעות")
                .selectContinentByName("USA")
                .selectFromDate(7)
                .selectToDate(30)
                .verifyTotalDays()
                .clickOnForwardToPassengersButton()
                .verifyPageTitleContains("נשמח להכיר את הנוסעים שנבטח הפעם");






    }
}
