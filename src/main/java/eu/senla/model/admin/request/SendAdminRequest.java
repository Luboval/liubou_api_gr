package eu.senla.model.admin.request;

import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.admin.apiresponse.PostAdminNegativeResponse;
import eu.senla.model.admin.apiresponse.PostAdminResponse;

public class SendAdminRequest {

    public static PostAdminResponse sendCorrectAdminRequest(Object adminRequest) {
        return RequestManager.postAdminRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                ApiPoints.POSTADMINPOINT,
                adminRequest,
                PostAdminResponse.class);
    }

    public static PostAdminNegativeResponse sendNegativeAdminRequest() {
        return RequestManager.postAdminRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.errorResponseSpecification(),
                ApiPoints.POSTADMINPOINT,
                CreateAdminRequest.createIncorrectAdminRequest(),
                PostAdminNegativeResponse.class);
    }
}
