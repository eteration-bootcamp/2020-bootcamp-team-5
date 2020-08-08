package com.design.prototype;

import java.util.List;
import java.util.ArrayList;


public class Colors implements Cloneable {

	private List<String> colorsList;
	
	public Colors() {
		colorsList = new ArrayList<String>();
    }
    
	public Colors(List<String> listParam){
		this.colorsList = listParam;
    }
    	
	public List<String> getColorsList() {
		return this.colorsList;
    }
    
    public void constructColorsList() {
        colorsList.add("Red");
        colorsList.add("Green");
        colorsList.add("Blue");
    }

	@Override
	public Object clone() throws CloneNotSupportedException {

        List<String> newList = new ArrayList<String>();

        for(String color: this.getColorsList()){
            newList.add(color);
        }

        return new Colors(newList);
	}
	
}