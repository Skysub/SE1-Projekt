package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {
    static Database database = new Database();
    static ListView<Employee> employeeList = new ListView<>();
    static ListView<Activity> employeeActivityList = new ListView<>();
    static ListView<Project> ProjectList = new ListView<>();
    static ListView<Activity> ProjectActivityList = new ListView<>();
    static BorderPane root = new BorderPane();
    static HBox topBar = new HBox();
    static VBox employeesView = new VBox();
    static VBox projectsView = new VBox();
    static VBox personalView = new VBox();
    static Button employeesBtn = new Button("Employees");
    static Button projectsBtn = new Button("Projects");
    static Button personalBtn = new Button("Personal");
    static Label employeesLabel = new Label("Employees");
    static TextField createEmployeeText = new TextField();
    static Button createEmployeeBtn = new Button("Create Employee");
    static Label projectsLabel = new Label("Projects");
    static TextField createProjectText = new TextField();
    static Button createProjectBtn = new Button("Create Project");
    static Label personalLabel = new Label("Personal");
    

    @Override
    public void start(Stage primaryStage) {
        
        root.setPadding(new Insets(10));

        setupTopBar();
        setupEmployeeView();
        setupProjectView();
        setupPersonalView();      
        
        root.setCenter(employeesView);
        employeesBtn.setOnAction(event -> employeeButtonClick());
        projectsBtn.setOnAction(event -> projectsButtonClick());
        personalBtn.setOnAction(event -> personalButtonClick());
        createProjectBtn.setOnAction(event -> createProjectClick());
        createEmployeeBtn.setOnAction(event -> createEmployeeClick());

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //View Setup methods ----
    private static void setupTopBar(){
        topBar.setAlignment(Pos.CENTER);
        topBar.setSpacing(20);
        topBar.getChildren().addAll(employeesBtn, projectsBtn, personalBtn);
        root.setTop(topBar);
    }

    private static void setupEmployeeView(){
        employeesView.setAlignment(Pos.CENTER);
        employeesView.setSpacing(10);
        employeesView.getChildren().addAll(employeesLabel, new HBox(employeeList, employeeActivityList), createEmployeeText, createEmployeeBtn);
        updateEmployeeList();
    }

    private static void setupProjectView(){
        projectsView.setAlignment(Pos.CENTER);
        projectsView.setSpacing(10);
        projectsView.getChildren().addAll(projectsLabel, new HBox(ProjectList, ProjectActivityList), createProjectText, createProjectBtn);
        updateProjectList();
    }

    private static void setupPersonalView(){
        personalView.setAlignment(Pos.CENTER);
        personalView.setSpacing(10);
        personalView.getChildren().addAll(personalLabel);
    }

    // ----------------------------------

    //Controller methods TODO put into controller class
    private static void employeeButtonClick(){
        root.setCenter(employeesView);
        updateEmployeeList();
    }

    private static void projectsButtonClick(){
        root.setCenter(projectsView);
        updateProjectList();
    }

    private static void personalButtonClick(){
        root.setCenter(personalView);
    }

    private static void createProjectClick(){
        try {
            database.CreateProject(0, createProjectText.getText());
            updateProjectList();
        } catch (IllegalOperationException e) {
            createProjectText.setText(e.getMessage());
        }
    }

    private static void createEmployeeClick(){
        try {
            database.CreateEmployee(createEmployeeText.getText());
            updateEmployeeList();
        } catch (Exception e) {
            createEmployeeText.setText(e.getMessage());
        }
    }

    public static void updateEmployeeList(){
        ArrayList<Employee> ListOfEmployees = new ArrayList<Employee>(database.employees.values());
        employeeList.getItems().clear();
        for (int i = 0; i < ListOfEmployees.size(); i++){
            employeeList.getItems().add(ListOfEmployees.get(i));
        }
    }

    public static void updateEmployeeActivityList(Employee e){
        employeeActivityList.getItems().clear();
        for (int i = 0; i < e.getActivities().size(); i++){
            employeeActivityList.getItems().add(e.getActivities().get(i));
        }
    }

    public static void updateProjectList(){
        ArrayList<Project> ListOfProjects = new ArrayList<Project>(database.projects.values());
        ProjectList.getItems().clear();
        for (int i = 0; i < ListOfProjects.size(); i++){
            ProjectList.getItems().add(ListOfProjects.get(i));
        }
    }

    public static void updateProjectActivityList(Project p){
        ProjectActivityList.getItems().clear();
        for (int i = 0; i < p.getActivities().size(); i++){
            ProjectActivityList.getItems().add(p.getActivities().get(i));
        }
    }
    
    

}
