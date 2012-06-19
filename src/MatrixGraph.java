import java.util.Random;
import java.util.Stack;


public class MatrixGraph {

	private int matrix[][];
	private int size;
	
	private Random randomizer = null;
	
	private boolean trueOrFalse() {
		return randomizer.nextBoolean();
	}
	
	MatrixGraph(int size) {
		this.size = size;
		
		matrix = new int[size][size];
		
		randomizer = new Random(System.currentTimeMillis());
	}
	
	private void generateRandomMatrix() {
		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				matrix[i][j] = trueOrFalse() ? 1 : 0;
				matrix[j][i] = matrix[i][j];
			}
		}
	}
	
	public void printGraphMatrix() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(j < i) {
					System.out.print("  ");
				} else {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private int visitedArray[];
	
	private void initializeVisitedArray() {
		visitedArray = new int[size];
		for(int i = 0; i < size; i++) {
			visitedArray[i] = 0;
		}
	}
	
	private void recursive_dfs(int node) {
		if(visitedArray[node] == 1) {
			return;
		}
		
		visitedArray[node] = 1;
		for(int i = 0; i < size; i++) {
			if((i != node) && (matrix[node][i] == 1)) {
				recursive_dfs(i);
			}
		}
		
		System.out.print(node + " ");
	}
	
	private void iteration_dfs(int start_node) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(start_node);
		visitedArray[start_node] = 0;
		while(!stack.empty()) {
			int node = stack.peek();
			if(visitedArray[node] == 2) {
				stack.pop();
				System.out.print(node + " ");
			} else {
				for(int i = 0; i < size; i++) {
					if((i != node) && (matrix[node][i] == 1) && (visitedArray[i] == 0)) {
						stack.push(i);
						visitedArray[i] = 1;
					}
				}
				visitedArray[node] = 2;
			}
		}
	}
	
	public void recursiveDFS() {
		initializeVisitedArray();
		
		for(int i = 0; i < size; i++) {
			if(visitedArray[i] == 0) {
				recursive_dfs(i);
			}
		}
		System.out.println();
	}
	
	public void iterativeDFS() {
		initializeVisitedArray();
		
		for(int i = 0; i < size; i++) {
			if(visitedArray[i] == 0) {
				iteration_dfs(i);
			}
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MatrixGraph graph = new MatrixGraph(5);
		graph.generateRandomMatrix();
		
		graph.printGraphMatrix();

		graph.recursiveDFS();
		graph.iterativeDFS();
	}

}
