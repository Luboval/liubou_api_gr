package eu.senla.model.admin.request;

import net.datafaker.Faker;

import java.time.LocalDate;

public class CreateAdminRequest {
    static Faker faker = new Faker();

    public static AdminRequest createCorrectAdminRequest() {

        return new AdminRequest(
                faker.name().lastName(),
                faker.name().firstName(),
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );
    }

    public static AdminRequest createIncorrectAdminRequest() {
        return new AdminRequest(
                faker.name().lastName(),
                null,
                faker.funnyName().name(),
                faker.number().digits(9),
                faker.number().digits(8),
                LocalDate.now().toString()
        );
    }
}
