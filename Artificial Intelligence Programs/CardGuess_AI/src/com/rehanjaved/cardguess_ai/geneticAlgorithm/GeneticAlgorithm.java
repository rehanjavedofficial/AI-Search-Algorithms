package com.rehanjaved.cardguess_ai.geneticAlgorithm;

import java.util.Random;

/**
 * @author Rehan Javed
 * @company RJ APPS
 * @version 1.0.1
 * @date 10 May 2017
 * 
 * It contains methods related to
 * genetic algorithm which are
 * used in it.
 * 
 */
public class GeneticAlgorithm {

	// Attributes.
	private Random random;

	/**
	 * Constructor.
	 */
	public GeneticAlgorithm(){
		
		random = new Random();
	
	}
	
	/**
	 * Update the population by
	 * crossover and mutate the
	 * population.
	 * 
	 * @param population
	 * @return
	 */
	public Population updatePopulation(Population population){
		
		Population newPopulation = new Population(population.size());
		
		//Crossovers..
		for(int i = 0; i < population.size(); i++){
			
			Chromosome first = randomSubPopulationSelection(population);
			Chromosome second = randomSubPopulationSelection(population);
			newPopulation.setChromosome(i, CrossOver(first, second));
			
		}
		
		// Mutation...
		for(int i = 0; i < population.size(); i++)
			Mutate(population.getChromosome(i));
		
		return newPopulation;
		
	}
	
	/**
	 * Cross over the two chromosomes.
	 * 
	 * @param first
	 * @param second
	 * @return new generated chromosome.
	 */
	public Chromosome CrossOver(Chromosome first, Chromosome second){
		
		Chromosome individual = new Chromosome();
		
		for(int i = 0; i < Values.CROMOSOME_LENGTH; i++)
			if(Math.random() <= Values.CROSSOVER_RATE)
				individual.setGeneAt(i, first.getGeneAt(i));
			else
				individual.setGeneAt(i, second.getGeneAt(i));
		
		return individual;
		
	}
	
	/**
	 * Mutate the chromosomes in the populations.
	 * 
	 * @param individual
	 */
	public void Mutate(Chromosome individual){
		
		for(int i = 0; i < Values.CROMOSOME_LENGTH; i++)
			if(Math.random() <= Values.MUTATION_RATE)
				individual.setGeneAt(i, 2 + random.nextInt(9));
	}
	
	/**
	 * Generate random sub population and
	 * select healthy chromosome in it.
	 * 
	 * @param population
	 * @return chromosome.
	 */
	public Chromosome randomSubPopulationSelection(Population population){
		
		Population subP = new Population(Values.SUB_POPULATION_SIZE);
		
		for(int i = 0; i < subP.size(); i++){
			subP.setChromosome(i, population.getChromosome(random.nextInt(population.size())));
		}
		
		return subP.getHealthyChromosome();
		
	}
	
}
