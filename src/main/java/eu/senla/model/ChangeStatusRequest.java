package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public record ChangeStatusRequest(
        @JsonProperty("action")
        String action,
        @JsonProperty("applId")
        Integer applId,
        @JsonProperty("staffid")
        Integer staffId) {

}
