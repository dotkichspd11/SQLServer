package ch.makery.management.controller;

import java.util.List;

import ch.makery.management.ContactPersonal;
import ch.makery.management.MainApp;
import ch.makery.management.model.Personal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonalOverviewController {
	ContactPersonal cnps = new ContactPersonal();

	public ObservableList<Personal> getStudent() {
		List<Personal> list = cnps.getData();
		ObservableList<Personal> student = FXCollections.observableArrayList(list);
		return student;
	}

	@FXML
	private TableView<Personal> studentTable;
	@FXML
	private TableColumn<Personal, Integer> Column1;
	@FXML
	private TableColumn<Personal, String> Column2;
	@FXML
	private TableColumn<Personal, String> Column3;
	@FXML
	private TableColumn<Personal, String> Column4;
	@FXML
	private TableColumn<Personal, String> Column5;
	// Reference to the main application.
	public MainApp mainApp;

	public PersonalOverviewController() {

	}

	@FXML
	private void initialize() {

		Column1.setCellValueFactory(cellData -> cellData.getValue().i1Property().asObject());
		Column2.setCellValueFactory(cellData -> cellData.getValue().s2Property());
		Column3.setCellValueFactory(cellData -> cellData.getValue().i2Property());
		Column4.setCellValueFactory(cellData -> cellData.getValue().s6Property());
		Column5.setCellValueFactory(cellData -> cellData.getValue().s7Property());
		// Clear student details.
		showPersonalTable();
		
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		showPersonalTable();
	}

	

	public void showPersonalTable() {
		Column1.setCellValueFactory(new PropertyValueFactory<>("i1"));
		Column2.setCellValueFactory(new PropertyValueFactory<>("s2"));
		Column3.setCellValueFactory(new PropertyValueFactory<>("i2"));
		Column4.setCellValueFactory(new PropertyValueFactory<>("s6"));
		Column5.setCellValueFactory(new PropertyValueFactory<>("s7"));
		studentTable.getItems().setAll(getStudent());
	}
	
	@FXML
	private void handleDeletePersonal() {

		int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {

			Personal student = studentTable.getItems().get(studentTable.getSelectionModel().getSelectedIndex());
			ContactPersonal.deleteData(student);
			showPersonalTable();
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Personal Selected");
			alert.setContentText("Please select a Personal in the table.");

			alert.showAndWait();
		}
	}
//
//	@FXML
//	private void handleUdateStudent() {
//		Personal selectedStudent = studentTable.getSelectionModel().getSelectedItem();
//		if (selectedStudent != null) {
//			boolean okClicked = mainApp.showStudentUpdate(selectedStudent);
//			if (okClicked) {
//				showStudentDetails(selectedStudent);
//			}
//		} else {
//			// Nothing selected.
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.initOwner(mainApp.getPrimaryStage());
//			alert.setTitle("No Selection");
//			alert.setHeaderText("No Personal Selected");
//			alert.setContentText("Please select a Personal in the table.");
//
//			alert.showAndWait();
//		}
//	}
//
//	@FXML
//	private void handleNewStudent() {
//		Personal tempStudent = new Personal();
//		boolean okClicked = mainApp.showStudentNew(tempStudent);
//		if (okClicked) {
//			mainApp.getStudentData().add(tempStudent);
//		}
//	}
}
