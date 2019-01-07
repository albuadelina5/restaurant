package model;

import java.util.ArrayList;

public class Bill {
	
	ArrayList<Dish> dishes = new ArrayList<Dish>(); // lista cu Dish-urile comandate
	int total; // Suma totala de plata
	
	Bill(ArrayList<Dish> dishes){
		this.dishes = dishes;
	}
	
	//metoda computeToal care nu returneaza nimic (void) si care nu are nici un parametru ()
	public void computeTotal() {//metoda computeTotal schimba valoarea atributului clasei Bill dar nu returneaza nimic
		this.total = 0;
		for(int i= 0;i<dishes.size();i++) {
			this.total += dishes.get(i).price;
		}
	}
}
