package map;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class City {

	// Attributes
	private String name;
	private int x, y;
	public static final int X_LIMIT = 20, Y_LIMIT = 20;

	/**
	 * Constructor.
	 * 
	 * @param name
	 */
	public City(String name) {
		
		this.name = name;
		this.x = (int) (Math.random() * X_LIMIT);
		this.y = (int) (Math.random() * Y_LIMIT);
	
	}

	/*
	 * Getters.
	 */
	
	public int getX() {
		
		return x;
		
	}

	public int getY() {
	
		return y;
	
	}

	public String getName() {
	
		return name;
	
	}

	/**
	 * To find distance between 2 cities
	 * in x and y axis using
	 * Pythagorean theorem .
	 * 
	 * @param city
	 * @return distance.
	 */
	public double getDistance(City city){
		
		double x = Math.pow(Math.abs(city.x - this.x), 2);
		double y = Math.pow(Math.abs(city.y - this.y), 2);
		
		return Math.sqrt(x + y);
		
	}
	
	/**
	 * @return object details.
	 */
	@Override
	public String toString(){
		
		return name;
		
	}
	
}
