package mainpkg;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DisasterRecoverySceneController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField recoveryObjectivesField;
    @FXML
    private TextField contactInformationField;
    @FXML
    private TextField emergencyProcedureField;
    @FXML
    private TextField backupRestorationProceduresField;
    @FXML
    private TextField testingScheduleField;

    @FXML
    public void submitPlan() {
        DisasterRecovery recoveryPlan = new DisasterRecovery(
                titleField.getText(),
                descriptionField.getText(),
                recoveryObjectivesField.getText(),
                contactInformationField.getText(),
                emergencyProcedureField.getText(),
                backupRestorationProceduresField.getText(),
                testingScheduleField.getText()
        );

        try {
            recoveryPlan.savePlanToFile("disaster_recovery_plan.txt");
            System.out.println("Plan submitted successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the plan: " + e.getMessage());
        }
    }
}
