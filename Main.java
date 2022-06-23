package HW_01;
//Gil Levkovitch ID:312496821

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static int costByType(ArrayList<Person> employees, Scanner scn) {
		System.out.println(
				"Please type a character to get total cost by type:  \n" + "[M/m], [W/w], [O/o]. [F/f] to finish:");
		char type = scn.next().toLowerCase().charAt(0);
		int totalSalarys = totalCost(employees, scn, type);
		return totalSalarys;
	}

	public static int totalCost(ArrayList<Person> arr, Scanner scn, char type) {
		boolean isTrue = true;
		do {
			int total = 0;
			if (type == 'f') {
				isTrue = false;
			} else if (type == 'w') {
				for (int i = 0; i < arr.size(); i++) {
					if (!(arr.get(i) instanceof Manager)) {
						total += ((Worker) arr.get(i)).getSalary();
					}
				}
			} else if (type == 'm') {
				for (int i = 0; i < arr.size(); i++) {
					if (!(arr.get(i) instanceof Owner) && (arr.get(i) instanceof Manager)) {
						total += ((Manager) arr.get(i)).getSalary();
						total += ((Manager) arr.get(i)).getBonus();
					}
				}
			} else if (type == 'o') {
				for (int i = 0; i < arr.size(); i++) {
					if (arr.get(i) instanceof Owner) {
						total += ((Owner) arr.get(i)).getSalary();
						total += ((Owner) arr.get(i)).getBonus();
						total += ((Owner) arr.get(i)).getBase();
					}
				}
			} else {
				costByType(arr, scn);
			}

			return total;
		} while (isTrue);
	}

	public static void compare(ArrayList<Person> employees) {// homework number 1 checks if there are 2 employees the
																// same
		Scanner scn = new Scanner(System.in);
		Boolean Identify = true;
		while (Identify) {
			System.out.println("Enter the first index , tap -1 to end");
			int Index1 = scn.nextInt();
			if (Index1 == -1) {
				System.out.println("The program ended");
				Identify = false;
				break;
			} else {
				System.out.println("Enter Second Index:");
				int Index2 = scn.nextInt();
				if (employees.get(Index1).equals(employees.get(Index2))) {
					System.out.println("Is Equals!");
				} else {
					System.out.println("Is not Equals");
				}
			}
		}
	}

	public static void costOfAllBonuses(ArrayList<Person> employee) {
		int Total = 0;
		for (int i = 0; i < employee.size(); i++) {
			if (employee.get(i) instanceof Manager) {
				Total += ((Manager) employee.get(i)).getBonus();

			}
		}
	}

	public static void printEmployees(ArrayList<Person> employees) {
		System.out.println("The list content: ");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).getClass().getSimpleName() + ": " + employees.get(i).toString());
		}
	}

	public static void addMeatToMenu(Scanner scn, ArrayList<Product> allProducts, Menu<Burgers> menu) {
		System.out.println("Your Option: 3 \n");
		System.out.println("Add Burger To Menu:\n" + "Please Enter Name: ");
		String name = scn.next() + scn.nextLine();
		System.out.println("Please Enter the Price: ");
		Number price = scn.nextDouble();
		System.out.println("Result: \n");
		int index = menu.search(allProducts, name, price);
		System.out.println(allProducts.get(index).toString());
		System.out.println("Are You Sure?(Y/N) \n");
		char answer = scn.next().toLowerCase().charAt(0);
		if (answer == 'y') {
			menu.add((Burgers) allProducts.get(index));
			System.out.println("The Burger Has Been Added Successfully! \n");
		}
	}

	public static void createBurgersMenu(Scanner scn, ArrayList<Product> allProducts, Menu<Burgers> menu) {
		boolean check = true;
		while (check) {
			System.out.println("-------------------------------------------------------------------------\n"
					+ "Welcome to \"On-Click Hamburger\" Menu Creator\n"
					+ "-------------------------------------------------------------------------\n"
					+ " -------------------------------------------------------------------------\n"
					+ "1. Create New Hamburger\n" + "2. Delete Hamburger\n" + "3. Add Hamburger To Menu\n"
					+ "4. Remove Hamburger From Menu\n" + "5. Remove All Hamburgers From Menu\n"
					+ "6. Search Hamburger By Name And Price\n" + "7. Print All Products\n" + "8. Print Menu\n"
					+ "Choose your option or any other key to EXIT");
			String option = scn.next();

			if (option.equals("1")) {
				createMeatForMenu(scn, option, check, allProducts, menu);// Create a new burger
				menu.sort(allProducts);
			} else if (option.equals("2")) {// Delete burger
				deleteMeatFromMenu(scn, allProducts, menu);
				menu.sort(allProducts);
			} else if (option.equals("3")) {
				addMeatToMenu(scn, allProducts, menu);// Adding Burger to the menu
				menu.sort(menu.getMenuList());
			} else if (option.equals("4")) {
				if (menu.getMenuList().isEmpty()) {
					System.out.println("Menu is Empty");
				} else {
					removeMeatFromMenu(scn, allProducts, menu);
					menu.sort(menu.getMenuList());
				}
			} else if (option.equals("5")) {
				System.out.println("Your Option: 5 \n");
				System.out.println("REMOVE ALL HAMBURGERS FROM MENU:");
				System.out.println("Are You Sure?(Y/N) \n");
				char answer = scn.next().toLowerCase().charAt(0);
				if (answer == 'y') {
					if (menu.getMenuList().isEmpty()) {
						System.out.println("Menu is Empty!");
					} else {
						menu.removeAll();
						System.out.println("All Hamburgers were Removed from Menu! \n");
					}
				}
			} else if (option.equals("6")) { // Search Hamburger By Name And Price
				searchMeatInMenu(scn, allProducts, menu);
			} else if (option.equals("7")) { // Print All Products
				System.out.println("Your Option: 7 \n");
				if (allProducts.isEmpty()) {
					System.out.println("There Are No Products!");
				} else {
					menu.print(allProducts);
				}
			} else if (option.equals("8")) { // Print Menu
				System.out.println("Your Option: 8 \n");
				if (menu.getMenuList().isEmpty()) {
					System.out.println(menu.toString() + " \n " + "Result:\nMenu is Empty!");
				} else {
					System.out.println(menu.toString() + "\n");
				}
			} else { // finish creating menu
				System.out.println("Your Option: " + option);
				System.out.println("Finished! \n" + "Program ends now..");
				check = false;
				System.exit(0);

			}
		}
	}

	public static void insertIntoList(ArrayList<Person> employees, Scanner scn) throws BonusException {

		boolean Check = true;
		while (Check) {
			System.out.println("[O/o],[M/m],[W/w]. [F/f] to finish:");
			char type = scn.next().toLowerCase().charAt(0);
			if (type == 'f') {
				Check = false;
				break;
			} else if (type == 'w') {
				System.out.println("Please Enter Worker name: ");
				String Name = scn.next();
				int Salary = 0;
				boolean HasContinue = true;
				do {
					try {
						System.out.println("Please enter salary: ");
						Salary = scn.nextInt();
						if (Salary < 0) {
							throw new IllegalArgumentException();
						}
						HasContinue = false;
					} catch (IllegalArgumentException e) {
						System.out.println("Salary must be at least 0!");

					} catch (InputMismatchException e) {
						System.out.println("Invalid type for salary, integer is needed!");
						scn.next();
					}
				} while (HasContinue);
				System.out.println("Please Enter UserName: ");
				String userName = scn.next();
				System.out.println("Please Enter Password: ");
				String password = scn.next();
				Worker w = new Worker(Salary, userName, password);
				w.setName(Name);
				employees.add(w);
			} else if (type == 'm') {
				System.out.println("Please enter full name: ");
				String Name = scn.next();
				int Salary = 0;
				boolean HasContinue = true;
				do {
					try {
						System.out.println("Please enter salary: ");
						Salary = scn.nextInt();
						if (Salary < 0) {
							throw new IllegalArgumentException();
						}
						HasContinue = false;
					} catch (IllegalArgumentException e) {
						System.out.println("Salary must be at least 0!");

					} catch (InputMismatchException e) {
						System.out.println("Invalid type for salary, integer is needed!");
						scn.next();
					}
				} while (HasContinue);
				System.out.println("Please Enter UserName: ");
				String UserName = scn.next();
				System.out.println("Please Enter Password: ");
				String Password = scn.next();
				System.out.println("Please enter bonus : ");
				int bonus = scn.nextInt();
				Manager m = new Manager(bonus, Salary, UserName, Password);
				m.setName(Name);
				employees.add(m);
			} else if (type == 'o') {
				System.out.println("Please Enter Owner name: ");
				String Name = scn.next();
				int Salary = 0;
				boolean HasContinue = true;
				do {
					try {
						System.out.println("Please enter salary: ");
						Salary = scn.nextInt();
						if (Salary < 0) {
							throw new IllegalArgumentException();
						}
						HasContinue = false;
					} catch (IllegalArgumentException e) {
						System.out.println("Salary must be at least 0!");

					} catch (InputMismatchException e) {
						System.out.println("Invalid type for salary, integer is needed!");
						scn.next();
					}
				} while (HasContinue);
				System.out.println("Please Enter UserName: ");
				String UserName = scn.next();
				System.out.println("Please Enter Password: ");
				String Password = scn.next();
				System.out.println("Please enter bonus: ");
				int bonus = scn.nextInt();
				Owner o = new Owner(bonus, Salary, UserName, Password);
				o.setName(Name);
				employees.add(o);
			} else {
				insertIntoList(employees, scn);
			}
		}
	}

	public static void deleteMeatFromMenu(Scanner scn, ArrayList<Product> allProducts, Menu<Burgers> menu) {
		System.out.println("Your Option: 2 \n");
		System.out.println("DELETE Burger:\n" + "Please Enter the Name: ");
		String name = scn.next() + scn.nextLine();
		System.out.println("Please Enter the Price: ");
		Number price = scn.nextDouble();
		int index = menu.search(allProducts, name, price);
		if (index == -1) {
			System.out.println("The Burger Has Not Been Found! \n");
		} else {
			System.out.println("Result: \n");
			System.out.println(allProducts.get(index).toString());

			System.out.println("Are You Sure?(Y/N) \n");
			char answer = scn.next().toLowerCase().charAt(0);
			if (answer == 'y') {
				menu.deleteProduct(allProducts, index);
				System.out.println("Hamburger Deleted Successfully! \n");

				int indexInMenu = menu.search(menu.getMenuList(), name, price);
				if (indexInMenu != -1) {
					menu.remove(indexInMenu);
				}
			}
		}

	}

	public static boolean login(Scanner scn, ArrayList<Person> employees) {// the login system
		System.out.println("*** System LogIn Option: ***");
		System.out.println("Please Enter UserName: ");
		String userName1 = scn.next();
		System.out.println("Please Enter Password: ");
		String password1 = scn.next();
		for (int i = 0; i < employees.size(); i++) {
			if (userName1.equals((((Worker) employees.get(i)).getUserName()))) {
				if (password1.equals(((Worker) employees.get(i)).getPassword())) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public static void createMeatForMenu(Scanner scn, String option, boolean choice, ArrayList<Product> productList,
			Menu<Burgers> menu) {// creates a Burger product into menu.
		if (option.equals("1")) {
			System.out.println("Your Option: 1");
			System.out.println("CREATE NEW Burger:\n" + "Please Enter Name: ");
			String name = scn.next() + scn.nextLine();
			Number price = 0;
			try {
				System.out.println("Please Enter Price: ");
				price = scn.nextDouble();
				scn.nextLine();
				if (price.doubleValue() < 0) {
					throw new PriceException("Illegal Price Input Exception!");
				}
			} catch (PriceException e) {
				System.out.println(e.getMessage());
				System.out.println("Program ends now...");
				choice = false;
				System.exit(0);
			}
			System.out.println("Please enter Ingredients Info: ");
			String ingredients = scn.nextLine();
			System.out.println("Please enter the Wanted size of Meat Roasting (RARE|MEDIUM|MEDIUMWELL|WELLDONE): ");
			String type = scn.next().toUpperCase();
			Burgers burger = new Burgers(ingredients, name, price, type);
			menu.createProduct(productList, burger);
			System.out.println("Burger Created Successfully!");
			System.out.println();
		}
	}

	public static void removeMeatFromMenu(Scanner scn, ArrayList<Product> allProducts, Menu<Burgers> menu) {
		System.out.println("Your Option: 4 \n");
		System.out.println("Removing Burger From Menu:\n" + "Please Enter Name: ");
		String name = scn.next() + scn.nextLine();
		System.out.println("Please Enter Price: ");
		Number price = scn.nextDouble();
		int index = menu.search(menu.getMenuList(), name, price);
		if (index == -1) {
			System.out.println("Burger Has Not Been Found! \n");
		} else {
			System.out.println("Result: \n");
			System.out.println(menu.getMenuList().get(index).toString());
			System.out.println("Are You Sure?(Y/N) \n");
			char answer = scn.next().toLowerCase().charAt(0);
			if (answer == 'y') {
				menu.remove(index);
				System.out.println("The Requested Burger Has Been Removed Successfully! \n");
			}
		}
	}

	public static void searchMeatInMenu(Scanner scn, ArrayList<Product> allProducts, Menu<Burgers> menu) {
		System.out.println("Your Option: 6 \n");
		System.out.println("Search Hamburger By Name And Price \n" + "Please Enter Name: ");
		String name = scn.next() + scn.nextLine();
		Number price = 0;
		try {
			System.out.println("Please Enter Price: ");
			price = scn.nextDouble();
			if (price.doubleValue() < 0) {
				throw new PriceException("Illegal Price Input Exception!");
			}
			System.out.println("Result: \n");
			int index = menu.search(allProducts, name, price);
			System.out.println(allProducts.get(index).toString() + "\n");
		} catch (PriceException e) {
			System.out.println(e.getMessage());
			int index = menu.search(allProducts, name, 0);
			allProducts.get(index).setPrice(0);
			System.out.println("Result: \n");
			System.out.println(allProducts.get(index).toString() + "\n");
		}
	}

	public static void createMenu(Scanner scn, ArrayList<Product> allProducts) {// menu creation
		Menu<Burgers> menu = new Menu<Burgers>();
		createBurgersMenu(scn, allProducts, menu);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		try {
			ArrayList<Person> employees = new ArrayList<Person>();
			ArrayList<Product> allProducts = new ArrayList<Product>();

			insertIntoList(employees, scn);
			printEmployees(employees);

			System.out.println();
			costOfAllBonuses(employees);

			System.out.println();
			System.out.println("cost =" + costByType(employees, scn));

			System.out.println();
			compare(employees);
			System.out.println();
			if ((login(scn, employees) == false)) {
				System.out.println("Program ends now..");
				System.exit(0);
			}
			createMenu(scn, allProducts);

		} catch (BonusException e) {
			System.out.println(e.getMessage());
			System.out.println("Program ends now..");
		}
		scn.close();
	}
}
