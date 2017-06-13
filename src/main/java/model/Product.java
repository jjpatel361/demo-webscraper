package model;

public class Product {

	public String name;
	public String price;
	
	@Override
	public String toString(){
		return this.name + " - " + this.price;
	}
}
