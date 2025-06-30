package eu.senla.model.admin.request;

import eu.senla.client.ApiPoints;
import eu.senla.client.RequestManager;
import eu.senla.client.SpecConfig;
import eu.senla.model.admin.response.PostAdminNegativeResponse;
import eu.senla.model.admin.response.PostAdminResponse;

public class SendAdminRequest {

    public static PostAdminResponse sendCorrectAdminRequest() {
        return RequestManager.postAdminRequest(
                SpecConfig.requestSpecification(),
                SpecConfig.responseSpecification(),
                ApiPoints.POSTADMINPOINT,
                CreateAdminRequest.createCorrectAdminRequest(),
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
