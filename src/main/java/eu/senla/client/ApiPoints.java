package eu.senla.client;

import lombok.Getter;

@Getter
public class ApiPoints {
    public static final String GETAPPLICATIONPOINT = "/getApplications";
    public static final String POSTADMINPOINT = "/sendAdminRequest";
    public static final String POSTUSERPOINT = "/sendUserRequest";
    public static final String GETAPPSTATUSPOINT = "getApplStatus/";
    public static final String POSTCHANGESTATUSPOINT = "/requestProcess";
}
