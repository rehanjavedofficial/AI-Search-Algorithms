import java.util.Random;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class StochasticSearch {

	public enum COMPARISON{ MINIMUM, MAXIMUM };
	
	/**
	 * Finding the maximum/minimum index by
	 * giving array and iterations.
	 * 
	 * It generate random indexes
	 * by the number of iterations 
	 * given to find the index.
	 * 
	 * @param array
	 * @param iterations
	 * @param comparison
	 * @return minimum/maximum value
	 */
	public int getIndex(int[] array, int iterations, COMPARISON comparison){
		
		Random random = new Random();
		int index = 0;
		int randomIndex = -1;
		
		if(array.length < 1)
			return -1;
		
		for(int i = 0; i < iterations; i++){
			
			randomIndex = random.nextInt(array.length);
			
			if((array[index] > array[randomIndex] && comparison == COMPARISON.MINIMUM)
					|| (array[index] < array[randomIndex] && comparison == COMPARISON.MAXIMUM))
				index = randomIndex;
			
		}
		
		return index;
		
	}
	
	/**
	 * Finding the maximum/minimum value by
	 * giving array and iterations.
	 * 
	 * It generate random indexes
	 * by the number of iterations 
	 * given to find the number.
	 * 
	 * @param array
	 * @param iterations
	 * @param comparison
	 * @return minimum/maximum value
	 */
	public int getValue(int[] array, int iterations, COMPARISON comparison){
		
		return array[getIndex(array, iterations, comparison)];
		
	}
	
	/**
	 * Main method to test the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		StochasticSearch ss = new StochasticSearch();
		
		int[] array = new int[100000];
		Random random = new Random();
		for(int i = 0; i < 100000; i++)
			array[i] = random.nextInt(1000000);
		
		System.out.println(ss.getValue(array, 50, COMPARISON.MINIMUM));
		
	}
	
}
