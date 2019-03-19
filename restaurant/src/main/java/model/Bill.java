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

	@Override
	public String toString() {
		String dishes_str = "";
		for(int i=0;i<this.dishes.size();i++) {
			Dish my_dish = this.dishes.get(i);
			dishes_str +="	"+ my_dish.toString()+ "\n";
		}
		return "Bill[dishes=\n" + dishes_str + ", total=" + total + "]";
	}
	
}
