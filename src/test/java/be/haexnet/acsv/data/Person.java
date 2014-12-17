package be.haexnet.acsv.data;

import be.haexnet.acsv.annotation.ACSVColumn;

public class Person {

    @ACSVColumn
    private String firstName;
    @ACSVColumn
    private String lastName;
    @ACSVColumn
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

}
