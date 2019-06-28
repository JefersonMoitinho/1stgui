package br.edu.ifsc.ui.stages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import br.edu.ifsc.ui.util.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CadTeacher extends Application {

	private TextField txtnomeTeacher;
	private TextField txtRgTeacher;
	private TextField txtCpfTeacher;
	private TextField txtArea;

	@Override
	public void start(Stage stage) throws Exception {
		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(480, 340);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblCadTeacher = new Label(Strings.lblCadTeacher);
		lblCadTeacher.setLayoutX(10);
		lblCadTeacher.setLayoutY(10);

		// creating the label component
		Label lblNomeTeacher = new Label(Strings.lblNomeTeacher);
		lblNomeTeacher.setLayoutX(10);
		lblNomeTeacher.setLayoutY(40);

		// creating the label component
		Label lblNascTeacher = new Label(Strings.lblNascTeacher);
		lblNascTeacher.setLayoutX(300);
		lblNascTeacher.setLayoutY(40);

		// creating the label component
		Label lblRgTeacher = new Label(Strings.lblRgTeacher);
		lblRgTeacher.setLayoutX(10);
		lblRgTeacher.setLayoutY(100);

		// creating the label component
		Label lblCpfTeacher = new Label(Strings.lblCpfTeacher);
		lblCpfTeacher.setLayoutX(300);
		lblCpfTeacher.setLayoutY(100);

		// creating the label component
		Label lblSexoTeacher = new Label(Strings.lblSexoTeacher);
		lblSexoTeacher.setLayoutX(10);
		lblSexoTeacher.setLayoutY(160);

		// creating the label component
		Label lblArea = new Label(Strings.lblArea);
		lblArea.setLayoutX(10);
		lblArea.setLayoutY(220);

		// creating the return button
		Button btnTeacherAdd = new JFXButton(Strings.btnTeacherAdd);
		btnTeacherAdd.setLayoutX(260);
		btnTeacherAdd.setLayoutY(300);
		btnTeacherAdd.setMaxWidth(80);
		btnTeacherAdd.setMinWidth(15);
		btnTeacherAdd.setPrefWidth(150);
		btnTeacherAdd.setOnMouseClicked(e -> {
			showAdd();
			return;
		});
		btnTeacherAdd.setStyle("-fx-background-color: #007FFF; -fx-text-fill: white;");

		// creating the return button
		JFXButton btnTeacherCanc = new JFXButton(Strings.btnTeacherCanc);
		btnTeacherCanc.setLayoutX(360);
		btnTeacherCanc.setLayoutY(300);
		btnTeacherCanc.setMaxWidth(80);
		btnTeacherCanc.setMinWidth(15);
		btnTeacherCanc.setPrefWidth(150);
		btnTeacherCanc.setOnMouseClicked(e -> {
			cancel();
			Cancel(stage);
		});
		btnTeacherCanc.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");

		// creating the name textfield
		txtnomeTeacher = new TextField();
		txtnomeTeacher.setLayoutX(10);
		txtnomeTeacher.setLayoutY(60);
		txtnomeTeacher.setMaxWidth(150);
		txtnomeTeacher.setMinWidth(250);
		txtnomeTeacher.setPrefWidth(150);

		// creating the Birth textfield
		JFXDatePicker txtNascTeacher = new JFXDatePicker();
		txtNascTeacher.setLayoutX(300);
		txtNascTeacher.setLayoutY(60);
		txtNascTeacher.setMaxWidth(150);
		txtNascTeacher.setMinWidth(150);
		txtNascTeacher.setPrefWidth(150);

		// creating the Rg textfield
		txtRgTeacher = new TextField();
		txtRgTeacher.setLayoutX(10);
		txtRgTeacher.setLayoutY(120);
		txtRgTeacher.setMaxWidth(150);
		txtRgTeacher.setMinWidth(150);
		txtRgTeacher.setPrefWidth(150);

		// creating the CPF textfield
		txtCpfTeacher = new TextField();
		txtCpfTeacher.setLayoutX(300);
		txtCpfTeacher.setLayoutY(120);
		txtCpfTeacher.setMaxWidth(150);
		txtCpfTeacher.setMinWidth(150);
		txtCpfTeacher.setPrefWidth(150);

		// creating the Area textfield
		txtArea = new TextField();
		txtArea.setLayoutX(10);
		txtArea.setLayoutY(240);
		txtArea.setMaxWidth(150);
		txtArea.setMinWidth(250);
		txtArea.setPrefWidth(150);

		CheckBox cb3 = new CheckBox("Segundo");
		cb3.setText("M");
		cb3.setSelected(true);
		cb3.setLayoutX(10);
		cb3.setLayoutY(180);

		CheckBox cb4 = new CheckBox("Segundo");
		cb4.setText("F");
		cb4.setSelected(true);
		cb4.setLayoutX(70);
		cb4.setLayoutY(180);

		// adding all created components to the pane
		pane.getChildren().add(lblCadTeacher);
		pane.getChildren().add(lblNomeTeacher);
		pane.getChildren().add(lblNascTeacher);
		pane.getChildren().add(lblRgTeacher);
		pane.getChildren().add(lblCpfTeacher);
		pane.getChildren().add(lblSexoTeacher);
		pane.getChildren().add(lblArea);
		pane.getChildren().add(btnTeacherAdd);
		pane.getChildren().add(btnTeacherCanc);
		pane.getChildren().add(txtnomeTeacher);
		pane.getChildren().add(txtNascTeacher);
		pane.getChildren().add(txtRgTeacher);
		pane.getChildren().add(txtCpfTeacher);
		pane.getChildren().add(txtArea);
		pane.getChildren().add(cb3);
		pane.getChildren().add(cb4);

		// melhorando aparencia do painel principal
		pane.setStyle("-fx-background-color:	linear-gradient(\n"
				+ "from	0%	0%	to	100%	100%,	white	0%,	silver	100%);");

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void Cancel(Stage stage) {
		try {
			new TeacherScream().start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAdd() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(Strings.message3);
		alert.setHeaderText(Strings.message3);
		alert.showAndWait();
	}

	private void cancel() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(Strings.message4);
		alert.setHeaderText(Strings.message5);
		alert.showAndWait();
	}

}
