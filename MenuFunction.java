package HW_01;
//Gil Levkovitch ID:312496821

import java.util.ArrayList;

public interface MenuFunction<T extends Product> {

	public void deleteProduct(ArrayList<Product> productList, int index);

	public void add(T p);

	public void addAll(ArrayList<T> arr1, ArrayList<T> arr2);

	public void remove(int index);

	public void removeAll();

	void sort(ArrayList<? extends Product> ArrayList);

	void print(ArrayList<? extends Product> ArrayList);

	int search(ArrayList<? extends Product> ArrayList, String name, Number price);

	void createProduct(ArrayList<Product> listOfProducts, T product);

}
