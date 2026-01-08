package eu.senla.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("surname")
    private String surName;
    private String name;
    @JsonProperty("middlename")
    private String middleName;
    @JsonProperty("passportnumber")
    private String passportNumber;
    @JsonProperty("phoneNumber")
    private String phonenumber;
    @JsonProperty("registration_address")
    private String registrationAddress;

}
