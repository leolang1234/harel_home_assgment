import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

    protected BaseTest(){}


    @Parameters("browserName")
    @BeforeMethod
    protected void setUp(@Optional("browserName") String browserName) throws Exception {
        Driver.initDriver(browserName);
    }

    @AfterMethod
    protected void tearDown(){
       Driver.quitDriver();
    }

}
