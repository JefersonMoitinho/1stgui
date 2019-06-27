package br.edu.ifsc.ui.util;

import br.edu.ifsc.ui.db.StudentBDS;
import br.edu.ifsc.ui.db.StudentDBInterface;
import br.edu.ifsc.ui.db.UserDBInterface;
import br.edu.ifsc.ui.db.UserJSON;
import br.edu.ifsc.ui.entities.Student;
import javafx.collections.ObservableList;

public class DB {
	public static UserDBInterface users = new UserJSON();
	
	public static StudentDBInterface students = new StudentBDS();
}
