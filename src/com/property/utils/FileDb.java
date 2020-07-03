package com.property.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.property.controller.BranchController;
import com.property.controller.FlatController;
import com.property.controller.HouseController;
import com.property.model.Branch;
import com.property.model.Flat;
import com.property.model.House;
import com.property.model.Property;

public class FileDb {
	
	private BranchController bc;
	private HouseController hc;
	private FlatController fc;

	public void loadBranchFromFile() {
		bc = new BranchController();
		Branch branch;
		
	    String fileToParse = "C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\branches.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String name = tokens[1];
	              String phoneNo = tokens[2];
	              String address = tokens[3];
	              String email = tokens[4];
	              String webAddress = tokens[5];
	              String username = tokens[6];
	              String password = tokens[7];
	              
	              branch = new Branch(id, name, phoneNo, address, email, webAddress, username, password);
	              bc.createBranch(branch);
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void saveBranchToFile() {
		bc = new BranchController();
		  
	    BufferedWriter buffer = null;
	    try {
	    	FileWriter writer = new FileWriter("C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\branches.csv");
	    	
	    	buffer = new BufferedWriter(writer);
	    	for(Branch b : bc.getBranches()) {
	    		buffer.write(b.toString());
	    		buffer.write("\n");
	    	}
	    } catch (Exception e)  {
	    	e.printStackTrace();
	    } finally {
	    	{
	    		try {
	    			buffer.close();
	    		} catch(IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	}
	
	public void loadHouseFromFile() {
		
		hc = new HouseController();
		House house;
		
		String fileToParse = "C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\houses.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String address = tokens[1];
	              int noOfRooms = Integer.parseInt(tokens[2]);
	              double sellingPrice = Double.parseDouble(tokens[3]);
	              double soldPrice = Double.parseDouble(tokens[4]);
	              int branchId = Integer.parseInt(tokens[5]);
	              int noOfFloors = Integer.parseInt(tokens[6]);
	              boolean hasGarden = tokens[7] == "True" ? true : false;
	              boolean hasGarage = tokens[8] == "True" ? true : false;
	              
	              house = new House(id, address, noOfRooms, sellingPrice, soldPrice, branchId, noOfFloors, hasGarden, hasGarage);
	              hc.createHouse(house);
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void saveHouseToFile() {
		hc = new HouseController();
		
	    BufferedWriter buffer = null;
	    try {
	    	FileWriter writer = new FileWriter("C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\houses.csv");
	    	
	    	buffer = new BufferedWriter(writer);
	    	for(House h : hc.getHouses()) {
	    		if(hc.getHouses() == null) {
	    			break;
	    		}
	    		buffer.write(h.toString());
	    		buffer.write("\n");
	    	}
	    } catch (Exception e)  {
	    	e.printStackTrace();
	    } finally {
	    	{
	    		try {
	    			buffer.close();
	    		} catch(IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	}
	
public void loadFlatFromFile() {
		
		fc = new FlatController();
		Flat flat;
		
		String fileToParse = "C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\flats.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int id = Integer.parseInt(tokens[0]);
	              String address = tokens[1];
	              int noOfRooms = Integer.parseInt(tokens[2]);
	              double sellingPrice = Double.parseDouble(tokens[3]);
	              double soldPrice = Double.parseDouble(tokens[4]);
	              int branchId = Integer.parseInt(tokens[5]);
	              int floorNo = Integer.parseInt(tokens[6]);
	              int monthlyCharge = Integer.parseInt(tokens[7]);
	              
	              flat = new Flat(id, address, noOfRooms, sellingPrice, soldPrice, branchId, floorNo, monthlyCharge);
	              fc.createFlat(flat);
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	

	public void saveFlatToFile() {
		fc = new FlatController();
		BufferedWriter b = null;
		try {
			FileWriter w = new FileWriter("C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\flats.csv");
    	
			b = new BufferedWriter(w);
			for(Flat f : fc.getFlats()) {
				if(fc.getFlats() == null) {
	    			break;
	    		}
				b.write(f.toString());
				b.write("\n");
			}
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
    
	}
	
	public void loadIdFromFile() {
		
	    String fileToParse = "C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\ids.csv";
	    BufferedReader fileReader = null;
	       
	      final String DELIMITER = ",";
	      try
	      {
	          String line = "";
	          fileReader = new BufferedReader(new FileReader(fileToParse));
	           
	          while ((line = fileReader.readLine()) != null) 
	          {
	              String[] tokens = line.split(DELIMITER);
	              int branchCount = Integer.parseInt(tokens[0]);
	              int propertyCount = Integer.parseInt(tokens[1]);
	              Branch branch = new Branch();
	              branch.setCount(branchCount);
	              Property property = new Property();
	              property.setCount(propertyCount);
	          }
	      } 
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	      finally
	      {
	          try {
	              fileReader.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	}
	
	public void saveIdToFile() {
		BufferedWriter b = null;
		try {
			FileWriter w = new FileWriter("C:\\Users\\ayush\\eclipse-workspace\\PropertySalesSystem\\src\\com\\property\\resource\\ids.csv");
    	
			b = new BufferedWriter(w);
				b.write(((Integer) new Branch().getCount()).toString() + "," + ((Integer) new Property().getCount()).toString());
				b.write("\n");
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
		

