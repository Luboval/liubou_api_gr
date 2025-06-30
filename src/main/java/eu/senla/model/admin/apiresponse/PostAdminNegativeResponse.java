package eu.senla.model.admin.apiresponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAdminNegativeResponse {

    private String code;
    private String message;
}
