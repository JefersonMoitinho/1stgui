package br.edu.ifsc.ui.stages;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.ui.util.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherScream extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(480, 300);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lbTeacherScream = new Label(Strings.lblTeacherScream);
		lbTeacherScream.setLayoutX(10);
		lbTeacherScream.setLayoutY(10);

		// creating the return button
		Button btnTeacherVoltar = new Button(Strings.btnTeacherVoltar);
		btnTeacherVoltar.setLayoutX(360);
		btnTeacherVoltar.setLayoutY(30);
		btnTeacherVoltar.setMaxWidth(80);
		btnTeacherVoltar.setMinWidth(15);
		btnTeacherVoltar.setPrefWidth(150);
		btnTeacherVoltar.setOnMouseClicked(e -> {
			Menu(stage);
		});

		// creating the return button
		Button btnTeacherCad = new JFXButton(Strings.btnTeachertCad);
		btnTeacherCad.setLayoutX(260);
		btnTeacherCad.setLayoutY(240);
		btnTeacherCad.setMaxWidth(80);
		btnTeacherCad.setMinWidth(15);
		btnTeacherCad.setPrefWidth(150);
		btnTeacherCad.setOnMouseClicked(e -> {
			Cad(stage);
		});
		btnTeacherCad.setStyle("-fx-background-color: #007FFF; -fx-text-fill: white;");

		// creating the return button
		JFXButton btnTeacherDel = new JFXButton(Strings.btnTeacherDel);
		btnTeacherDel.setLayoutX(360);
		btnTeacherDel.setLayoutY(240);
		btnTeacherDel.setMaxWidth(80);
		btnTeacherDel.setMinWidth(15);
		btnTeacherDel.setPrefWidth(150);
		btnTeacherDel.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");

		// adding all created components to the pane
		pane.getChildren().add(lbTeacherScream);
		pane.getChildren().add(btnTeacherVoltar);
		pane.getChildren().add(btnTeacherCad);
		pane.getChildren().add(btnTeacherDel);

		// melhorando aparencia do painel principal
		pane.setStyle("-fx-background-color:	linear-gradient(\n"
				+ "from	0%	0%	to	100%	100%,	white	0%,	silver	100%);");

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void Menu(Stage stage) {
		try {
			new Main("admin").start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Cad(Stage stage) {
		try {
			new CadTeacher().start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
