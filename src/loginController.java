import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    

    @FXML
    private Button loginButton;

    @FXML
    private Label message;

    @FXML
    private PasswordField passwordTextField;

    @FXML TextField userNameTextField;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label email;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;


    @FXML
    void loginButtonOnAction(ActionEvent event) {
       

        if (userNameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false) {
            validator();
     } else {
       message.setText("Enter username and password !!!");
      }
    
    }

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
     Stage stage = (Stage)createAccountButton.getScene().getWindow();
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show();

       
    }


    
    @FXML
    void cancelButtonOnAction(ActionEvent event) {
       Stage stage = (Stage)cancelButton.getScene().getWindow();
       stage.close();
    }


    public void validator(){
        Connect c = new  Connect();
        Connection con = c.getconnection();

        String verify = ("select count(1) From fill where userName ='"+userNameTextField.getText()+"' and password = '"+passwordTextField.getText() +"'");
           
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
            if(rs.getInt(1)==1) {
               
                Parent root = FXMLLoader.load(getClass().getResource("display.fxml"));
                Stage stage = (Stage)loginButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            
            }
            else{
                message.setText("Invalid Login Please try again");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

      String setUserName(){

        return userNameTextField.getText();
      }
}
