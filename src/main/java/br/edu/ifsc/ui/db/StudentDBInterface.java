package br.edu.ifsc.ui.db;

import br.edu.ifsc.ui.entities.Student;
import javafx.collections.ObservableList;

public interface StudentDBInterface {
	
	public Student getStudent(String nome);

	public ObservableList<Student> getStudents();

	public void addStudent(String nome, String rg, String cpf, String data, double peso, double altura,
			String endereco);

}
