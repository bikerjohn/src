package page_objects;

public class Time_Wait {
	Integer wTime = 2000;
	public Time_Wait(){
		
	}
	public void Duration(Integer mSeconds){
		this.wTime=mSeconds;
		try {
    		Thread.sleep(wTime); 
    	}
    	catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
    	}
	}
}
