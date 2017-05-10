package com.rehanjaved.cardguess_ai.geneticAlgorithm;

/**
 * @author Rehan Javed
 * @company RJ APPS
 * @version 1.0.1
 * @date 10 May 2017
 * 
 * Represents a population
 * which contains chromosomes
 * in it.
 * 
 */
public class Population {

	// attributes
	private Chromosome[] chromosomes;
	
	/**
	 * Initializing the population.
	 * 
	 * @param size
	 */
	public Population(int size){
		
		chromosomes = new Chromosome[size];
		
		for(int i = 0; i < size; i++)	
			chromosomes[i] = new Chromosome();
		
		
	}
	
	/**
	 * Get chromosome at the given
	 * index.
	 * 
	 * @param index
	 * @return chromosome.
	 */
	public Chromosome getChromosome(int index){
	
		return chromosomes[index];
	
	}
	
	/**
	 * Set chromosome at the given index.
	 * 
	 * @param index
	 * @param chromosome
	 */
	public void setChromosome(int index, Chromosome chromosome){
	
		this.chromosomes[index] = chromosome;
	
	}
	
	/**
	 * @return length of population.
	 */
	public int size(){
		
		return chromosomes.length;
	
	}
	
	/**
	 * Find the healthy chromosome.
	 * 
	 * @return chromosome.
	 */
	public Chromosome getHealthyChromosome(){
		
		Chromosome healthy = chromosomes[0];
		
		double distance = Math.abs(Values.MAX_FITNESS_POINTS - chromosomes[0].getFitness());
		double currentDistance;
		for(int i = 0; i < chromosomes.length; i++){
			
			currentDistance = Math.abs(Values.MAX_FITNESS_POINTS - chromosomes[i].getFitness());
			if(distance > currentDistance){
				distance = currentDistance;
				healthy = chromosomes[i];
			}
			
		}
		
		return healthy;
		
	}
	
}
