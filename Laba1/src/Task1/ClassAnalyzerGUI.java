package Task1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClassAnalyzerGUI extends Application {

    private TextField classNameField;
    private Button analyzeButton;
    private Button clearButton;
    private Button exitButton;
    private TextArea resultArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Class Analyzer");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label classNameLabel = new Label("Class Name:");
        GridPane.setConstraints(classNameLabel, 0, 0);

        classNameField = new TextField();
        GridPane.setConstraints(classNameField, 1, 0);

        analyzeButton = new Button("Analyze");
        GridPane.setConstraints(analyzeButton, 0, 2);
        analyzeButton.setOnAction(e -> analyzeClass());

        clearButton = new Button("Clear");
        GridPane.setConstraints(clearButton, 1, 2);
        clearButton.setOnAction(e -> clearFields());

        exitButton = new Button("Exit");
        GridPane.setConstraints(exitButton, 2, 2);
        exitButton.setOnAction(e -> primaryStage.close());

        resultArea = new TextArea();
        resultArea.setEditable(false);
        GridPane.setConstraints(resultArea, 0, 1, 3, 1);

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(analyzeButton, clearButton, exitButton);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));
        buttonBox.setSpacing(10);
        GridPane.setConstraints(buttonBox, 0, 2, 3, 1);

        grid.getChildren().addAll(classNameLabel, classNameField, resultArea, buttonBox);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void analyzeClass() {
        String className = classNameField.getText();
        try {
            String classDescription = ClassAnalyzer.getClassDescription(className);
            resultArea.setText(classDescription);
        } catch (ClassNotFoundException e) {
            resultArea.setText("Class not found: " + className);
        }
    }

    private void clearFields() {
        classNameField.clear();
        resultArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
