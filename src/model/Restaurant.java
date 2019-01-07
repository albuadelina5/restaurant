package model;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {// clasa Restaurant are 2 atribute de tip ArrayList
	//reservationList pentru lista cu reservari
	// tableList pentru lista cu mese
	// cele 2 atribute sunt initializate cu liste goale

	ArrayList<Reservation> reservationList = new ArrayList<Reservation>();//aici aplez contructoru pentru ArrayList
	// am pus = new ArrayList<Reservation>() mai sus pentru a crea o lista goala pentru atributul reservationList
	// cu scoul de a putea adauga la aceasta lista elemente
	ArrayList<Table> tableList = new ArrayList<Table>();
	
	public void createReservation(int startTime,String firstName, String LastName,int reservationSize){
		// metoda are scoul de a adauga un obiect de tipul rezervare in atributul de tip list reservationLists
		Random random = new Random();// folosesc variabila random de tip Random pentru a genera un id aleatoriu pentru rezervare
		long reservationID = random.nextLong();
		Client reserver = new Client();
		reserver.firstName = firstName;
		reserver.lastName = LastName;	
		Table reservedTable = null;
		for(int i= 0;i<tableList.size();i++) {
			if (tableList.get(i).numberSeats >= reservationSize) {
				reservedTable = tableList.get(i);
				break;
			}
		}
		Reservation newReservation = new Reservation(reserver,reservationID,startTime,reservationSize,reservedTable);
		reservationList.add(newReservation);
	}
	public void cancelReservation(Reservation reservation){
		reservationList.remove(reservation);
	}
	
	public static void main(String args[]) {
		
		Menu menu = new Menu();
		menu.dishes.add(new Dish("Fish and chips",25));
		menu.dishes.add(new Dish("CHicken soup",10));
		menu.dishes.add(new Dish("Pork steak",45));
		menu.dishes.add(new Dish("Asian chicken",30));
		menu.dishes.add(new Dish("Hamburger",17));
		
		Restaurant restaurant = new Restaurant();
		restaurant.tableList.add(new Table(1,2));
		restaurant.tableList.add(new Table(2,4));
		restaurant.tableList.add(new Table(3,2));
		restaurant.tableList.add(new Table(4,4));
		
		restaurant.createReservation(20, "Marius", "Popescu", 3);
		Bill bill = restaurant.reservationList.get(0).client.createOrder(menu);
		bill.computeTotal(); // variabila.metoda(cu sau fara argumente aici)
		for(int i = 0;i<restaurant.reservationList.size();i++) {
			Reservation r = restaurant.reservationList.get(i);
			Client c = restaurant.reservationList.get(i).client;
			String show = c.lastName +" "+ c.lastName + " Number of people : "+ r.numberOfPeople + " at Table: " + r.table.id + "\n";
			System.out.println(show);
		}
		System.out.println("Order is: \n");
		for(int i = 0;i<bill.dishes.size();i++) {
			Dish d = bill.dishes.get(i);
			System.out.println(d.name + " " + d.price + "\n");
		}
		System.out.println("Total bill is " + bill.total);
		
		
	}
	
}
