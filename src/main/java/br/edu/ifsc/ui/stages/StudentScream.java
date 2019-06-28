package br.edu.ifsc.ui.stages;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.ui.entities.Student;
import br.edu.ifsc.ui.util.DB;
import br.edu.ifsc.ui.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudentScream {

	public void start(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(480, 300);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// creating the label component
		Label lblStudentScream = new Label(Strings.lblStudentScream);
		lblStudentScream.setLayoutX(10);
		lblStudentScream.setLayoutY(10);

		// creating the return button
		Button btnStudentVoltar = new Button(Strings.btnStudentVoltar);
		btnStudentVoltar.setLayoutX(450);
		btnStudentVoltar.setLayoutY(10);
		btnStudentVoltar.setMaxWidth(80);
		btnStudentVoltar.setMinWidth(15);
		btnStudentVoltar.setPrefWidth(150);
		btnStudentVoltar.setOnMouseClicked(e -> {
			Menu(stage);
		});

		// creating the cad button
		Button btnStudentCad = new JFXButton(Strings.btnStudentCad);
		btnStudentCad.setLayoutX(330);
		btnStudentCad.setLayoutY(490);
		btnStudentCad.setMaxWidth(80);
		btnStudentCad.setMinWidth(15);
		btnStudentCad.setPrefWidth(150);
		btnStudentCad.setOnMouseClicked(e -> {
			CadS(stage);
			return;
		});
		btnStudentCad.setStyle("-fx-background-color: #007FFF; -fx-text-fill: white;");

		// creating the return button
		JFXButton btnStudentDel = new JFXButton(Strings.btnStudentDel);
		btnStudentDel.setLayoutX(430);
		btnStudentDel.setLayoutY(490);
		btnStudentDel.setMaxWidth(80);
		btnStudentDel.setMinWidth(15);
		btnStudentDel.setPrefWidth(150);
		btnStudentDel.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");

		// creating the users table
		TableView<Student> studentsTable = new TableView<Student>();
		studentsTable.setLayoutX(10);
		studentsTable.setLayoutY(50);
		studentsTable.setPrefSize(620, 420);
		studentsTable.setEditable(true);

		// creating the users table cols
		TableColumn<Student, String> colNome = new TableColumn<>(Strings.nome);
		TableColumn<Student, String> colRg = new TableColumn<>(Strings.rg);
		TableColumn<Student, String> colCpf = new TableColumn<>(Strings.cpf);
		TableColumn<Student, String> colData = new TableColumn<>(Strings.data);
		TableColumn<Student, Double> colPeso = new TableColumn<>(Strings.peso);
		TableColumn<Student, Double> colAltura = new TableColumn<>(Strings.altura);
		TableColumn<Student, String> colEndereco = new TableColumn<>(Strings.endereco);

		// configuring the cols
		colNome.setCellValueFactory(new PropertyValueFactory<Student, String>("nome"));
		colNome.setCellFactory(TextFieldTableCell.forTableColumn());
		colNome.setMinWidth(60);

		colRg.setCellValueFactory(new PropertyValueFactory<Student, String>("rg"));
		colRg.setCellFactory(TextFieldTableCell.forTableColumn());
		colRg.setMinWidth(40);
		
		colCpf.setCellValueFactory(new PropertyValueFactory<Student, String>("cpf"));
		colCpf.setCellFactory(TextFieldTableCell.forTableColumn());
		colCpf.setMinWidth(40);
		
		colData.setCellValueFactory(new PropertyValueFactory<Student, String>("data"));
		colData.setCellFactory(TextFieldTableCell.forTableColumn());
		colData.setMinWidth(40);
		
		colPeso.setCellValueFactory(new PropertyValueFactory<Student, Double>("peso"));
		//colPeso.setCellFactory(TextFieldTableCell.forTableColumn());
		colPeso.setMinWidth(40);
		
		colAltura.setCellValueFactory(new PropertyValueFactory<Student, Double>("altura"));
	//	colAltura.setCellFactory(TextFieldTableCell.forTableColumn());
		colAltura.setMinWidth(40);
		
		colEndereco.setCellValueFactory(new PropertyValueFactory<Student, String>("endereco"));
		colEndereco.setCellFactory(TextFieldTableCell.forTableColumn());
		colEndereco.setMinWidth(60);
		

		// adding the created cols to the table
		studentsTable.getColumns().add(colNome);
		studentsTable.getColumns().add(colRg);
		studentsTable.getColumns().add(colCpf);
		studentsTable.getColumns().add(colData);
		studentsTable.getColumns().add(colPeso);
		studentsTable.getColumns().add(colAltura);
		studentsTable.getColumns().add(colEndereco);

		// adding users data to the table
		studentsTable.setItems(DB.students.getStudents());

		// adding the table to the pane
		pane.getChildren().add(studentsTable);

		// adding all created components to the pane
		pane.getChildren().add(lblStudentScream);
		pane.getChildren().add(btnStudentVoltar);
		pane.getChildren().add(btnStudentCad);
		pane.getChildren().add(btnStudentDel);

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

	private void CadS(Stage stage) {
		try {
			new CadStudent().start(new Stage());
			stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
