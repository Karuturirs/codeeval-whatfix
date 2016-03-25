package com.assignment.whatfix.pojo;

public class GiftPathDetails {
	private float Tweight;
	private int Tprice;
	private String Path;
	public GiftPathDetails(float sum, int cost, String path2) {
		// TODO Auto-generated constructor stub
		Tweight=sum;
		Tprice= cost;
		Path=path2;
	}
	public float getTweight() {
		return Tweight;
	}
	public void setTweight(float tweight) {
		Tweight = tweight;
	}
	public int getTprice() {
		return Tprice;
	}
	public void setTprice(int tprice) {
		Tprice = tprice;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	
}
