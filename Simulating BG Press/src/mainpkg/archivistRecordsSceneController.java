/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class archivistRecordsSceneController implements Initializable {

    @FXML private TableView<String> recordsTableView;
    @FXML private TableColumn<String, String> recordsTitleTableView;
    @FXML private TableColumn<String, String> recordsCreatorTableView;
    @FXML private TableColumn<String, String> recordsDateTableView;
    
    private Records archivist;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        archivist = new Records();
        recordsTitleTableView.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> data) {
                return new SimpleStringProperty(data.getValue());
            }
        });
        updateFileTable();
    }   

    @FXML
    private void recordsUploadFileButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            try {
                archivist.uploadFile(selectedFile.getName(), selectedFile.getAbsolutePath());
                updateFileTable();
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Upload Error", "Error uploading file", e.getMessage());
            }
        }
    }

    @FXML
    private void recordsDeleteFileButton(ActionEvent event) {
        String selectedFileName = recordsTableView.getSelectionModel().getSelectedItem();
        if (selectedFileName != null) {
            try {
                archivist.deleteFile(selectedFileName);
                updateFileTable();
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Delete Error", "Error deleting file", e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "No File Selected", "Please select a file to delete", null);
        }
    }

    @FXML
    private void recordsRetrieveButton(ActionEvent event) {
    }
    
    private void updateFileTable() {
        List<String> files = archivist.getFiles();
        ObservableList<String> fileList = FXCollections.observableArrayList(files);
        recordsTableView.setItems(fileList);
    }

    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}