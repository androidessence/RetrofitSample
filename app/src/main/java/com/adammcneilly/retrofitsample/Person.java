package com.adammcneilly.retrofitsample;

/**
 * Model for a Person object.
 *
 * Created by adam.mcneilly on 8/22/16.
 */
public class Person {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    /**
     * Returns a concatenated string of the person's first and last name.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
