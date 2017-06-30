package algorithm;

import map.City;
import map.Map;
import map.Tour;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class StealingAnnealing {

	// Attributes.
	private Tour best, current;
	private double temperature = 10000, coolingRate = 0.03;
	
	/**
	 * Finding best route to visit
	 * all cities in map.
	 */
	public void findBestRoute(){
		
		int index1, index2;
		City city1, city2;
		current = new Tour();
		
		System.out.println("Starting from: "+current.getDistance()+", "+current.toString());
		Map.print(current.getTour());
		
		best = new Tour(current.getTour());
		
		while(temperature > 1){
			
			Tour newSolution = new Tour(current.getTour());
			
			index1 = (int) (Math.random() * newSolution.size());
			index2 = (int) (Math.random() * newSolution.size());
			city1 = newSolution.getCity(index1);
			city2 = newSolution.getCity(index2);
			
			newSolution.setCity(index1, city2);
			newSolution.setCity(index2, city1);
			
			if(checkProbability(newSolution.getDistance(), current.getDistance()) > Math.random())
				current = new Tour(newSolution.getTour());
			
			if(best.getDistance() > current.getDistance())
				best = new Tour(current.getTour());
			
			temperature *= 1 - coolingRate;
			
		}
		
		System.out.println("End at: "+best.getDistance()+", "+best.toString());
		
	}

	/**
	 * Finding probability of accepting
	 * the new answer.
	 * 
	 * @param newEnergy
	 * @param energy
	 * @return probability.
	 */
	public double checkProbability(double newEnergy, double energy){
		
		if(newEnergy < energy)
			return 1;
		
		return Math.exp((energy - newEnergy)/temperature);
		
	}
	
}
