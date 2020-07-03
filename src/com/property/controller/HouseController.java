package com.property.controller;

import java.util.ArrayList;
import java.util.List;

import com.property.model.House;

public class HouseController {
	
	private static List<House> houseList = new ArrayList<House>();
	
	public List<House> getHouses() {
		return houseList;
	}
	
	public House getHouse(int id) {
		for(House h: houseList) {
			if(h.getId() == id) {
				return h;
			}
		}
		return null;
	}
	
	public boolean createHouse(House house) {
		if(houseList.add(house)) {
			return true;
		}
		return false;
	}
	
	public boolean updateHouse(int id, House house) {
		for(House h: houseList) {
			if(h.getId() == id) {
				int i = houseList.indexOf(h);
				house.setId(id);
				houseList.set(i, house);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteHouse(int id)
	{
		for(House h : houseList) {
			if(h.getId() == id) {
				houseList.remove(h);
				return true;
			}
		}
		return false;
	}
}
