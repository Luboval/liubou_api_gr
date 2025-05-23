import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.GetApplicationResponse;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void getApp() {
       GetApplicationResponse response = RequestManager.getRequest(SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/getApplications",
               GetApplicationResponse.class);

        System.out.println(response);



        //Assert.assertNotNull(response.getRequestId());
    }
}
