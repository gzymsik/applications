import java.util.Random;

public class Randomizer {

	private Random randomGenerator = null;
	
	Randomizer() {
		randomGenerator = new Random(System.currentTimeMillis());
	}
	
	private int get_1_to_5_int() {
		return randomGenerator.nextInt(4) + 1;
	}
	
	private int get_1_to_7_int() {
		int result;
		
		do {
			result = get_1_to_5_int() + get_1_to_5_int() - 1;
		} while(result > 7);
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Randomizer r = new Randomizer();
		for(int i = 0; i < 10; i++) {
			System.out.println("Randomized number: " + r.get_1_to_7_int());
		}
	}

}
