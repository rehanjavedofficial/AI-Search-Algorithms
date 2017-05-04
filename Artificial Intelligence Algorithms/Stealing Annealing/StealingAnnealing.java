import java.util.Random;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class StealingAnnealing {

	// Constants..
	private static final int MIN_RANGE = 0;
	private static final int MAX_RANGE = 100000;
	private static final int MIN_TEMPERATURE = 0;
	private static final int MAX_TEMPERATURE = 100;
	private static final double COOLING_RATE = 2;
	
	// current temperature.
	private int temperature = MAX_TEMPERATURE;
	private Random random;
	private int[] numbers;
	private int bestIndex;
	
	public static enum COMPARISON{ MINIMUM, MAXIMUM };
	
	private COMPARISON comparison;
	
	/**
	 * Constructor.
	 * 
	 * creating a population to start
	 * searching in it.
	 * 
	 * @param comparison
	 */
	public StealingAnnealing(COMPARISON comparison){
		
		this.comparison = comparison;
		
		random = new Random();
		numbers = new int[MAX_RANGE];
		
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = random.nextInt(1000000);
		
		
	}
	
	/**
	 * finding energy of value.
	 * 
	 * @param value
	 * @return energy
	 */
	public int getEnergy(int value){
		
		return numbers[value];
		
	}
	
	/**
	 * Cooling Temperature.
	 */
	public void coolTemperature(){
		
		temperature -= COOLING_RATE;
		
	}
	
	/**
	 * Checking probability to accept
	 * worst value.
	 * 
	 * @param newEnergy
	 * @param energy
	 * @return probability.
	 */
	public double checkProbability(int newEnergy, int energy){
		
		if((newEnergy > energy && comparison == COMPARISON.MAXIMUM) ||
				(newEnergy < energy && comparison == COMPARISON.MINIMUM))
			return 1;
		
		return Math.exp((newEnergy - energy)/temperature);
		
	}
	
	/**
	 * Finding global optimum
	 * number using stealing
	 * annealing strategy.
	 */
	public void findingOptimum(){
		
		int newEnergy;
		int newIndex;
		int currentIndex = 0;
		int currentEnergy;
		
		while(temperature != MIN_TEMPERATURE){
			
			newIndex = MIN_RANGE + random.nextInt(MAX_RANGE - MIN_RANGE);
			newEnergy = getEnergy(newIndex);
			currentEnergy = getEnergy(currentIndex);
			
			if(checkProbability(newEnergy, currentEnergy) > Math.random()){
				
				currentIndex = newIndex;
				
			}
			
			if((currentEnergy > getEnergy(bestIndex) && comparison == COMPARISON.MAXIMUM) ||
					(currentEnergy < getEnergy(bestIndex) && comparison == COMPARISON.MINIMUM))
				bestIndex = currentIndex;
			
			coolTemperature();
			
		}
		
		System.out.println("Best Index: "+bestIndex+", Best Value: "+getEnergy(bestIndex));
		
	}
	
	/**
	 * Main method to start the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		StealingAnnealing sa = new StealingAnnealing(StealingAnnealing.COMPARISON.MINIMUM);
		sa.findingOptimum();
		
	}

}
