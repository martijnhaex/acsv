package be.haexnet.acsv.data;

import be.haexnet.acsv.annotation.ACSVColumn;

public class Employee {

    @ACSVColumn
    private String firstName;
    @ACSVColumn
    private String lastName;
    @ACSVColumn
    private String middleName;
    @ACSVColumn
    private String age;

}
