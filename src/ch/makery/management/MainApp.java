package ch.makery.management;


import java.io.IOException;

import ch.makery.management.controller.PersonalOverviewController;
import ch.makery.management.model.Personal;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Personal> studentData = FXCollections.observableArrayList();

	public MainApp() {

	}

	public ObservableList<Personal> getStudentData() {
		return studentData;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Personal Management");

		initRootLayout();

		showStudentOverview();

	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showStudentOverview() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonalDetails.fxml"));
			AnchorPane studentOverview = (AnchorPane) loader.load();

			rootLayout.setCenter(studentOverview);

//			// Give the controller access to the main app.
			PersonalOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public boolean showStudentUpdate(Student student) {
//		try {
//			// Load the fxml file and create a new stage for the popup dialog.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/StudentUpdate.fxml"));
//			AnchorPane page = (AnchorPane) loader.load();
//
//			// Create the dialog Stage.
//			Stage dialogStage = new Stage();
//			dialogStage.setTitle("Update Student Management");
//			dialogStage.initModality(Modality.WINDOW_MODAL);
//			dialogStage.initOwner(primaryStage);
//			Scene scene = new Scene(page);
//			dialogStage.setScene(scene);
//
//			// Set the student into the controller.
//			StudentUpdateController controller = loader.getController();
//			controller.setDialogStage(dialogStage);
//			controller.setStudent(student);
//
//			// Show the dialog and wait until the user closes it
//			dialogStage.showAndWait();
//
//			return controller.isOkClicked();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	public boolean showStudentNew(Student student) {
//		try {
//			// Load the fxml file and create a new stage for the popup dialog.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/StudentNew.fxml"));
//			AnchorPane page = (AnchorPane) loader.load();
//
//			// Create the dialog Stage.
//			Stage dialogStage = new Stage();
//			dialogStage.setTitle("New Student Management");
//			dialogStage.initModality(Modality.WINDOW_MODAL);
//			dialogStage.initOwner(primaryStage);
//			Scene scene = new Scene(page);
//			dialogStage.setScene(scene);
//
//			// Set the student into the controller.
//			StudentNewController controller = loader.getController();
//			controller.setDialogStage(dialogStage);
//			controller.setStudent(student);
//
//			// Show the dialog and wait until the user closes it
//			dialogStage.showAndWait();
//
//			return controller.isOkClicked();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}