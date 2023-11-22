package com.neu.csye6200.daycare;


import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ImmunizationService {

    private static final int DTAP_THRESHOLD_AGE = 2;
    private static final int POLIO_THRESHOLD_AGE = 2;
    private static final int HEPATITIS_THRESHOLD_AGE = 2;
    private static final int VARICELLA_THRESHOLD_AGE = 2;
    private static final int HIB_THRESHOLD_AGE = 2;
    private static final int MMR_THRESHOLD_AGE = 2;
    private static final int DTAP_BOOSTER_THRESHOLD_AGE = 5;
    private static final int POLIO_BOOSTER_THRESHOLD_AGE = 5;
    private static final int MMR_BOOSTER_THRESHOLD_AGE = 5;
    private static final int Varicella_BOOSTER_THRESHOLD_AGE = 5;
    private static final int Tdap_THRESHOLD_AGE = 12;
    private static final int MeninGococcal_THRESHOLD_AGE = 12;


    public String checkImmunizationRequirements(Student student) {
        int studentAge = calculateAge(student.getDateOfBirth(), LocalDate.now());

        StringBuilder message = new StringBuilder();
        if (studentAge >= DTAP_THRESHOLD_AGE && !hasDTaPImmunization(student.getImmunizations())) {
            message.append("DTaP immunization is required, but not found in the immunization records.\n");
        }

        if (studentAge >= POLIO_THRESHOLD_AGE && !hasPolioImmunization(student.getImmunizations())) {
            message.append("Polio immunization is required, but not found in the immunization records.\n");
        }

        if (studentAge >= HEPATITIS_THRESHOLD_AGE && !hasHepatitisImmunization(student.getImmunizations())) {
            message.append("Hepatitis immunization is required, but not found in the immunization records.\n");
        }

        if (studentAge >= VARICELLA_THRESHOLD_AGE && !hasVaricellaImmunization(student.getImmunizations())) {
            message.append("Varicella immunization is required, but not found in the immunization records.\n");
        }

        if (studentAge >= HIB_THRESHOLD_AGE && !hasHibImmunization(student.getImmunizations())) {
            message.append("Hib immunization is required, but not found in the immunization records.\n");
        }

        // Check MMR immunization requirement
        if (studentAge >= MMR_THRESHOLD_AGE && !hasMMRImmunization(student.getImmunizations())) {
            message.append("MMR immunization is required, but not found in the immunization records.\n");
        }

        // Check DTaP booster immunization requirement
        if (studentAge >= DTAP_BOOSTER_THRESHOLD_AGE && !hasDTaPBoosterImmunization(student.getImmunizations())) {
            message.append("DTaP booster immunization is required, but not found in the immunization records.\n");
        }

        // Check Polio booster immunization requirement
        if (studentAge >= POLIO_BOOSTER_THRESHOLD_AGE && !hasPolioBoosterImmunization(student.getImmunizations())) {
            message.append("Polio booster immunization is required, but not found in the immunization records.\n");
        }

        // Check MMR booster immunization requirement
        if (studentAge >= MMR_BOOSTER_THRESHOLD_AGE && !hasMMRBoosterImmunization(student.getImmunizations())) {
            message.append("MMR booster immunization is required, but not found in the immunization records.\n");
        }

        // Check Varicella booster immunization requirement
        if (studentAge >= Varicella_BOOSTER_THRESHOLD_AGE && !hasVaricellaBoosterImmunization(student.getImmunizations())) {
            message.append("Varicella booster immunization is required, but not found in the immunization records.\n");
        }

        // Check Tdap immunization requirement
        if (studentAge >= Tdap_THRESHOLD_AGE && !hasTdapImmunization(student.getImmunizations())) {
            message.append("Tdap immunization is required, but not found in the immunization records.\n");
        }

        if (studentAge >= MeninGococcal_THRESHOLD_AGE && !hasMeninGococcalImmunization(student.getImmunizations())) {
            message.append("MeninGococcal immunization is required, but not found in the immunization records.\n");
        }

        if (message.length() == 0) {
            message.append("Student has met all immunization requirements.");
        }

        return message.toString();
    }

    // Helper method to check if student has DTaP immunization
    private boolean hasDTaPImmunization(List<Immunization> immunizations) {
        // Check if DTaP immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "DTaP".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Polio immunization
    private boolean hasPolioImmunization(List<Immunization> immunizations) {
        // Check if Polio immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Polio".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Hepatitis immunization
    private boolean hasHepatitisImmunization(List<Immunization> immunizations) {
        // Check if Hepatitis immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Hepatitis".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Varicella immunization
    private boolean hasVaricellaImmunization(List<Immunization> immunizations) {
        // Check if Varicella immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Varicella".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Hib immunization
    private boolean hasHibImmunization(List<Immunization> immunizations) {
        // Check if Hib immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Hib".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has MMR immunization
    private boolean hasMMRImmunization(List<Immunization> immunizations) {
        // Check if MMR immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "MMR".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has DTaP booster immunization
    private boolean hasDTaPBoosterImmunization(List<Immunization> immunizations) {
        // Check if DTaP booster immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "DTaP booster".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Polio booster immunization
    private boolean hasPolioBoosterImmunization(List<Immunization> immunizations) {
        // Check if Polio booster immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Polio booster".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has MMR booster immunization
    private boolean hasMMRBoosterImmunization(List<Immunization> immunizations) {
        // Check if MMR booster immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "MMR booster".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Varicella booster immunization
    private boolean hasVaricellaBoosterImmunization(List<Immunization> immunizations) {
        // Check if Varicella booster immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Varicella booster".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has Tdap immunization
    private boolean hasTdapImmunization(List<Immunization> immunizations) {
        // Check if Tdap immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "Tdap".equals(immunization.getVaccineName()));
    }

    // Helper method to check if student has MeninGococcal immunization
    private boolean hasMeninGococcalImmunization(List<Immunization> immunizations) {
        // Check if MeninGococcal immunization is found in the list
        return immunizations.stream().anyMatch(immunization -> "MeninGococcal".equals(immunization.getVaccineName()));
    }

    // Helper method to calculate age
    private int calculateAge(LocalDate birthdate, LocalDate currentDate) {
        return currentDate.getYear() - birthdate.getYear();
    }
}

