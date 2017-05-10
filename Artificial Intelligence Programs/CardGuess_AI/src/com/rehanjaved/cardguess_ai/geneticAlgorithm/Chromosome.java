package com.rehanjaved.cardguess_ai.geneticAlgorithm;

import java.util.Random;

/**
 * @author Rehan Javed
 * @company RJ APPS
 * @version 1.0.1
 * @date 10 May 2017
 * 
 * Represents a single chromosome in
 * the population contains its
 * genes information.
 * 
 */
public class Chromosome {

	// attributes..
	private int[] genes;
	private double fitness = 0;
	private Random random;
	
	/**
	 * Constructor.
	 */
	public Chromosome(){
		
		genes = new int[Values.CROMOSOME_LENGTH];
		
		random = new Random();
		// Generating from 2 - 10
		for(int i = 0; i < genes.length; i++)
			genes[i] = 2 + random.nextInt(9);
		
	}
	
	/**
	 * @return genes.
	 */
	public int[] getGenes(){
		
		return genes;
	
	}
	
	/**
	 * Algorithm to find the fitness
	 * of the chromosome in the
	 * population.
	 * 
	 * @Algorithm
	 * I divide the distance 
	 * from upper most or 
	 * lower most value to the 
	 * given TOTAL_SUM or
	 * TOTAL_PRODUCT and divide it
	 * by 1000 points, and assigns
	 * the points to the fitness 
	 * accordingly.
	 * 
	 * @return fitness
	 */
	public double getFitness(){
		
		if(fitness == 0){
			double sum = 0, mul = 1;
			for(int i = 0; i < genes.length; i++){
				sum += genes[i];
				mul *= genes[i];
			}
			
			if(sum == Values.TOTAL_SUM)
				fitness += 1000;
			else if(sum < Values.TOTAL_SUM){
				double criteria = Values.TOTAL_SUM / 1000;
				for(int i = 1; i <= 1000; i++){
					if(sum < criteria * i){
						fitness += i;
						break;
					}
				}
			}else if(sum > Values.TOTAL_SUM){
				double criteria = ((10 * Values.CROMOSOME_LENGTH) - Values.TOTAL_SUM)/1000;
				sum -= Values.TOTAL_SUM;
				for(int i = 1; i <= 1000; i++){
					if(sum < criteria * i){
						fitness += i;
						break;
					}
				}
			}
			
			if(mul == Values.TOTAL_PRODUCT)
				fitness += 1000;
			else if(mul < Values.TOTAL_PRODUCT){
				double criteria = Values.TOTAL_PRODUCT / 1000;
				for(int i = 1; i <= 1000; i++){
					if(mul < criteria * i){
						fitness += i;
						break;
					}
				}
			}else if(sum > Values.TOTAL_PRODUCT){
				double criteria = ((Math.pow(10, Values.CROMOSOME_LENGTH)) - Values.TOTAL_PRODUCT)/1000;
				mul -= Values.TOTAL_PRODUCT;
				for(int i = 1; i <= 1000; i++){
					if(mul < criteria * i){
						fitness += i;
						break;
					}
				}
			}
			
		}
		
		return fitness;
		
	}
	
	/**
	 * Return specific gene.
	 * @param index
	 * 
	 * @return gene.
	 */
	public int getGeneAt(int index){
		
		return genes[index];
	
	}
	
	/**
	 * Set new gene value.
	 * 
	 * @param index
	 * @param gene
	 */
	public void setGeneAt(int index, int gene){
	
		this.genes[index] = gene;
		this.fitness = 0;
	
	}

}
