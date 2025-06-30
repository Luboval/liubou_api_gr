import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.application.GetAppStatusResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppStatusTest {
    @Test(testName = "App status test")
    public void getAppStatusTest() {
        GetAppStatusResponse response = RequestManager.getRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                ApiPoints.GETAPPSTATUSPOINT + 49551,
                GetAppStatusResponse.class);

        Assert.assertNotNull(response.getData());

    }
}
