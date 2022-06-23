package HW_01;

public interface ProductFunction extends Comparable<Product>, Cloneable {// being used on Product class{

	public int compareTo(Product product);

	public Object clone();

}
