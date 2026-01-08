package eu.senla.db.queries;

public class ApplicantQueries {
    public static String selectApplicantById = "Select * from reg_office.applicants where applicantid = ?";
    public static String selectAllApplicants = "Select * from reg_office.applicants";
    public static String insertIntoApplicant = "Insert into reg_office.applicants "
                                                + "(surname, name, middlename, passportnumber, phonenumber, registration_address) "
                                                + "Values (?, ?,?,?,?,?)";
    public static String updateApplicant = "Update reg_office.applicants "
                                            + "set surname = ? "
                                            + "where name = ? ";
    public static String deleteApplicantByName = "Delete from reg_office.applicants where name = ?";


}
