package com.neu.csye6200.daycare;

import java.time.LocalDate;

public class Immunization {

    private int id;
    private LocalDate hibDate;
    private LocalDate dtapDate;
    private LocalDate polioDate;
    private LocalDate mmrDate;
    private LocalDate hepatitisBDate;
    private LocalDate varicellaDate;
    private LocalDate tdapDate;
    private LocalDate meningococcalDate;

    public Immunization() {
    }

    public LocalDate getHibDate() {
        return hibDate;
    }

    public LocalDate getDtapDate() {
        return dtapDate;
    }

    public LocalDate getPolioDate() {
        return polioDate;
    }

    public LocalDate getMmrDate() {
        return mmrDate;
    }

    public LocalDate getHepatitisBDate() {
        return hepatitisBDate;
    }

    public LocalDate getVaricellaDate() {
        return varicellaDate;
    }

    public LocalDate getTdapDate() {
        return tdapDate;
    }

    public LocalDate getMeningococcalDate() {
        return meningococcalDate;
    }

    public int getId() {
        return id;
    }

    public void setHibDate(LocalDate hibDate) {
        this.hibDate = hibDate;
    }

    public void setDtapDate(LocalDate dtapDate) {
        this.dtapDate = dtapDate;
    }

    public void setPolioDate(LocalDate polioDate) {
        this.polioDate = polioDate;
    }

    public void setMmrDate(LocalDate mmrDate) {
        this.mmrDate = mmrDate;
    }

    public void setHepatitisBDate(LocalDate hepatitisBDate) {
        this.hepatitisBDate = hepatitisBDate;
    }

    public void setVaricellaDate(LocalDate varicellaDate) {
        this.varicellaDate = varicellaDate;
    }

    public void setTdapDate(LocalDate tdapDate) {
        this.tdapDate = tdapDate;
    }

    public void setMeningococcalDate(LocalDate meningococcalDate) {
        this.meningococcalDate = meningococcalDate;
    }
}
