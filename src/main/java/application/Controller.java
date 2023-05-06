package application;

import java.util.ArrayList;

public class Controller {
    
    private static View viewer;
    private static Database database;
    private static Employee loggedInUser;

    public Controller(View view, Database db){
        viewer = view;
        database = db;

        viewer.loginBtn.setOnAction(event -> loginBtnClick());
        viewer.employeesBtn.setOnAction(event -> employeeButtonClick());
        viewer.projectsBtn.setOnAction(event -> projectsButtonClick());
        viewer.personalBtn.setOnAction(event -> personalButtonClick());
        viewer.createProjectBtn.setOnAction(event -> createProjectClick());
        viewer.createEmployeeBtn.setOnAction(event -> createEmployeeClick());

    }
    private static void loginBtnClick(){
        String login = viewer.loginField.getText();
        if(login.equals("Admin")){
            loggedInUser = null;
        }
        else if(database.employees.containsKey(login)){
            loggedInUser = database.getEmployee(login);
        }
        else{
            viewer.loginField.setText("User doesn't exist");
            return;
        }
        employeeButtonClick();
    }

    private static void employeeButtonClick(){
        viewer.root.setCenter(viewer.employeesView);
        updateEmployeeList();
    }

    private static void projectsButtonClick(){
        viewer.root.setCenter(viewer.projectsView);
        updateProjectList();
    }

    private static void personalButtonClick(){
        viewer.root.setCenter(viewer.personalView);
    }

    private static void createProjectClick(){
        try {
            database.CreateProject(0, viewer.createProjectText.getText());
            updateProjectList();
        } catch (IllegalOperationException e) {
            viewer.createProjectText.setText(e.getMessage());
        }
    }

    private static void createEmployeeClick(){
        try {
            database.CreateEmployee(viewer.createEmployeeText.getText());
            updateEmployeeList();
        } catch (Exception e) {
            viewer.createEmployeeText.setText(e.getMessage());
        }
    }

    public static void updateEmployeeList(){
        ArrayList<Employee> ListOfEmployees = new ArrayList<Employee>(database.employees.values());
        viewer.employeeList.getItems().clear();
        for (int i = 0; i < ListOfEmployees.size(); i++){
            viewer.employeeList.getItems().add(ListOfEmployees.get(i));
        }
    }

    public static void updateEmployeeActivityList(Employee e){
        viewer.employeeActivityList.getItems().clear();
        for (int i = 0; i < e.getActivities().size(); i++){
            viewer.employeeActivityList.getItems().add(e.getActivities().get(i));
        }
    }

    public static void updateProjectList(){
        ArrayList<Project> ListOfProjects = new ArrayList<Project>(database.projects.values());
        viewer.ProjectList.getItems().clear();
        for (int i = 0; i < ListOfProjects.size(); i++){
            viewer.ProjectList.getItems().add(ListOfProjects.get(i));
        }
    }

    public static void updateProjectActivityList(Project p){
        viewer.ProjectActivityList.getItems().clear();
        for (int i = 0; i < p.getActivities().size(); i++){
            viewer.ProjectActivityList.getItems().add(p.getActivities().get(i));
        }
    }


    
}
