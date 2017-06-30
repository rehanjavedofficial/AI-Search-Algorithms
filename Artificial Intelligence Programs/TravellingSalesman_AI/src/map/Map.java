package map;

import java.util.ArrayList;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class Map {

	// Attributes.
	private static ArrayList<City> cities = new ArrayList<>();
	
	/**
	 * Adding city to map at random position.
	 * 
	 * @param city
	 */
	public static void addCity(City city){
		
		cities.add(city);
		
	}
	
	/**
	 * Get position of city at certain position.
	 * 
	 * @param index
	 * @return city.
	 */
	public static City getCity(int index){
		
		return cities.get(index);
	
	}
	
	/**
	 * @return cities list.
	 */
	public static ArrayList<City> getCityList(){
		
		return cities;
		
	}
	
	/**
	 * Find number of cities on map.
	 * 
	 * @return size.
	 */
	public static int size(){
		
		return cities.size();
		
	}
	
	/**
	 * Generating cities in map.
	 * 
	 * @param size
	 */
	public static void generateCities(int size){
		
		for(int i = 0; i < size; i++){
			
			Map.addCity(new City(String.valueOf(i)));
			
		}
		
	}
	
	/**
	 * Printing map.
	 * 
	 * @param mapList
	 */
	public static void print(ArrayList<City> mapList) {
		
		String[][] mapArray = new String[City.X_LIMIT][City.Y_LIMIT];
		City city;
		
		for(int i = 0; i < mapList.size(); i++){
			
			city = mapList.get(i);
			mapArray[city.getX()][city.getY()] = city.getName();
		
		}
		String text = "";
		for(int i = 0; i < mapArray.length; i++){
			for(int j = 0; j < mapArray[0].length; j++)
				text += mapArray[i][j] == null ? " " : mapArray[i][j];
			text += "\n";
		}
		
		System.out.println(text);
		
	}
	
}
