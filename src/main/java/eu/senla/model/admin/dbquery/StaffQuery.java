package eu.senla.model.admin.dbquery;

public class StaffQuery {
    public static String selectStaff = "Select * from reg_office.staff";
    public static String selectStaffParam = "Select * from reg_office.staff where staffid = ?";
}
