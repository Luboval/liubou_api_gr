import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.ChangeStatusRequest;
import eu.senla.model.PostChangeStatusResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeStatusTest {
    ChangeStatusRequest request;

    @BeforeTest
    public void setup() {

        request = new ChangeStatusRequest(
                "approved",
                49551,
                27472);

    }

    @Test(testName = "Change status test")
    public void changeStatusTest() {
        PostChangeStatusResponse response = RequestManager.postAdminRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                ApiPoints.POSTCHANGESTATUSPOINT,
                request,
                PostChangeStatusResponse.class);
        Assert.assertEquals(response.getData().getFirst().getStatusOfApplication(), "approved");

    }
}
