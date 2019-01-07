package model;

public class Reservation {

	Client client;
	long reservationId;
	int startTime;
	int numberOfPeople;
	Table table;
	
	Reservation(Client c, long r, int st, int nop,Table table){
		this.client = c;
		this.startTime = st;
		this.numberOfPeople = nop;
		this.reservationId = r;
		this.table = table;
	}
}
