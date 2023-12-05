package com.neu.csye6200.daycare.models;

import com.neu.csye6200.daycare.Group;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Group> groups = new ArrayList<>();
    static int id = 0;
    private int idC = 0;

    public Classroom() {
        id++;
        idC = id;
    }

    public int getId() {
        return idC;
    }

    public void addGroups(Group g) {
        groups.add(g);
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    @Override
    public String toString() {
        String temp="";
        for(int i=0;i<groups.size();i++) {
            temp = temp + " " +  groups.get(i).getTeacher().getName();
        }
        return temp;
    }


}
