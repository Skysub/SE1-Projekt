package application;

import java.util.ArrayList;

//Klassen er skrevet af Frederik Hvarregaard
public class Controller {
    
    private static View viewer;
    private static Database database;
    private static Employee loggedInUser;
    private static Project currentProject;
    public static int currentProjectID = 23000;

    public Controller(View view, Database db) {
        viewer = view;
        database = db;

        viewer.loginBtn.setOnAction(event -> loginBtnClick());
        viewer.logOutBtn.setOnAction(event -> logoutButtonClick());
        viewer.employeesBtn.setOnAction(event -> employeeButtonClick());
        viewer.projectsBtn.setOnAction(event -> projectsButtonClick());
        viewer.personalBtn.setOnAction(event -> personalButtonClick());
        viewer.createProjectBtn.setOnAction(event -> createProjectClick());
        viewer.createEmployeeBtn.setOnAction(event -> createEmployeeClick());
        viewer.createProjectActivityBtn.setOnAction(event -> createProjectActivityClick());
        viewer.createPersonalActivityBtn.setOnAction(event -> createPersonalActivityClick());

        viewer.employeeList.setOnMouseClicked(event -> updateEmployeeActivityList(viewer.employeeList.getSelectionModel().getSelectedItem()));
        viewer.projectList.setOnMouseClicked(event -> updateProjectActivityList(viewer.projectList.getSelectionModel().getSelectedItem()));

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
        viewer.root.setTop(viewer.topBar);
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
        if(loggedInUser != null){
            viewer.root.setCenter(viewer.personalView);
            updatePersonalActivityList();
        }
        //TODO give error message
    }

    private static void logoutButtonClick(){
        viewer.root.setTop(null);
        viewer.root.setCenter(viewer.loginView);
        loggedInUser = null;
    }

    private static void createProjectClick(){
        String projectName = viewer.createProjectText.getText();
        if(!projectName.equals("")){
            try {
                database.CreateProject(projectID(), projectName);
                updateProjectList();
            } catch (IllegalOperationException e) {
                viewer.createProjectText.setText(e.getMessage());
            }
        }   
    }

    private static void createProjectActivityClick(){
        if(currentProject == null){
            viewer.createProjectActivityText.setText("Select project");
            return;
        }
        else{
            String activityName = viewer.createProjectActivityText.getText();
            if (!activityName.equals("")){
                try {
                    currentProject.addActivity(new WorkActivity(activityName, 1, 2));
                } catch (IllegalOperationException e) {
                    viewer.createProjectActivityText.setText(e.getMessage());				
                }
                updateProjectActivityList(currentProject); 
            }           
        } 
    }

    private static void createPersonalActivityClick(){
        String activityName = viewer.createPersonalActivityText.getText();
        if(!activityName.equals("")){
            try {
                loggedInUser.addActivity(new PersonalActivity(activityName, PAType.OTHER, loggedInUser));
            } catch (IllegalOperationException e) {
                viewer.createPersonalActivityText.setText(e.getMessage());
            }
            updatePersonalActivityList();
        }
    }

    private static void createEmployeeClick(){
        String initials = viewer.createEmployeeText.getText();
        if (!initials.equals("")){
            try {
                database.CreateEmployee(initials);
                updateEmployeeList();
            } catch (IllegalOperationException e) {
                viewer.createEmployeeText.setText(e.getMessage());
            }
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
        viewer.projectList.getItems().clear();
        for (int i = 0; i < ListOfProjects.size(); i++){
            viewer.projectList.getItems().add(ListOfProjects.get(i));
        }
    }

    public static void updateProjectActivityList(Project p){
        currentProject = p;
        viewer.projectActivityList.getItems().clear();
        for (int i = 0; i < p.getActivities().size(); i++){
            viewer.projectActivityList.getItems().add(p.getActivities().get(i));
        }
    }

    public static void updatePersonalActivityList(){
        viewer.personalActivityList.getItems().clear();
        for (int i = 0; i < loggedInUser.getActivities().size(); i++){
            viewer.personalActivityList.getItems().add(loggedInUser.getActivities().get(i));
        }
    }

    public static int projectID(){
        currentProjectID++;
        return currentProjectID;
    }
    
}
