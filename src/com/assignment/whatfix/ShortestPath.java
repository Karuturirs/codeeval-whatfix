package com.assignment.whatfix;

import java.util.Arrays;

public class ShortestPath
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(findShortestPath(new String[][]{
        		{"A", "B", "100"},{"B", "C", "500"},{"A", "D", "200"},{"D", "E", "200"},{"E", "C", "100"}}, "A", "C")));
    }
    
    public static String[] findShortestPath(String[][] distances, String src, String dest)
    {
    	
    	
    	int row = distances.length;
    	  int col = distances[0].length;
    	//for(int i=0;i<row;i++){
    	  
    		for(int i=0,j=0;j<col;j++){
    		  if(src.equals(distances[i][j])){
    			  System.out.println(distances[i][j]);
    			  if(dest.equals(distances[i][j++])){
    				  
    			  }
    		  }
    		}
    	//}
    	
    	
    	
		return null;
        
    }
    
}



