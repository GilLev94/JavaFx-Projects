package HW_01;
//Gil Levkovitch ID:312496821

public class Worker extends Person {

	private int Salary;
	private String UserName;
	private String Password;

	public Worker(int salary, String userName, String password) {
		super();
		this.Salary = salary;
		this.Password = password;
		this.UserName = userName;
	}

	@Override
	public boolean equals(Object obj) {
		if (((obj instanceof Worker)) && !(obj instanceof Manager)) {

			return false;
		} else {
			Worker worker = (Worker) obj;
			if (this.getSalary() == worker.getSalary()) {
				return true;
			}
		}
		return super.equals(obj);
	}

	@override
	public String toString() {
		return super.toString() + "  " + "+" + "  " + +getSalary();
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		this.Salary = salary;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
