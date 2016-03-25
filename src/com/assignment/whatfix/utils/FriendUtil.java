package com.assignment.whatfix.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.whatfix.pojo.GiftDetails;
import com.assignment.whatfix.pojo.GiftPathDetails;

public class FriendUtil {

	public static void formatTheNeed(String strLine) {

		String[] linecontent = strLine.split(" : ");
		float maxweight = Float.parseFloat(linecontent[0]);
		String[] itemdetails = linecontent[1].split(" ");
		int itemsize = itemdetails.length;

		List<GiftDetails> list = new ArrayList<GiftDetails>();

		for (int i = 0; i < itemsize; i++) {

			String[] x = itemdetails[i].replace("(", "").replace(")", "")
					.split(",");
			int id = Integer.parseInt(x[0]);
			float weg = Float.parseFloat(x[1]);
			int pric = Integer.parseInt(x[2].replace("$", ""));
			list.add(new GiftDetails(id, weg, pric));

		}

		int[] id = new int[itemsize];
		float[] weights = new float[itemsize];
		int[] price = new int[itemsize];
		// Sorts the array list using comparator
		Collections.sort(list, new GiftDetails());
		int x = 0;
		for (GiftDetails a : list) {// printing the sorted list of ages
			id[x] = a.getId();
			weights[x] = a.getWeight();
			price[x] = a.getPrice();
			x++;
		}
		findOutTheBest(itemsize, id, weights, price, maxweight);
		

	}

	public static void findOutTheBest(int itemsize, int[] id, float[] weights,
			int[] price, float maxweight) {
	
		System.out.println("");
		HashMap<String, GiftPathDetails> pathlist = new HashMap<String, GiftPathDetails>();
		for (int i = 0; i < itemsize; i++) {
			findSumPaths(i, itemsize, id, weights, price, maxweight, 0.0f, 0,
					"", pathlist);
		}
		
		String p = "";
		float tw = 0.0f;
		int tc = 0;
		String maxcostkey = "";
		int c = 0;
		for (Map.Entry<String, GiftPathDetails> entry : pathlist.entrySet()) {

			GiftPathDetails value = entry.getValue();
			// System.out.println(value.getPath()+" "+value.getTprice()+" "+value.getTweight());

			if (tw < value.getTweight()) {
				tw = value.getTweight();
				tc = value.getTprice();
				p = value.getPath();
			}
			if (c < value.getTprice()) {
				maxcostkey = value.getPath();
				c = value.getTprice();
			}

		}
		if(p.equals("")){
			System.out.println(" -");
		}else{
			if(!p.equals(maxcostkey)) {
				System.out.println(maxcostkey.replaceFirst(",", " "));
			}else {
				System.out.println(p.replaceFirst(",", " "));
			}
		}
	}

	public static void findSumPaths(int starting, int itemsize, int[] id,
			float[] weights, int[] price, float maxweight, float sumw,
			int sumc, String path, HashMap<String, GiftPathDetails> pathlist) {

		for (int i = starting; i < itemsize; i++) {
			sumw += weights[i];
			sumc += price[i];
			if (sumw <= maxweight) {
				path = path + "," + Integer.toString(id[i]);
				GiftPathDetails gpd = new GiftPathDetails(sumw, sumc, path);
				pathlist.put(path, gpd);
				findSumPaths(++i, itemsize, id, weights, price, maxweight,
						sumw, sumc, path, pathlist);
			}
		}

	}

}
