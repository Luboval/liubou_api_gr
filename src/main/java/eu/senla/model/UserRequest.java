package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record UserRequest(
        @JsonProperty("mode")
        String mode,
        @JsonProperty("personalLastName")
        String personalLastName,
        @JsonProperty("personalMiddleName")
        String personalMiddleName,
        @JsonProperty("personalPhoneNumber")
        String personalPhoneNumber,
        @JsonProperty("personalNumberOfPassport")
        String personalNumberOfPassport,
        @JsonProperty("citizenLastName")
        String citizenLastName,
        @JsonProperty("citizenFirstName")
        String citizenFirstName,
        @JsonProperty("citizenMiddleName")
        String citizenMiddleName,
        @JsonProperty("citizenBirthDate")
        String citizenBirthDate,
        @JsonProperty("citizenNumberOfPassport")
        String citizenNumberOfPassport,
        @JsonProperty("citizenGender")
        String citizenGender,
        @JsonProperty("dateOfMarriage")
        String dateOfMarriage,
        @JsonProperty("newLastName")
        String newLastName,
        @JsonProperty("anotherPersonLastName")
        String anotherPersonLastName,
        @JsonProperty("anotherPersonFirstName")
        String anotherPersonFirstName,
        @JsonProperty("anotherPersonMiddleName")
        String anotherPersonMiddleName,
        @JsonProperty("birth_of_anotoherPerson")
        String birthOfAnotoherPerson,
        @JsonProperty("anotherPersonPassport")
        String anotherPersonPassport,
        @JsonProperty("birth_place")
        String birthPlace,
        @JsonProperty("birth_mother")
        String birthMother,
        @JsonProperty("birth_father")
        String birthFather,
        @JsonProperty("death_dateOfDeath,")
        String deathDateOfDeath,
        @JsonProperty("death_placeOfDeath")
        String deathPlaceOfDeath ) {

}
