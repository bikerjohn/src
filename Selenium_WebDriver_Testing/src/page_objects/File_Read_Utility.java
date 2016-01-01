package page_objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File_Read_Utility {
	   public static void main(String[] args) throws Exception {
	      
	      String  thisLine = null;
	      List<String> split_list = new ArrayList<String>();
	      int maxlenth;
	      String object_type, card_type, title, description;
	      object_type="section";
	      try{
	         // open input stream test.txt for reading purpose.
	         BufferedReader br = new BufferedReader(new FileReader("C:/srv/mei/data/Survey_Data.txt"));
	         while ((thisLine = br.readLine()) != null) {
	            //System.out.println(thisLine);
	        	//split each line using "," as an element delimeter and assign them to array elements
	            split_list = Arrays.asList(thisLine.split(","));
	            System.out.println(split_list.get(1));
	            maxlenth = split_list.size();
	            System.out.println(maxlenth);
	            System.out.println(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
	            //determine how many elements there are, and assign them to test case variables
	            for(int i=1; i==maxlenth; i++){
	            	if (i==1) object_type = split_list.get(i);
	            	if (i==2) card_type = split_list.get(i);
	            	if (i==3) title = split_list.get(i);
	            	if (i==4) description = split_list.get(i);
	            	//determine if we are creating a section or a card
	            	if (object_type == "section"){
	            		//if we are processing a section, access the correct locators and actions to
	            		//create a new Section for this survey
	            		//int pid = Integer.parseInt(new File("/proc/self").getCanonicalFile().getName());
	            		//System.out.println("process id = " + pid);
	            	}
	            	else {
	            		//add a new survey card type to the survey -- start by determining what type
	            		//of card we have (for now we only have yesno)
	            		
	            	}
	            }
	         } 
	      }catch(IOException e){
	         e.printStackTrace();
	      }
	   }
	}

