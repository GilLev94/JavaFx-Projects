package HW_01;
//Gil Levkovitch ID:312496821

public class Owner extends Manager {
	public static final int BASE = 20000; // owner salary

	public Owner(int bonus, int salary, String UserName, String Password) throws BonusException {
		super(bonus, salary, UserName, Password);
		if (bonus > 10000) {
			throw new BonusException("!! Owner bonus is too high !!");
		}

	}

	@override
	public String toString() {
		return super.toString() + "+" + getBase();

	}

	public static int getBase() {
		return BASE;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Owner)) {
			return false;

		} else {
			Owner owner = (Owner) obj;
			if (this.getSalary() + this.getBonus() == owner.getSalary()) {
				return true;
			}
		}
		return super.equals(obj);
	}

}
