package mainpkg;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class DisasterRecovery {

    private String title;
    private String description;
    private String recoveryObjectives;
    private String contactInformation;
    private String emergencyProcedure;
    private String backupRestorationProcedures;
    private String testingSchedule;

    public DisasterRecovery(String title, String description, String recoveryObjectives, String contactInformation,
                            String emergencyProcedure, String backupRestorationProcedures, String testingSchedule) {
        this.title = title;
        this.description = description;
        this.recoveryObjectives = recoveryObjectives;
        this.contactInformation = contactInformation;
        this.emergencyProcedure = emergencyProcedure;
        this.backupRestorationProcedures = backupRestorationProcedures;
        this.testingSchedule = testingSchedule;
    }

    public void savePlanToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Title: " + title);
            writer.newLine();
            writer.write("Description: " + description);
            writer.newLine();
            writer.write("Recovery Objectives: " + recoveryObjectives);
            writer.newLine();
            writer.write("Contact Information: " + contactInformation);
            writer.newLine();
            writer.write("Emergency Procedure: " + emergencyProcedure);
            writer.newLine();
            writer.write("Backup and Restoration Procedures: " + backupRestorationProcedures);
            writer.newLine();
            writer.write("Testing Schedule: " + testingSchedule);
        }
    }
}

