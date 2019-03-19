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
	private ArrayList<Table> tableList = new ArrayList<Table>();
	private Menu menu;
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Restaurant() {
		
	}
	
	public ArrayList<Table> getTableList() {
		return tableList;
	}
	public void setTableList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
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
		this.reservationList.add(newReservation);
	}
	public void cancelReservation(Reservation reservation){
		reservationList.remove(reservation);
	}

	public void createRandomScenario() {
		Random random = new Random();
		// Create random reservations
		for(int i=0;i< random.nextInt(10)+2;i++){
			this.createReservation(random.nextInt(24), Integer.toString(i), "Client ", random.nextInt(4)+1);
		}
		
		// Add random dishes to each reservation
		for(int i=0;i< random.nextInt(10)+2;i++){
			this.createReservation(random.nextInt(24), Integer.toString(i), "Client ", random.nextInt(4)+1);
		}
		// Create random bills
		for(int i = 0;i<this.reservationList.size();i++) {
			Bill random_bill = this.reservationList.get(i).client.createOrder(this.menu);
			random_bill.computeTotal();
			this.reservationList.get(i).bill = random_bill;
			System.out.println(this.reservationList.get(i).toString());
		}
	}
	
}
