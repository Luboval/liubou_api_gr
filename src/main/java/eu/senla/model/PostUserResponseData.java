package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostUserResponseData {

    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("merrigecertificateid")
    private Integer merrigeCertificateId;

}
