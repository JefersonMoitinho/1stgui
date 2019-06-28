package br.edu.ifsc.ui.stages;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.ui.util.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private String username;
	private Button btnMenuAluno;
	private Button btnMenuProfessor;
	private Button btnMenuRotinaClasse;
	private Button btnMenuBiblioteca;
	private Button btnMenuDefinicoes;

	public Main(String username) {
		this.username = username;
	}

	@Override
	public void start(Stage stage) throws Exception {
		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(480, 300);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblMain = new Label(Strings.lblMain1 + " " + username + "!");
		lblMain.setLayoutX(10);
		lblMain.setLayoutY(10);

		// creating the exit menu button
		JFXButton btnMenuSair = new JFXButton(Strings.btnMenuSair);
		btnMenuSair.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
		btnMenuSair.setLayoutX(360);
		btnMenuSair.setLayoutY(30);
		btnMenuSair.setMaxWidth(80);
		btnMenuSair.setMinWidth(15);
		btnMenuSair.setPrefWidth(150);
		btnMenuSair.setOnMouseClicked(e -> close(stage));

		// creating the student menu button
		btnMenuAluno = new Button(Strings.btnMenuAluno);
		btnMenuAluno.setLayoutX(40);
		btnMenuAluno.setLayoutY(110);
		btnMenuAluno.setMaxWidth(150);
		btnMenuAluno.setMinWidth(190);
		btnMenuAluno.setPrefWidth(150);
		btnMenuAluno.setOnMouseClicked(e -> {
			telaStudent(stage);
		});

		// creating the teacher menu button
		btnMenuProfessor = new Button(Strings.btnMenuProfessor);
		btnMenuProfessor.setLayoutX(250);
		btnMenuProfessor.setLayoutY(110);
		btnMenuProfessor.setMaxWidth(150);
		btnMenuProfessor.setMinWidth(190);
		btnMenuProfessor.setPrefWidth(150);
		btnMenuProfessor.setOnMouseClicked(e -> {
			telaTeacher(stage);
		});

		// creating the menu button class routine
		btnMenuRotinaClasse = new Button(Strings.btnMenuRotinaClasse);
		btnMenuRotinaClasse.setLayoutX(40);
		btnMenuRotinaClasse.setLayoutY(165);
		btnMenuRotinaClasse.setMaxWidth(150);
		btnMenuRotinaClasse.setMinWidth(190);
		btnMenuRotinaClasse.setPrefWidth(150);

		// creating the library menu button
		btnMenuBiblioteca = new Button(Strings.btnMenuBiblioteca);
		btnMenuBiblioteca.setLayoutX(250);
		btnMenuBiblioteca.setLayoutY(165);
		btnMenuBiblioteca.setMaxWidth(150);
		btnMenuBiblioteca.setMinWidth(190);
		btnMenuBiblioteca.setPrefWidth(150);

		// creating the definition button setting
		btnMenuDefinicoes = new Button(Strings.btnMenuDefinicoes);
		btnMenuDefinicoes.setLayoutX(155);
		btnMenuDefinicoes.setLayoutY(230);
		btnMenuDefinicoes.setMaxWidth(150);
		btnMenuDefinicoes.setMinWidth(190);
		btnMenuDefinicoes.setPrefWidth(150);
		btnMenuDefinicoes.setOnMouseClicked(e -> {
			telaDefinicaoUsuario(stage);
		});

		// adding all created components to the pane
		pane.getChildren().add(lblMain);
		pane.getChildren().add(btnMenuAluno);
		pane.getChildren().add(btnMenuProfessor);
		pane.getChildren().add(btnMenuRotinaClasse);
		pane.getChildren().add(btnMenuBiblioteca);
		pane.getChildren().add(btnMenuDefinicoes);
		pane.getChildren().add(btnMenuSair);

		// melhorando aparencia do painel principal
		pane.setStyle("-fx-background-color:	linear-gradient(\n"
				+ "from	0%	0%	to	100%	100%,	white	0%,	silver	100%);");

		// setting some stage (window) properties
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);

		// showing the created UI
		stage.show();
	}

	private void close(Stage stage) {
		stage.close();
	}

	private void telaStudent(Stage stage) {
		try {
			new StudentScream().start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void telaTeacher(Stage stage) {
		try {
			new TeacherScream().start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void telaDefinicaoUsuario(Stage stage) {
		try {
			new TableUsersStage().start(new Stage(), username);
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
