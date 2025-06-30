package eu.senla.model.admin.dbresponse;

public record StaffDBResponse(
   int staffId,
   String lastName,
   String firstName,
   String middleName,
   String dateOfBirth,
   String passportNumber,
   String phoneNumber) {
}
