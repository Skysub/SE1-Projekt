package application;

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

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER);
        topBar.setSpacing(20);

        Button employeesBtn = new Button("Employees");
        Button projectsBtn = new Button("Projects");
        Button personalBtn = new Button("Personal");

        topBar.getChildren().addAll(employeesBtn, projectsBtn, personalBtn);

        VBox employeesView = new VBox();
        employeesView.setAlignment(Pos.CENTER);
        employeesView.setSpacing(10);

        Label employeesLabel = new Label("Employees");

        ListView<String> leftList = new ListView<>();
        leftList.getItems().addAll("Employee 1", "Employee 2", "Employee 3");

        ListView<String> rightList = new ListView<>();
        rightList.getItems().addAll("Employee 4", "Employee 5", "Employee 6");

        Button addEmployeeBtn = new Button("Add Employee");

        employeesView.getChildren().addAll(employeesLabel, new HBox(leftList, rightList), addEmployeeBtn);

        VBox projectsView = new VBox();
        projectsView.setAlignment(Pos.CENTER);
        projectsView.setSpacing(10);

        Label projectsLabel = new Label("Projects");

        ListView<String> leftProjectList = new ListView<>();
        leftProjectList.getItems().addAll("Project 1", "Project 2", "Project 3");

        ListView<String> rightProjectList = new ListView<>();
        rightProjectList.getItems().addAll("Project 4", "Project 5", "Project 6");

        Button addProjectBtn = new Button("Add Project");

        projectsView.getChildren().addAll(projectsLabel, new HBox(leftProjectList, rightProjectList), addProjectBtn);

        VBox personalView = new VBox();
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
}
