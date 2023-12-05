package com.neu.csye6200.daycare.factories;

import com.neu.csye6200.daycare.models.Person;

public abstract class PersonFactory {

    public abstract Person getObject(String csvData);

    public abstract Person getObject();
}
