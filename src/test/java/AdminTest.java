import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.AdminRequest;
import eu.senla.model.PostAdminResponse;
import net.datafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AdminTest {
    AdminRequest request;
    @BeforeTest
    public void setup(){
        Faker faker = new Faker();
        request = new AdminRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );
        System.out.println("Request "+request);
    }

    @Test
    void sendAdminRequestTest() {
        PostAdminResponse response = RequestManager.postRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendAdminRequest",
                request,
                PostAdminResponse.class);
        System.out.println("Request "+request);

        System.out.println(response);


        //Assert.assertNotNull(response.getRequestId());

    }
}
