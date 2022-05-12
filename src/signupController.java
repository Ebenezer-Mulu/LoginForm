import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class signupController {

    App lg = new App();
   

    @FXML
    private TextField birthdayTextField;

    @FXML
    private TextField eTextField;

    @FXML
    private TextField fNameTextField;

    @FXML
    private TextField lNameTextField;

    @FXML
    private TextField pNumberTextField;

    @FXML
    private PasswordField passwordSignupTextField;

    @FXML
    private Button signup;

    @FXML
    private Label messageSignupButton;

    @FXML
    private ToggleGroup tgGroup;

    @FXML
    private RadioButton maleRadioButton;
    
    @FXML
    void maleOnAction(ActionEvent event) {
  
    }
      
    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    void femaleOnAction(ActionEvent event) {

    }
    
    @FXML
    private Button cancelSignupButton;

    @FXML
    private TextField uNameSignupTextField;

    @FXML
    void signup(ActionEvent event) {
        if (fNameTextField.getText().isBlank()==false && lNameTextField.getText().isBlank()==false  
        && eTextField.getText().isBlank()==false  && passwordSignupTextField.getText().isBlank()==false
        && birthdayTextField.getText().isBlank()==false  && uNameSignupTextField.getText().isBlank()==false
        && pNumberTextField.getText().isBlank()==false) {
            store();
     } else {
        messageSignupButton.setText("Fill all Field !!!");
      }
    }
    @FXML
    void cancelSignup(ActionEvent event) {
        Stage stage = (Stage)cancelSignupButton.getScene().getWindow();
        stage.close();
    }

    public void store(){
        Connect c = new  Connect();
        Connection con = c.getconnection();

    String sql = ("insert into fill(firstName,lastName,email,userName,phone_number,gender,birthday,password) values(?,?,?,?,?,?,?,?)");
    try {
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, fNameTextField.getText());
        st.setString(2, lNameTextField.getText());
        st.setString(3, eTextField.getText());
        st.setString(4, uNameSignupTextField.getText());
        st.setString(5, pNumberTextField.getText());
        st.setString (6,(((Labeled) tgGroup.getSelectedToggle()).getText())); 
        st.setString(7, birthdayTextField.getText());
        st.setString(8, passwordSignupTextField.getText());
         
    
        st.executeUpdate();
 
        switchToLogin();
   
        } catch (Exception e) {
     System.out.println(e);
    }

}

public void switchToLogin() throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    Stage stage = (Stage)cancelSignupButton.getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    
};



}