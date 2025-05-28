import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.AdminRequest;
import eu.senla.model.PostAdminResponse;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AdminTest {
    AdminRequest request;
    @BeforeTest
    public void setup() {
        Faker faker = new Faker();
        request = new AdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );
        System.out.println("Request " + request);
    }

    @Test(testName = "Admin test")
    void sendAdminRequestTest() {
        PostAdminResponse response = RequestManager.postAdminRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                ApiPoints.POSTADMINPOINT,
                request,
                PostAdminResponse.class);

        Assert.assertNotNull(response.getRequestId());

    }
}
