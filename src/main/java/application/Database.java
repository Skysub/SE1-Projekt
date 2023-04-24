package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Project> projects = new ArrayList<>();

}
