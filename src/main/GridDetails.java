package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class GridDetails {

	//Variables defined
	   Set pacdirectionset;
	   List gridList = new ArrayList();
	   String [] gridListtemp ;
	   String [] gridListsettemp ;
	   String [] gridListsettemp1 ;
	   String pacdirection;
	   String defaultvalue;
	   String value;
	   int pos1;
	   int pos2;
	   int breaktemp =0;
	   int k =0;
	   int pacpositionx;
	   int pacpositiony;
	   int monsterpositionx;
	   int monsterpositiony;
	   int min;
	   int max;
	   int pacvalue;
	   int monstervalue;
	   int points;
       int valueInt;
       int Totalpoints =0;
	 
    //Getter and setter method for variables 
	   public void setgridList(List gridList) {
		      this.gridList = gridList;
		   }
		  
		   public List getgridList() {
			  System.out.println("New GRID value:" + gridList); 
		      return gridList;
		   }
		   public void setgridListsettemp(String[] gridListsettemp) {
			      this.gridListsettemp = gridListsettemp;
			   }
			  
			   public String [] getgridListsettemp() {
			      return gridListsettemp;
			   }    
	 //Method that will return the specific element of List provided element position/co-ordinates		   
	   public String getGridSpecificValue(List gridList, int pos1, int pos2){
			   gridListtemp = gridList.get(pos1).toString().split(",");
		   return gridListtemp[pos2];
	   }
        
		public void setpacdirectionset(Set pacdirectionset) {
		      this.pacdirectionset = pacdirectionset;
		   }

		
		public Set getpacdirectionset() {
		  	      return pacdirectionset;
		   }
		
		public void setpacdirection(String pacdirection) {
		      this.pacdirection = pacdirection;
		   }

		public String getpacdirection() {
		      return pacdirection;
		   }
		public void setdefaultvalue(String defaultvalue) {
		      this.defaultvalue = defaultvalue;
		   }

		public String getdefaultvalue() {
		      return defaultvalue;
		   }
		
		public void setpacpositionx(int pacpositionx) {
		      this.pacpositionx = pacpositionx;
		   }

		public int getpacpositionx() {
		      return pacpositionx;
		   }	
		
		public void setpacpositiony(int pacpositiony) {
		      this.pacpositiony = pacpositiony;
		   }

		public int getpacpositiony() {
		      return pacpositiony;
		 }   	
		public void setmonsterpositionx(int monsterpositionx) {
		      this.monsterpositionx = monsterpositionx;
		   }

		public int getmonsterpositionx() {
		      return monsterpositionx;
		   }	
		
		public void setmonsterpositiony(int monsterpositiony) {
		      this.monsterpositiony = monsterpositiony;
		   }

		public int monsterpacpositiony() {
		      return monsterpositiony;
		 }	
		public void setmin(int min) {
		      this.min = min;
		   }
		public int getmin() {
		      return min;
		 }
		public void setmax(int max) {
		      this.max = max;
		   }
		public int getmax() {
		      return max;
		 }	
		public void setpacvalue(int pacvalue) {
		      this.pacvalue = pacvalue;
		   }
		public int getpacvalue() {
		      return pacvalue;
		 }
		public void setmonstervalue(int monstervalue) {
		      this.monstervalue = monstervalue;
		   }
		public int getmonstervalue() {
		      return monstervalue;
		 }	
		public void setpoints(int points) {
		      this.points = points;
		   }
		public int getpoints() {
		      return points;
		 }
		
	//Method that will verify of the PacMan position is worth moving ahead or not
	//If yes the new values with the position and points will be updated
		public void PacPosition(){
			 
			if(((pacdirection.equals("DOWN")) && !(pacpositionx == max ))  ||
				 ((pacdirection.equals("UP")) && !(pacpositionx == min)) ||
				  ((pacdirection.equals("RIGHT")) && !(pacpositiony == max)) ||
				  ((pacdirection.equals("LEFT")) && !(pacpositiony == min))){
				k=0;
			    UpdateGrid();	
			    checkTotalpoints();
			    getgridList();
	    
			}else{
				System.out.println("WALL ahead!! Please change the direction of the PACMAN");		
			}
		}
		
	//Method based on Direction will check the PACMAN value via List and then
    //update List with new value of PACMAN and Totalpoints for future reference
		public void UpdateGrid(){	
			if(pacdirection.equals("DOWN")){
				  for (int i = 0; i < gridList.size(); i++){
					  for (int j = 0; j < gridList.size(); j++){
					     value = getGridSpecificValue(gridList,i,j);
					     valueInt = Integer.parseInt(value);
					    if(valueInt == pacvalue ){	
					    	gridListsettemp = gridList.get(i).toString().split(",");
					     	gridListsettemp[j] =defaultvalue;
					    	String joined = String.join(",", gridListsettemp);
					    	gridList.set(i,joined);
					    	gridListsettemp1 = gridList.get(i+1).toString().split(",");
					    	gridListsettemp1[j] = value;
					    	String joined1 = String.join(",", gridListsettemp1);
					    	gridList.set(i+1,joined1);
					    	Totalpoints = + points;
					    	k=1;
					    	break;
					     }
					  }
					  if(k == 1 )break;
				   }
			}
			else if(pacdirection.equals("UP")){
				for (int i = 0; i < gridList.size(); i++){
					  for (int j = 0; j < gridList.size(); j++){
					     value = getGridSpecificValue(gridList,i,j);
					     valueInt = Integer.parseInt(value);
					    if(valueInt == pacvalue ){	
					    	gridListsettemp = gridList.get(i).toString().split(",");
					     	gridListsettemp[j] =defaultvalue;
					    	String joined = String.join(",", gridListsettemp);
					    	gridList.set(i,joined);
					    	gridListsettemp1 = gridList.get(i-1).toString().split(",");
					    	gridListsettemp1[j] = value;
					    	String joined1 = String.join(",", gridListsettemp1);
					    	gridList.set(i-1,joined1);
					    	Totalpoints = + points;
					    	k=1;
					    	break;
					     }
					  }
					  if(k == 1 )break;
				   }
			}else if(pacdirection.equals("RIGHT")){
				for (int i = 0; i < gridList.size(); i++){
					  for (int j = 0; j < gridList.size(); j++){
						     value = getGridSpecificValue(gridList,i,j);
						     valueInt = Integer.parseInt(value);
						    if(valueInt == pacvalue ){	
						    	gridListsettemp = gridList.get(i).toString().split(",");
						     	gridListsettemp[j] =defaultvalue;
						     	gridListsettemp[j+1] =value;
						     	String joined1 = String.join(",", gridListsettemp);
						    	gridList.set(i,joined1);
						    	Totalpoints = + points;
						    	k=1;
						    	break;	
						    }						  
					  }
					  if(k == 1 )break;
				}
			}
			else if(pacdirection.equals("LEFT")){
				for (int i = 0; i < gridList.size(); i++){
					  for (int j = 0; j < gridList.size(); j++){
						     value = getGridSpecificValue(gridList,i,j);
						     valueInt = Integer.parseInt(value);
						    if(valueInt == pacvalue ){	
						    	gridListsettemp = gridList.get(i).toString().split(",");
						     	gridListsettemp[j] =defaultvalue;
						     	gridListsettemp[j-1] =value;
						     	String joined1 = String.join(",", gridListsettemp);
						    	gridList.set(i,joined1);
						    	Totalpoints = + points;
						    	k=1;
						    	break;	
						    }						  
					  }
					  if(k == 1 )break;
				}
			}
		}
		
	 //Method will return LEVEL complete details	
		public void checkTotalpoints(){
			if(Totalpoints == 70){
				System.out.println("LEVEL completed");
			}			
		}		
}
