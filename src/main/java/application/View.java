package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    

    @Override
    public void start(Stage primaryStage) {
        
        root.setPadding(new Insets(10));

        //Setting up the top part of the window
        
        topBar.setAlignment(Pos.CENTER);
        topBar.setSpacing(20);
        Button employeesBtn = new Button("Employees");
        Button projectsBtn = new Button("Projects");
        Button personalBtn = new Button("Personal");
        topBar.getChildren().addAll(employeesBtn, projectsBtn, personalBtn);

        //Defining What is shown in the Employees tab
        
        employeesView.setAlignment(Pos.CENTER);
        employeesView.setSpacing(10);
        Label employeesLabel = new Label("Employees");
        Button addEmployeeBtn = new Button("Add Employee");
        updateEmployeeList();

        employeesView.getChildren().addAll(employeesLabel, new HBox(employeeList, employeeActivityList), addEmployeeBtn);

        //Defining what is shown in the Projects tab
        
        projectsView.setAlignment(Pos.CENTER);
        projectsView.setSpacing(10);
        Label projectsLabel = new Label("Projects");
        Button addProjectBtn = new Button("Add Project");
        updateProjectList();
        projectsView.getChildren().addAll(projectsLabel, new HBox(ProjectList, ProjectActivityList), addProjectBtn);

        //Defining what is shown in the Personal tab
        
        personalView.setAlignment(Pos.CENTER);
        personalView.setSpacing(10);
        Label personalLabel = new Label("Personal");
        personalView.getChildren().addAll(personalLabel);



        root.setTop(topBar);
        root.setCenter(employeesView);
        employeesBtn.setOnAction(event -> root.setCenter(employeesView));
        projectsBtn.setOnAction(event -> root.setCenter(projectsView));
        personalBtn.setOnAction(event -> root.setCenter(personalView));

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void employeeButtonClick(){
        root.setCenter(employeesView);
        updateEmployeeList();

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
