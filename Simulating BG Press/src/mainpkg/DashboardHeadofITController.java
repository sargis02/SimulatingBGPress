/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DashboardHeadofITController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cybersecurityManagerButton(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CybersecurityManagerScene.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void disasterRecoveryButton(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisasterRecoveryScene.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void supportAndHelpdeskButton(ActionEvent event) {
    }

    @FXML
    private void userManagementButton(ActionEvent event) {
    }

    @FXML
    private void managingPublicationButton(ActionEvent event) {
    }

    @FXML
    private void itTrainingButton(ActionEvent event) {
    }

    @FXML
    private void costAndPerformanceButton(ActionEvent event) {
    }

    @FXML
    private void assetManagementButton(ActionEvent event) {
    }
    
}
