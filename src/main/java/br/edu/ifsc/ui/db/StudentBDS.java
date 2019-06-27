package br.edu.ifsc.ui.db;

import java.util.ArrayList;

import br.edu.ifsc.ui.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentBDS implements StudentDBInterface{
	
	private static ObservableList<Student> students;
	
	@Override
	public Student getStudent(String nome) {
		students = getStudents();
		for (Student student : students)
			if (student.getNome().contentEquals(nome))
				return student;
		return null;
	}
	
	@Override
	public ObservableList<Student> getStudents() {
		if (students == null) {
			students = FXCollections.observableArrayList(new ArrayList<Student>());
			students.add(new Student("jeferson", "7169921", "1112777297", "10/10/1998", 68, 1.79, "Carlos Wagner"));
		}
		return students;
	}
	
	public void addStudent(String nome, String rg, String cpf, String data, double peso, double altura,
			String endereco) {
		getStudents().add(new Student(nome, rg, cpf, data, peso, altura, endereco));
	}

}
