package eu.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAdminResponse {

    private List<ApplicationData> data;
    private String requestId;


}
