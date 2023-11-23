package com.neu.csye6200.daycare;

public abstract class PersonFactory {

    public abstract Person getObject(String csvData);

    public abstract Person getObject();
}
