package HW_01;
//Gil Levkovitch ID:312496821

public class Burgers extends Product {
	public enum RoastSize {
		RARE, MEDIUM, MEDIUMWELL, WELLDONE
	};

	private RoastSize Roast;
	private String Ingredians;

	public Burgers(String Ingredians, String Name, Number Price, String type) {
		super(Name, Price);
		this.Ingredians = Ingredians;
		this.setRoast(RoastSize.valueOf(type));

	}

	@Override
	public Object clone() {
		return clone();
	}

	@Override
	public String toString() {
		return "Burger      " + super.getName() + "        " + super.getPrice() + "        " + Ingredians + "\n";
	}

	public RoastSize getRoast() {
		return Roast;
	}

	public void setRoast(RoastSize roast) {
		Roast = roast;
	}

	public String getIngredians() {
		return Ingredians;
	}

	public void setIngredians(String ingredians) {
		Ingredians = ingredians;

	}

}
