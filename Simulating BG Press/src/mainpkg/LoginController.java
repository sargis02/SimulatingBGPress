package mainpkg;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordPF;

    private SimulatingBGPress mainApp;

    public void setMainApp(SimulatingBGPress mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void loginButton() throws Exception {
        String username = usernameTF.getText();
        String password = passwordPF.getText();

        // Perform authentication
        if (username.equals("headofit") && password.equals("headofit12")) {
            // Open Head of IT dashboard scene
            mainApp.showDashboardScene("DashboardHeadofIT.fxml");
        } else if (username.equals("webeditor") && password.equals("webeditor12")) {
            // Open Web Editor dashboard scene
            mainApp.showDashboardScene("DashboardWebEditor.fxml");      
        } else if (username.equals("supplier") && password.equals("supplier12")) {
            // Open Supplier dashboard scene
            mainApp.showDashboardScene("DashboardSupplier.fxml");
        } else if (username.equals("archivist") && password.equals("archivist12")) {
            // Open Archivist dashboard scene
            mainApp.showDashboardScene("DashboardArchivist.fxml");
        } else {
            // Show error message for invalid credentials
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password!");
            alert.showAndWait();
        }
    }
}
