package com.assignment.whatfix.pojo;

import java.util.Comparator;

public class GiftDetails implements Comparator<GiftDetails> {
	private int id;
	private float weight;
	private int price;
	
	public GiftDetails(){
	}

	public GiftDetails(int n, float a,int b){
		id = n;
		weight = a;
		price = b;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	   // Overriding the compare method to sort the weight 
	   public int compare(GiftDetails d, GiftDetails d1){
	      return (int)(d.weight - d1.weight);
	   }
	

}
