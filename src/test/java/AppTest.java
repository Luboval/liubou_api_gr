import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.GetApplicationResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {


    @Test(testName = "Application test")
    public void getApp() {
       GetApplicationResponse response = RequestManager.getRequest(SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
               ApiPoints.GETAPPLICATIONPOINT,
               GetApplicationResponse.class);

       Assert.assertNotNull(response.getTotal());
    }
}
