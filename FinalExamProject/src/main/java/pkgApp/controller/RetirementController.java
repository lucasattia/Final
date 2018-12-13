package pkgApp.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.poi.ss.formula.functions.FinanceLib;
import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import javafx.beans.value.*;

import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;
	@FXML
	private Label txtSaveEachMonth;
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private Label txtWhatYouNeedToSave;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;

	private HashMap<TextField, String> hmTextFieldRegEx = new HashMap<TextField, String>();

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		// Clear text input
		txtYearsToWork.setText("");
		txtAnnualReturnRetired.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnWorking.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
	}
	@FXML
	public void btnCalculate(ActionEvent event) {
		System.out.println("Calculating...");
		int workingYears = Integer.parseInt(txtYearsToWork.getText());
		double workingReturn = Double.parseDouble(txtAnnualReturnWorking.getText());
		int yearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double retiredReturn = Double.parseDouble(txtAnnualReturnRetired.getText());
		double reqIncome = Double.parseDouble(txtRequiredIncome.getText());
		double monthlySSI = Double.parseDouble(txtMonthlySSI.getText());
		Retirement retire = new Retirement(workingYears,workingReturn ,yearsRetired, retiredReturn, 
		reqIncome, monthlySSI);
		txtWhatYouNeedToSave.setText(Double.toString(retire.TotalAmountToSave()));
		txtSaveEachMonth.setText(Double.toString(retire.MonthlySavings()));
	}
}