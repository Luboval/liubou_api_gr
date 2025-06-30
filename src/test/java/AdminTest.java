import eu.senla.model.admin.request.SendAdminRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest {

    @Test(testName = "Admin test")
    void sendAdminRequestTest() {

        Assert.assertNotNull(SendAdminRequest.sendCorrectAdminRequest().getRequestId());

    }

    @Test(testName = "Negative Admin Test")
    void sendNegativeAdminRequestTest() {

        Assert.assertEquals(SendAdminRequest.sendNegativeAdminRequest().getMessage(), "Property personalFirstName is null!");
    }
}
