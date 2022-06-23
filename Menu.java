package HW_01;
//Gil Levkovitch ID:312496821

import java.util.ArrayList;
import java.util.Collections;

public class Menu<T extends Product> implements MenuFunction<T> {
	private double sumPrices;
	private ArrayList<T> menu;

	public Menu() {
		this.menu = new ArrayList<T>();
	}

	public double plus(Number num1, Number num2) {
		return num1.doubleValue() + num2.doubleValue();
	}

	// methods from interface
	@Override
	public void createProduct(ArrayList<Product> listOfProducts, T product) {
		listOfProducts.add(product);
	}

	@Override
	public void deleteProduct(ArrayList<Product> listOfProducts, int index) {
		listOfProducts.remove(index);
	}

	@Override
	public void add(T product) {
		menu.add(product);
		setTotalPrice(sumPrices + product.getPrice().doubleValue());
	}

	@Override
	public void addAll(ArrayList<T> arr1, ArrayList<T> arr2) {
		for (int i = 0; i < arr1.size(); i++) {
			arr1.add(i, arr2.get(i));
		}
	}

	@Override
	public void remove(int index) {
		setTotalPrice(sumPrices - menu.get(index).getPrice().doubleValue());
		menu.remove(index);

	}

	@Override
	public void removeAll() {
		menu.clear();
		setTotalPrice(0);
	}

	@Override
	public void print(ArrayList<? extends Product> ArrayList) {
		for (int i = 0; i < ArrayList.size(); i++) {
			System.out.println(ArrayList.get(i));
		}
	}

	@Override
	public void sort(ArrayList<? extends Product> ArrayList) {
		Collections.sort(ArrayList);
	}

	@Override
	public int search(ArrayList<? extends Product> ArrayList, String name, Number price) {
		int low = 0, high = ArrayList.size() - 1, middle;
		while (low <= high) {
			middle = (low + high) / 2;
			if (name.compareTo(ArrayList.get(middle).getName()) < 0) {
				high = middle - 1;
			} else if (name.compareTo(ArrayList.get(middle).getName()) > 0) {
				low = middle + 1;
			} else if (name.compareTo(ArrayList.get(middle).getName()) == 0) {
				if (price.equals(ArrayList.get(middle).getPrice())) {
					return middle;
				} else {
					double priceCheck = price.doubleValue();
					double distance = Math.abs(ArrayList.get(0).getPrice().doubleValue());
					int i = 0;
					double dis = 0;
					for (int j = 0; j < ArrayList.size(); j++) {
						if (ArrayList.get(j).getName().equals(name)) {
							dis = Math.abs(ArrayList.get(j).getPrice().doubleValue() - priceCheck);
							if (dis <= distance) {
								i = j;
								distance = dis;
							}
						}
					}
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Menu: \nCount:    " + menu.size() + "     Total Price:     " + sumPrices + "\n" + menu.toString();
	}

	public double getTotalPrice() {
		return sumPrices;
	}

	public void setTotalPrice(double totalPrice) {
		this.sumPrices = totalPrice;
	}

	public ArrayList<T> getMenuList() {
		return menu;
	}

	public void setMenuList(ArrayList<T> menuList) {
		this.menu = menuList;
	}
}