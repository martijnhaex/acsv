package be.haexnet.acsv.data;

import be.haexnet.acsv.annotation.ACSVColumn;

public class Embryo {

    @ACSVColumn
    private String firstName;
    @ACSVColumn
    private String lastName;
    @ACSVColumn
    private Character gender;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Character getGender() {
        return gender;
    }

}
