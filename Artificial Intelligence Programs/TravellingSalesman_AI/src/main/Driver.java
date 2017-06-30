package main;

import algorithm.StealingAnnealing;
import map.Map;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class Driver {

	/**
	 * Main method to run the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		Map.generateCities(10);
		StealingAnnealing stealingAnnealing = new StealingAnnealing();
		stealingAnnealing.findBestRoute();
		
	}
	
}
