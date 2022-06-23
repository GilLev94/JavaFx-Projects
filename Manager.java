package HW_01;
//Gil Levkovitch ID:312496821

public class Manager extends Worker {
	private int Bonus;

	public Manager(int bonus, int salary, String UserName, String Password) {
		super(salary, UserName, Password);
		this.Bonus = bonus;
	}

	@override
	public String toString() {
		return super.toString() + "+" + getBonus();

	}

	public int getBonus() {
		return Bonus;
	}

	public void setBonus(int bonus) {
		Bonus = bonus;
	}

	public boolean equals(Object obj) {
		if (((obj instanceof Manager)) && !(obj instanceof Owner)) {
			Manager manager = (Manager) obj;
			if (this.getSalary() + this.getBonus() == manager.getSalary()) {
				return true;
			} else

				return false;

		}
		return super.equals(obj);

	}
}
