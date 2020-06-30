package ch.makery.management.controller;

import java.sql.SQLException;
import java.util.List;

import ch.makery.management.ContactPersonal;
import ch.makery.management.model.Personal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentUpdateController {

	@FXML
	private TextField Field1;// first name
	@FXML
	private TextField Field2;// last name
	@FXML
	private TextField Field3;// age
	@FXML
	private TextField Field4;// id
	@FXML
	private TextField Field5;// city
	@FXML
	private TextField Field6;// birthday
	@FXML
	private TextField Field7;// average
	private Stage dialogStage;
	private Personal student;
	private boolean okClicked = false;

	@FXML
	private void initialize() {
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setStudent(Personal student) {
		this.student = student;

		Field1.setText(student.getS1());
		Field2.setText(student.getS2());
		Field3.setText(Integer.toString(student.getI2()));
		Field4.setText(Integer.toString(student.getI3()));
		Field5.setText(student.getS3());
		Field6.setText((student.getS4()));
		Field6.setPromptText("dd-mm-yyyy");
		Field7.setText(student.getS5());
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	ContactPersonal cnps = new ContactPersonal();

	public ObservableList<Personal> getStudent() {
		List<Personal> list = cnps.getData();
		ObservableList<Personal> student = FXCollections.observableArrayList(list);
		return student;
	}

	@FXML
	private void handleOk() throws SQLException {
		if (isInputValid()) {
			ContactPersonal cnps = new ContactPersonal();
			student.setS1(Field1.getText());
			student.setS2(Field2.getText());
			student.setI2(Integer.parseInt(Field3.getText()));
			//student.setI3(Integer.parseInt(Field4.getText()));
			student.setS3(Field5.getText());
			student.setS4(Field6.getText());
			student.setS5(Field7.getText());
			cnps.updateData(student);
			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (Field1.getText() == null || Field1.getText().length() == 0) {
			errorMessage += "No valid firstname!\n";
		}
		if (Field2.getText() == null || Field2.getText().length() == 0) {
			errorMessage += "No valid lastname!\n";
		}
		
		if (Field3.getText() == null || Field3.getText().length() == 0) {
			errorMessage += "No valid age!\n";
		} else {
			try {
				Integer.parseInt(Field3.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid age (must be an integer)!\n";
			}
		}

		if (Field4.getText() == null || Field4.getText().length() == 0) {
			errorMessage += "No valid id!\n";
		}
		else {
			try {
				Integer.parseInt(Field4.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid id (must be an integer)!\n";
			}
		}

		if (Field5.getText() == null || Field5.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		if (Field6.getText() == null || Field6.getText().length() == 0) {
			errorMessage += "No valid birthday!\n";
		}

		if (Field7.getText() == null || Field7.getText().length() == 0) {
			errorMessage += "No valid average!\n";
		} 
		if (errorMessage.length() == 0) {
				return true;
			} else {
				// Show the error message.
				Alert alert = new Alert(AlertType.ERROR);
				alert.initOwner(dialogStage);
				alert.setTitle("Invalid Fields");
				alert.setHeaderText("Please correct invalid fields");
				alert.setContentText(errorMessage);

				alert.showAndWait();

				return false;
			}
		}
	}
