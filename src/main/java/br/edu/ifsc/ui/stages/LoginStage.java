package br.edu.ifsc.ui.stages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import br.edu.ifsc.ui.db.UserJSON;
import br.edu.ifsc.ui.db.UserXML;
import br.edu.ifsc.ui.entities.User;
import br.edu.ifsc.ui.exceptions.DBException;
import br.edu.ifsc.ui.exceptions.LoginException;
import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginStage {
	private TextField txtUser;

	public LoginStage(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(280, 120);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the username textfield
		txtUser = new JFXTextField();
		txtUser.setLayoutX(10);
		txtUser.setLayoutY(31);
		txtUser.setMaxWidth(150);
		txtUser.setMinWidth(150);
		txtUser.setPrefWidth(150);
		txtUser.setPromptText(Strings.username);

		// creating the password textfield
		JFXPasswordField txtPass = new JFXPasswordField();
		txtPass.setLayoutX(10);
		txtPass.setLayoutY(91);
		txtPass.setMaxWidth(150);
		txtPass.setMinWidth(150);
		txtPass.setPrefWidth(150);
		txtPass.setPromptText(Strings.password);

		// creating the login button
		JFXButton btnLogin = new JFXButton(Strings.btnLogin);
		btnLogin.setLayoutX(200);
		btnLogin.setLayoutY(80);
		btnLogin.setStyle("-fx-background-color: #007FFF; -fx-text-fill: white;");

		ComboBox<String> dbSource = new ComboBox<String>();
		dbSource.getItems().add("JSON");
		dbSource.getItems().add("XML");
		dbSource.getSelectionModel().select(0);
		dbSource.setLayoutX(10);
		dbSource.setLayoutY(150);
		dbSource.setOnAction(e -> changeDB(dbSource.getSelectionModel().getSelectedItem()));

		// setting the login button behavior using a lambda expression
		btnLogin.setOnMouseClicked(e -> {
			try {
				login(txtUser.getText(), txtPass.getText(), stage);
			} catch (LoginException ex) {
				System.out.println(ex.getMessage());
			} catch (DBException ex2) {

			}
		});

		// adding all created components to the pane
		pane.getChildren().add(btnLogin);
		pane.getChildren().add(txtUser);
		pane.getChildren().add(txtPass);
		pane.getChildren().add(dbSource);

		// melhorando aparencia do painel principal
		pane.setStyle("-fx-background-color:	linear-gradient(\n"
				+ "from	0%	0%	to	100%	100%,	white	0%,	silver	100%);");

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void changeDB(String selectedItem) {
		if (selectedItem.equals("JSON"))
			DB.users = new UserJSON();
		else if (selectedItem.equals("XML"))
			DB.users = new UserXML();
	}

	private void changeDB() {
		if (DB.users instanceof UserJSON)
			DB.users = new UserXML();
		else if (DB.users instanceof UserXML)
			DB.users = new UserJSON();
	}

	private void login(String username, String pass, Stage stage) throws LoginException, DBException {

		try {
			withCurrentDB(username, pass, stage);
		} catch (DBException exception) {
			changeDB();
			try {
				withCurrentDB(username, pass, stage);
			} catch (DBException newException) {
				throw new LoginException();
			}
		}
	}

	private void withCurrentDB(String username, String pass, Stage stage) throws DBException {
		User user = DB.users.getUser(username);
		try {
			if (!user.getPass().equals(pass)) {
				showLoginError();
				return;
			}
		} catch (NullPointerException ex) {
			throw new DBException();
		}
		try {
			new Main(this.txtUser.getText()).start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showLoginError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Strings.loginError);
		alert.setHeaderText(Strings.loginError);
		alert.showAndWait();
	}
}
