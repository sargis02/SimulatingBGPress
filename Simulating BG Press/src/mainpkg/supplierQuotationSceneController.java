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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class supplierQuotationSceneController implements Initializable {

    @FXML   private TextField quotationQuantityTextField;
    @FXML   private TextField quotationDescriptionTextField;
    @FXML   private TextField quotationUnitPriceTextField;
    @FXML   private TextField quotationNumberTextField;
    @FXML   private TableView<Quotation> quotationsTableView; // Change to Quotation
    @FXML   private TableColumn<Quotation, String> quotationNoTableColumn; // Change to Quotation
    @FXML   private TableColumn<Quotation, String> quotationDescriptionTableColumn; // Change to Quotation
    @FXML   private TableColumn<Quotation, String> quotationQuantityTableColumn; // Change to Quotation
    @FXML   private TableColumn<Quotation, String> quotationUnitPriceTableColumn; // Change to Quotation
    @FXML   private TableColumn<Quotation, String> totalTableColumn; // Change to Quotation

    private final supplierQuotation supplierQuotation = new supplierQuotation();
    
    ToggleGroup Qtg;
    
    ArrayList<Quotation> quotationList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Qtg = new ToggleGroup();

        quotationList = new ArrayList<Quotation>();
        
        quotationNoTableColumn.setCellValueFactory(new PropertyValueFactory<>("quotationNumber"));
        quotationDescriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        quotationQuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quotationUnitPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        totalTableColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        
        ObservableList<Quotation> quotations = FXCollections.observableArrayList(supplierQuotation.getQuotations());
        quotationsTableView.setItems(quotations);
    }


@FXML
private void addQuotationButton(ActionEvent event) {
    // Parse the numerical values from the text fields
    String quotationNumber = quotationNumberTextField.getText();
    String description = quotationDescriptionTextField.getText();
    int quantity = Integer.parseInt(quotationQuantityTextField.getText());
    double unitPrice = Double.parseDouble(quotationUnitPriceTextField.getText());
    double total = quantity * unitPrice; // Assuming total is calculated based on quantity and unit price

    // Add the quotation with parsed values
    supplierQuotation.addQuotation(quotationNumber, description, quantity, unitPrice, total);

    // Refresh TableView to display the new quotation
    quotationsTableView.setItems(null);
    quotationsTableView.setItems(FXCollections.observableArrayList(supplierQuotation.getQuotations()));

    // Clear the text fields
    quotationNumberTextField.clear();
    quotationDescriptionTextField.clear();
    quotationQuantityTextField.clear();
    quotationUnitPriceTextField.clear();

    // Save the quotation list to file
    supplierQuotation.saveQuotationListToFile("quotation_list.txt");
    System.out.println("Plan submitted successfully.");
}

    @FXML
    private void showQuotationsButton(ActionEvent event) {
        List<Quotation> getQuotations = supplierQuotation.getQuotations();
        quotationsTableView.getItems().clear();
        quotationsTableView.getItems().addAll(getQuotations);
    }
}
