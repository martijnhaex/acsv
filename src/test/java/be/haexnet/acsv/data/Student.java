package be.haexnet.acsv.data;

import be.haexnet.acsv.annotation.ACSVColumn;

public class Student {

    @ACSVColumn(header = "first_name")
    private String givenName;
    @ACSVColumn(header = "last_name")
    private String familyName;
    @ACSVColumn(header = "school_name")
    private String schoolName;
    @ACSVColumn(header = "field_of_study")
    private String fieldOfStudy;

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

}
