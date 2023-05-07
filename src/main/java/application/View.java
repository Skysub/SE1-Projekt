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
    static Controller controller;
    static Database database = new Database();
    static ListView<Employee> employeeList = new ListView<>();
    static ListView<Activity> employeeActivityList = new ListView<>();
    static ListView<Project> projectList = new ListView<>();
    static ListView<Activity> projectActivityList = new ListView<>();
    static BorderPane root = new BorderPane();
    static HBox topBar = new HBox();
    static VBox employeesView = new VBox();
    static VBox projectsView = new VBox();
    static VBox personalView = new VBox();
    static VBox loginView = new VBox();
    //TopBar 
    static Button logOutBtn = new Button("Log out");
    static Button employeesBtn = new Button("Employees");
    static Button projectsBtn = new Button("Projects");
    static Button personalBtn = new Button("Personal");
    //Employee view
    static Label employeesLabel = new Label("Employees");
    static TextField createEmployeeText = new TextField();
    static Button createEmployeeBtn = new Button("Create Employee");
    //ProjectView
    static Label projectsLabel = new Label("Projects");
    static TextField createProjectText = new TextField();
    static Button createProjectBtn = new Button("Create Project");
    static TextField createProjectActivityText = new TextField();
    static Button createProjectActivityBtn = new Button("Create Activity");
    //PersonalView
    static Label personalLabel = new Label("Personal");

    static TextField loginField = new TextField();
    static Button loginBtn = new Button("Login");
    

    @Override
    public void start(Stage primaryStage) {
        
        root.setPadding(new Insets(10));

        setupTopBar();
        setupEmployeeView();
        setupProjectView();
        setupPersonalView();
        setupLoginView();
        root.setCenter(loginView);              

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Application");
        controller = new Controller(this, database);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //View Setup methods ----
    private static void setupLoginView(){
        loginView.setAlignment(Pos.CENTER);
        loginView.setSpacing(10);
        loginView.getChildren().addAll(loginField,loginBtn);
    }

    private static void setupTopBar(){
        topBar.setAlignment(Pos.CENTER);
        topBar.setSpacing(20);
        topBar.getChildren().addAll(employeesBtn, projectsBtn, personalBtn);
    }

    private static void setupEmployeeView(){
        employeesView.setAlignment(Pos.CENTER);
        employeesView.setSpacing(10);
        employeesView.getChildren().addAll(employeesLabel, new HBox(employeeList, employeeActivityList), createEmployeeText, createEmployeeBtn);
    }

    private static void setupProjectView(){
        projectsView.setAlignment(Pos.CENTER);
        projectsView.setSpacing(10);
        projectsView.getChildren().addAll(projectsLabel, new HBox(projectList, 
        new VBox(projectActivityList,createProjectActivityText,createProjectActivityBtn))
        , createProjectText, createProjectBtn);
    }

    private static void setupPersonalView(){
        personalView.setAlignment(Pos.CENTER);
        personalView.setSpacing(10);
        personalView.getChildren().addAll(personalLabel);
    }
}
