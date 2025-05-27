import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.PostUserResponse;
import eu.senla.model.UserRequest;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class UserTest {
    UserRequest request;
    @BeforeTest
    public void setup() {
        Faker faker = new Faker();


        request = new UserRequest(
                "wedding",
                faker.name().lastName(),
                faker.name().firstName(),
                faker.number().digits(9),
                faker.number().digits(8),
                faker.name().lastName(),
                faker.name().femaleFirstName(),
                faker.name().firstName(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))).toString(),
                faker.number().digits(8),
                faker.gender().binaryTypes(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(365)))).toString(),
                faker.name().lastName(),
                faker.name().lastName(),
                faker.name().maleFirstName(),
                faker.name().firstName(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))).toString(),
                faker.number().digits(8),
                faker.address().cityName(),
                faker.name().fullName(),
                faker.name().fullName(),
                LocalDate.now().minus(Period.ofDays((new Random().nextInt(7)))).toString(),
                faker.address().cityName());
        System.out.println("Request " + request);
    }

    @Test
    void sendUserRequestTest() {
        PostUserResponse response = RequestManager.postUserRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                "/sendUserRequest",
                request,
                PostUserResponse.class);
      //  System.out.println("Request " + request);

        //System.out.println(response);
       // System.out.println(response.getRequestId());
       // System.out.println(response.getData().getFirst().getStaffId());


        Assert.assertNotNull(response.getRequestId());

    }
}
