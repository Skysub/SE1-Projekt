package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
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
    static ListView<Activity> personalActivityList = new ListView<>();
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
    static TextField createPersonalActivityText = new TextField();
    static Button createPersonalActivityBtn = new Button("Create Activity");


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

    public static void main(String[] args) throws IllegalOperationException {
        showoffsetup();
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
        topBar.getChildren().addAll(logOutBtn,employeesBtn, projectsBtn, personalBtn);
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
        personalView.getChildren().addAll(personalLabel,
                        new HBox(personalActivityList, new VBox(createPersonalActivityText, createPersonalActivityBtn)));
    }


    private static void showoffsetup() throws IllegalOperationException{
        database.CreateEmployee("oooo");
        database.CreateEmployee("abdu");
        database.CreateEmployee("uuuu");
        database.CreateEmployee("uul");
        database.CreateEmployee("fred");
        database.CreateEmployee("nail");
        database.CreateEmployee("karr");
        database.CreateProject(database.CalcNextProjectID(), "første");
        database.CreateProject(database.CalcNextProjectID(), "wuat");
        database.CreateProject(database.CalcNextProjectID(), "coolest project");
        database.CreateProject(database.CalcNextProjectID(), "who killed captain alex");
        database.CreateProject(database.CalcNextProjectID(), "Wusnt me");
        database.CreateProject(database.CalcNextProjectID(), "well it was fookin one o' yuss");
        database.CreateProject(database.CalcNextProjectID(), "DISGUSTANG");
        database.getProject(23004).addActivity(new WorkActivity("PEW PEW PEW"));
        database.getProject(23004).addActivity(new WorkActivity("KEEP GOING KEEP GOING"));
        database.getProject(23004).addActivity(new WorkActivity("oooh, im so hungry"));
        database.getProject(23004).addActivity(new WorkActivity("EVERYONE IN UGANDA KNOWS KUNG FU"));
        database.getProject(23004).addActivity(new WorkActivity("The Tiger Mafia Spy"));
        database.getProject(23004).addActivity(new WorkActivity("This is serious"));
        database.getProject(23004).getActivity("The Tiger Mafia Spy").addEmployee(database.getEmployee("uul"),null);
        database.getProject(23004).getActivity("EVERYONE IN UGANDA KNOWS KUNG FU").addEmployee(database.getEmployee("karr"),null);
        database.getProject(23004).getActivity("EVERYONE IN UGANDA KNOWS KUNG FU").addEmployee(database.getEmployee("fred"),null);
        database.getProject(23004).getActivity("The Tiger Mafia Spy").addEmployee(database.getEmployee("karr"),null);
        database.getProject(23004).getActivity("This is serious").addEmployee(database.getEmployee("uul"),null);
    }

}
