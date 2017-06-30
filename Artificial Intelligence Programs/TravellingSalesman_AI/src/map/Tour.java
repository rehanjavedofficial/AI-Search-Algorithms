package map;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class Tour {

	// Attributes
	private ArrayList<City> tour;
	private double tourDistance = 0;
	
	/**
	 * Default Constructor.
	 */
	public Tour(){
		
		this(Map.getCityList());
		Collections.shuffle(tour);
		
	}
	
	/**
	 * Creating tour with given list.
	 * 
	 * @param list
	 */
	public Tour(ArrayList<City> list){
		
		tour = new ArrayList<City>();
		for(int i = 0; i < list.size(); i++)
			tour.add(list.get(i));
		
	}
	
	/**
	 * @return tour.
	 */
	public ArrayList<City> getTour(){
		
		return tour;
		
	}
	
	/**
	 * City at specific position.
	 * 
	 * @param index
	 * @return city.
	 */
	public City getCity(int index){
		
		return tour.get(index);
		
	}
	
	/**
	 * Setting city at specific index.
	 * 
	 * @param index
	 * @param city
	 */
	public void setCity(int index, City city){
		
		tour.set(index, city);
		
	}
	
	/**
	 * @return number of cities.
	 */
	public int size(){
		
		return tour.size();
		
	}
	
	/**
	 * Finding complete distance of 
	 * that tour.
	 * 
	 * @return total distance.
	 */
	public double getDistance(){
		
		if(tourDistance == 0){
			
			for(int i = 0; i < tour.size(); i++){
				
				if((i+1) == tour.size())
					tourDistance += tour.get(i).getDistance(tour.get(0));
				else
					tourDistance += tour.get(i).getDistance(tour.get(i+1));
				
			}
			
		}
		
		return tourDistance;
		
	}
	
	/**
	 * Printing tour.
	 */
	@Override
	public String toString(){
		
		String text = "";
		
		for(int i = 0; i < tour.size(); i++)
			text += tour.get(i)+" =>> ";
		
		return text;
		
	}
	
}
