package model;


public class Table {
     int id; 
     int numberSeats; 

    //Am definit constructorul acesta pentru a usura crearea unui obiectului cu atributele dorite
     //Astfel nu mai e nevoie ca dupa ce creez un obiect de tipul Table sa ii modific atributele
    public Table(int id, int numSeats) { 
        this.id = id;
        this.numberSeats = numSeats; 
    }
    // Talbe t = new Table()      - >    Table t = new Table(6,7);
    // t.id = 6;
    // t.numberSeats = 7;
}
