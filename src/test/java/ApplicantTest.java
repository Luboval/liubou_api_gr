import eu.senla.db.dto.ApplicantDAO;
import eu.senla.db.dto.ApplicantDaoImpl;
import eu.senla.db.entity.Applicant;
import eu.senla.utils.ConnectionPool;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.sql.Connection;

@Slf4j
public class ApplicantTest {
    @Test (testName = "Applicant get test")
    public void getApplicantByIdTest()  {
        try (Connection connection = ConnectionPool.getConnection()) {
            ApplicantDAO applicantDAO = new ApplicantDaoImpl(connection);
            applicantDAO.get(24535).ifPresent(a -> System.out.println(a.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "Get all applicant")
    public void getAllApplicants()  {
        try (Connection connection = ConnectionPool.getConnection()) {
            ApplicantDAO applicantDAO = new ApplicantDaoImpl(connection);
            System.out.println(applicantDAO.getAll().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "create applicant")
    public void createApplicant() {
        try (Connection connection = ConnectionPool.getConnection()) {
            ApplicantDAO applicantDAO = new ApplicantDaoImpl(connection);
            Applicant applicant = new Applicant();
            applicant.setName("qqq");
            applicant.setSurName("qqqq");
            applicant.setMiddleName("qqqqq");
            applicant.setPassportNumber("qqqqqqq");
            applicant.setPhonenumber("qqqqqqqq");
            applicant.setRegistrationAddress("qqqqqqqqq");
            applicantDAO.save(applicant);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "update applicant")
    public void updateApplicant() {
        try (Connection connection = ConnectionPool.getConnection()) {
            ApplicantDAO applicantDAO = new ApplicantDaoImpl(connection);
            Applicant applicant = new Applicant();
            applicant.setName("qqq");

            applicantDAO.update(applicant, new String[]{"QWERTY"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(testName = "delete applicant")
    public void deleteApplicant() {
        try (Connection connection = ConnectionPool.getConnection()) {
            ApplicantDAO applicantDAO = new ApplicantDaoImpl(connection);
            Applicant applicant = new Applicant();
            applicant.setName("qqq");
            applicantDAO.delete(applicant);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
