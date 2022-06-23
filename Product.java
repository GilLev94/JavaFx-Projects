package HW_01;

public abstract class Product implements ProductFunction {

	protected String name;
	protected Number price;

	public Product(String name, Number price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(Product product) {
		if (this.getName().compareTo(product.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(product.getName()) < 0) {
			return -1;
		} else {
			if (product.getPrice().doubleValue() > this.getPrice().doubleValue()) {
				return 2;
			} else if (product.getPrice().doubleValue() < this.getPrice().doubleValue()) {
				return -2;
			} else {
				return 0;
			}
		}
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}
}
