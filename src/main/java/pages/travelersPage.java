package pages;

import org.testng.Assert;

public final class travelersPage extends BasePage {

    public travelersPage verifyPageTitleContains(String partialPageTitle){
        Assert.assertTrue(getPageTitle().indexOf(partialPageTitle)==0);
        return this;

    }
}
