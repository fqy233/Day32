package cn.ye.a_hello;

public class Employee {

	private int empID;
	private String empName;
	private int deptID;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public Employee( String empName, int deptID) {
		this.empName = empName;
		this.deptID = deptID;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", deptID=" + deptID + "]";
	}
	
}
