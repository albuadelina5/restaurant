package model;

import java.util.ArrayList;
import java.util.Random;

public class Client {

	int id;
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
	
	//  public  = modificator de acces
	//  Bill = ce returneaza metoda
	//  createOrder = numele metodei
	//  Menu menu = parametrul metodei , Menu - tipul parametrului, menu - numele parametrului
	public Bill createOrder(Menu menu){
	// Metoda createOrder e folosita pentru a crea un obiect de tip Bill care contine lista de Dish-uri comandata de client, creata aleatoriu
		Random random = new Random(); // cream un obiect de tip random
		int numberOfDishes = random.nextInt(5); // generam un numar aleatoriupana in 5 cu obiectul random
		// din obiectul random , folosesc metoda nextInt pentru a genera o valoare de tip int cuprinsa intre 0 si 5
		// timpul de date ce rezulta in urma evaluarii expresiei din dreapta egalului trebuie sa fie la fel ca tipul de date al variabilei din stnga egalului
		ArrayList<Dish> order = new ArrayList<Dish>();
		
		for(int i=0;i<numberOfDishes;i++) {
			order.add(menu.dishes.get(random.nextInt(menu.dishes.size())));
		}
		// creez lista de Dish-uri order local pentru a putea sa o dam ca argument constructorului clasei Bill, de pe linia urmatoare
		return new Bill(order);
	}
	
}
