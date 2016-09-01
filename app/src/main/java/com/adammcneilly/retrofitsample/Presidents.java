package com.adammcneilly.retrofitsample;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of presidents returned from the API.
 *
 * Created by adam.mcneilly on 8/31/16.
 */
public class Presidents {
    public List<Person> presidents;

    public Presidents() {
        this.presidents = new ArrayList<>();
    }
}
