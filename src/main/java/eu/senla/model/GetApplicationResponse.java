package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

//@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplicationResponse {

   // @JsonProperty("total")
    private String total;
   // @JsonProperty("data")
    private List<ApplicationData> data;
   // @JsonProperty("requestId")
    private String requestId;


}
