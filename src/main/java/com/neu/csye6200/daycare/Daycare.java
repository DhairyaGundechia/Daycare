package com.neu.csye6200.daycare;

import java.util.ArrayList;
import java.util.List;

public class Daycare {
    private static List<Classroom> classList = new ArrayList<>();

    public static void addClassroom(Classroom c) {
        classList.add(c);
    }

    public static void show() {
        classList.forEach(c -> {System.out.println(); System.out.println(c);});
    }

    public static List<Classroom> getClassroom(){
        return classList;
    }
}
