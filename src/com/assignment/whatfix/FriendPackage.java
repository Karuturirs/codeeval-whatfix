package com.assignment.whatfix;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import com.assignment.whatfix.utils.FriendUtil;

public class FriendPackage {

	public static void main(String[] args) {
		
		//Scanner in = new Scanner(System.in);
		//String filepath = in.next();
		String filepath = "out/packagelist.txt"; 
		FileInputStream fstream = null;
		BufferedReader br = null;
		try {
			fstream = new FileInputStream(filepath);
			br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				FriendUtil.formatTheNeed(strLine);
			}
			// Close the input stream
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
