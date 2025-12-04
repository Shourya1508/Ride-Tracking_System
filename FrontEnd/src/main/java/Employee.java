

public class Employee {


	private int mast_code;
	

	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String emp_id;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	private String emp_name;

	private String designation;

	private String department;

	private String joined_date;

	private String salary;

	private String addressline1;

	private String addressline2;

	private String city;

	private String state;

	private String country;
	
	

	public Employee(int mast_code,int id, String emp_id, String emp_name, String designation, String department,
			String joined_date, String salary, String addressline1, String addressline2, String city, String state,
			String country) {
		super();
		this.mast_code = mast_code;
		this.id = id;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.designation = designation;
		this.department = department;
		this.joined_date = joined_date;
		this.salary = salary;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMast_code() {
		return mast_code;
	}
	public void setMast_code(int mast_code) {
		this.mast_code = mast_code;
	}

	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(String joined_date) {
		this.joined_date = joined_date;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
