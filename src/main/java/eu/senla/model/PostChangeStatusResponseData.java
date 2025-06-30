package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostChangeStatusResponseData {
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("staffid")
    private Integer staffId;
    @JsonProperty("dateofapplication")
    private String dateOfApplication;
    @JsonProperty("kindofapplication")
    private String kindOfApplication;
    @JsonProperty("statusofapplication")
    private String statusOfApplication;
    private String channel;
    private String image;

}
