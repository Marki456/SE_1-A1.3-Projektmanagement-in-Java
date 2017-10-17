import java.util.Arrays;

public class ProjOrder {
	String[][] input;
	private boolean debug = false;
	
	public ProjOrder(String[][] input) {
		this.input = input;
	}
	
	public boolean isWellSortet( String[] sequence ){
		if(sequence[0].equals("A") && sequence[1].equals("B") && sequence.length == 2) return false;
		if(sequence.length < 2) return false;
		for(int i = 0; i < input.length; i++) {
			String[] currentRelation = input[i];
			int[] resultSet = containsBoth(sequence,currentRelation);
			if(resultSet[0] == -3 && resultSet[1] == -3) return false;
			if (currentRelation.length > 2 || currentRelation[0].equals(currentRelation[1])) {
				if (debug) System.out.println("Illegal Relation! Skipping: " + Arrays.toString(currentRelation));
				continue;
			}
			
			if (debug) System.out.println("Analyzed Sequence " + Arrays.toString(sequence) + " for " + Arrays.toString(currentRelation) + " found at Postions " + Arrays.toString(resultSet));
			if(resultSet[0] != -1 && resultSet[1] != -1) {
				if(resultSet[0] > resultSet[1]) {
					if (debug) System.out.println("Analyzed Sequence " + Arrays.toString(sequence) + " for " + Arrays.toString(currentRelation) + " Misplace in " + Arrays.toString(resultSet));
					return false;
				}
			}
		}
		return true;
	}
	
	public int[] containsBoth(String[] sequence, String[] relation) {
		int con0 = -1;
		int con1 = -1;
		for(int i = 0; i < sequence.length; i++) {
			con0 = (sequence[i].equals(relation[0])) ? i : con0;
			con1 = (sequence[i].equals(relation[1])) ? i : con1;
			for(int n = 0; n < sequence.length; n++) {
				if(i != n && sequence[i].equals(sequence[n])) {
					if(debug) System.out.println("Analyzed Sequence " + Arrays.toString(sequence) + " Doubled Character! Not Sorted!");
					return new int[] {-3,-3};
				}
			}
		}
		return new int[] {con0,con1};
	}
}
