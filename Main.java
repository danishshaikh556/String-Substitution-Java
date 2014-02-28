//Sample code to read in test cases:
//Sample code to read in test cases:
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
	 private static void stringSubstitute(String word, String[] check,
			String[] replace) {
		 
		 
		 int indexOfCheck =0;
		
		 while(indexOfCheck< check.length)
		 {
			int currPos =0;
					
			 while(currPos<word.length())
			 {
			    int b     =  word.indexOf(check[indexOfCheck],currPos);
			
			    if(b != -1)
			    {
			    	//Check if index was previously changed
			    	if(indexNotChanged(b,check[indexOfCheck].length()))
			    		{
			    			word = word.substring(0,b)+replace[indexOfCheck]+word.substring(b + replace[indexOfCheck].length());
			    			break;
					 
			    		}
			    	currPos++;
				 
			    } else break;
			 }
			 	indexOfCheck ++;
		 }
		
		word.replaceAll(" ", "");
		visited.clear();
		System.out.println(word);
	}
	 
	
	 //Check if index was previously chaged
	    private static boolean indexNotChanged(int strtIndex, int nextInts)
	    {
	    	int i          = 0;
	    	int strt1Index = strtIndex;
		  
	    	while(i<nextInts)
	    		{
	    			if(visited.containsKey(strt1Index)) return false;
	    				strt1Index++;
	    				i++;
	    		}
		  
	    			i=0;
	      while(i<nextInts)
	      		{
	    	  		visited.put(strtIndex,strtIndex);
	    	  		strtIndex++;
	    	  		i++;
	      		}
	    	
	      		return true;
	    }



		public static void main (String[] args) throws Exception {
	   
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	         		 String[] a       = line.split("\\;") ;
	        		 String[] b       = a[1].split("\\,");
	        		 String word      = a[0];
	        		 String[] check   = new String[b.length/2];
	        		 String[] replace = new String[b.length/2];
	        		 int j =0;
	        		 for(int i = 0;i<check.length;i++)
	        		 {
	        			 check[i]   =  b[j];
	        			 replace[i] =  b[j+1];
	        			
	        			 j =j+2;
	        		 }
	        		 
	        		 //Insert hashes # for proper replacement
	        		 for(int i = 0;i<check.length;i++)
	        		 {
	        			 if(replace[i].length()<check[i].length())
	        			 {
	        				 while(replace[i].length()<check[i].length())
	        				 {
	        					 replace[i]=replace[i]+" ";
	        					 
	        				 }
	        			 }
	        			
	        		 }
	        			 
	        		 
	        		 stringSubstitute(word,check,replace);
	        		 
	        }
	    }

		private static  HashMap<Integer,Integer> visited =new HashMap<Integer,Integer>();
	  }
	

