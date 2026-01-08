package eu.senla.db.dto;

import eu.senla.db.entity.Applicant;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static eu.senla.db.queries.ApplicantQueries.*;

@Slf4j
public class ApplicantDaoImpl implements ApplicantDAO{

    private final Connection connection;

    public ApplicantDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Applicant> get(long id) {
        try (PreparedStatement dpst = connection.prepareStatement(selectApplicantById)) {
            dpst.setLong(1, id);
            ResultSet resultSet = dpst.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Applicant(
                        resultSet.getInt("applicantid"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("middlename"),
                        resultSet.getString("passportnumber"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("registration_address")
                ));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Applicant> getAll() {
        List<Applicant> applicantList = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet resultSet = st.executeQuery(selectAllApplicants);

            while (resultSet.next()) {
                Applicant applicant = new Applicant();
                applicant.setApplicantId(resultSet.getInt("applicantid"));
                applicant.setName(resultSet.getString("name"));
                applicant.setSurName(resultSet.getString("surname"));
                applicant.setMiddleName(resultSet.getString("middlename"));
                applicant.setPassportNumber(resultSet.getString("passportnumber"));
                applicant.setPhonenumber(resultSet.getString("phoneNumber"));
                applicant.setRegistrationAddress(resultSet.getString("registration_address"));

                applicantList.add(applicant);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicantList;
    }

    @Override
    public void save(Applicant applicant) {
        try (PreparedStatement pst = connection.prepareStatement(insertIntoApplicant))  {
            pst.setString(1, applicant.getSurName());
            pst.setString(2, applicant.getName());
            pst.setString(3, applicant.getMiddleName());
            pst.setString(4, applicant.getPassportNumber());
            pst.setString(5, applicant.getPhonenumber());
            pst.setString(6, applicant.getRegistrationAddress());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Applicant applicant, String[] params) {
        try (PreparedStatement pst = connection.prepareStatement(updateApplicant)) {
            pst.setString(1, params[0]);
            pst.setString(2, applicant.getName());

            System.out.println(pst);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Applicant applicant) {
        try (PreparedStatement pst = connection.prepareStatement(deleteApplicantByName)) {
            pst.setString(1, applicant.getName());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Applicant> findByEmail(String email) {
        return Optional.empty();
    }
}
