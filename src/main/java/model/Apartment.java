package model;

public class Apartment {
	
	public String price;
	public String address;
	
	@Override
	public String toString(){
		return "Address: " + this.address + " Price: " + this.price;
	}
	
}
