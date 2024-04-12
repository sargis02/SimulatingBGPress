/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserManagementSceneController implements Initializable {

    @FXML    private RadioButton maleRadioButton;
    @FXML    private RadioButton femaleRadioButton;
    @FXML    private RadioButton otherRadioButton;
    @FXML    private ComboBox<String> roleComboBox;
    @FXML    private TextField nameTextField;
    @FXML    private TextField idTextField;
    @FXML    private TextField phoneTextField;
    @FXML    private TextField emailTextField;
    @FXML    private TableView<User> userManagementTableView;
    @FXML    private TableColumn<User, String> idTableColumn;
    @FXML    private TableColumn<User, String> nameTableColumn;
    @FXML    private TableColumn<User, String> phoneTableColumn;
    @FXML    private TableColumn<User, String> emailTableColumn;
    @FXML    private TableColumn<User, String> genderTableColumn;
    @FXML    private TableColumn<User, String> roleTableColumn;

    /**
     * Initializes the controller class.
     */
    
    private final UserManagement userManagement = new UserManagement();
    
    ToggleGroup tg;
    
    ArrayList<User> userList;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        roleComboBox.getItems().addAll("Employee","Head of IT", "Supplier", "Archivist", "Accounts Officer", "Printing Operator", "Web Editor", "Client", "Director General");
        
        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        otherRadioButton.setToggleGroup(tg);
        
        
        userList = new ArrayList<User>();
        
        
        idTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        roleTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        
        ObservableList<User> userList = FXCollections.observableArrayList(userManagement.getAllUsers());
        userManagementTableView.setItems(userList);
    
    }
    

    @FXML
    private void registerUserButton(ActionEvent event) {
        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        }
        

        userManagement.registerUser(
            idTextField.getText(),
            nameTextField.getText(),
            gender,
            emailTextField.getText(),
            phoneTextField.getText(),
            roleComboBox.getValue()
        );
        

        /*ObservableList<User> userList = FXCollections.observableArrayList(userManagement.getAllUsers());
        userManagementTableView.setItems(userList);
        */

        idTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        phoneTextField.clear();
        
        userManagement.saveUserListToFile("user_list.txt");
        System.out.println("Plan submitted successfully.");
        
        
        
        
    }


    @FXML
    private void deleteUserButton(ActionEvent event) {
        User selectedUser = userManagementTableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            userManagement.deleteUser(selectedUser.getId());

            ObservableList<User> userList = FXCollections.observableArrayList(userManagement.getAllUsers());
            userManagementTableView.setItems(userList);
            
        }
        
        userManagement.saveUserListToFile("user_list.txt");
        System.out.println("Plan submitted successfully.");
    }


    @FXML
    private void showUserButton(ActionEvent event) {
        List<User> allUsers = userManagement.getAllUsers();
        userManagementTableView.getItems().clear();
        userManagementTableView.getItems().addAll(allUsers);
        }
    

    
}