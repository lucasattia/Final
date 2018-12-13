package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {
// Instance variables
	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;

	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}
	public double TotalAmountToSave() {
		// Calls PV method from finance lib
		double pv = (int)(FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, dMonthlySSI - dRequiredIncome,0,false)*100);
		return (double) pv/100;
	}
	public double MonthlySavings() {
		//Calls PMT method  from finance lib
		double pmt = (int)(FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12.0, 0, TotalAmountToSave(),false)*100);
		// cut off decimal places
		return -1*pmt/100;
	}
	//getters and setters 
	public int getiYearsToWork() {
		return iYearsToWork;
	}
	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}
	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}
	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}
	public int getiYearsRetired() {
		return iYearsRetired;
	}
	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}
	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}
	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}
	public double getdRequiredIncome() {
		return dRequiredIncome;
	}
	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}
	public double getdMonthlySSI() {
		return dMonthlySSI;
	}
	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}
}