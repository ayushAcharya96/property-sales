package com.property.controller;

import java.util.ArrayList;
import java.util.List;

import com.property.model.Flat;

public class FlatController {
	
	private static List<Flat> flatList = new ArrayList<Flat>();
	
	public Flat getFlat(int id) {
		for(Flat f: flatList) {
			if(f.getId() == id) {
				return f;
			}
		}
		return null;
	}
	
	public List<Flat> getFlats() {
		return flatList;
	}
	
	public boolean createFlat(Flat flat) {
		if(flatList.add(flat)) {
			return true;
		}
		return false;
	}
	
	public boolean updateFlat(int id, Flat flat) {
		for(Flat f: flatList) {
			if(f.getId() == id) {
				int i = flatList.indexOf(f);
				flat.setId(id);
				flatList.set(i, flat);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteFlat(int id) {
		for(Flat f: flatList) {
			if (f.getId() == id) {
				flatList.remove(f);
				return true;
			}
		}
		return false;
	}
}
