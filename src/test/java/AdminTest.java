import eu.senla.model.admin.apiresponse.PostAdminResponse;
import eu.senla.model.admin.dbquery.StaffQuery;
import eu.senla.model.admin.dbresponse.StaffDBResponse;
import eu.senla.model.admin.request.AdminRequest;
import eu.senla.model.admin.request.CreateAdminRequest;
import eu.senla.model.admin.request.SendAdminRequest;
import eu.senla.utils.DbPreparedStatement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

public class AdminTest {

    @Test(testName = "Admin test")
    void sendAdminRequestTest() throws SQLException {

        AdminRequest adminRequest = CreateAdminRequest.createCorrectAdminRequest();
        PostAdminResponse postAdminResponse = SendAdminRequest.sendCorrectAdminRequest(adminRequest);

        Assert.assertNotNull(postAdminResponse.getRequestId(), "Response is empty");

        StaffDBResponse staffDBResponse = DbPreparedStatement.getResponseForPreparedSelectQuery(
                StaffQuery.selectStaffParam,
                1,
                postAdminResponse.getData().getFirst().getStaffId());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(staffDBResponse.lastName(), adminRequest.personalLastName(), "lastName does not match");
        softAssert.assertEquals(staffDBResponse.firstName(), adminRequest.personalFirstName(), "firstName does not match");
        softAssert.assertEquals(staffDBResponse.middleName(), adminRequest.personalMiddleName(), "middleName does not match");
        softAssert.assertEquals(staffDBResponse.dateOfBirth(), adminRequest.dateOfBirth(), "dateOfBirth does not match");
        softAssert.assertEquals(staffDBResponse.passportNumber(), adminRequest.personalNumberOfPassport(), "passportNumber does not match");
        softAssert.assertEquals(staffDBResponse.phoneNumber(), adminRequest.personalPhoneNumber(), "phoneNumber does not match");
        softAssert.assertAll();
    }

    @Test(testName = "Negative Admin Test")
    void sendNegativeAdminRequestTest() {

        Assert.assertEquals(SendAdminRequest.sendNegativeAdminRequest().getMessage(), "Property personalFirstName is null!");
    }
}
