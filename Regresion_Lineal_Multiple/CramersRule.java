package examples.hello;

public class CramersRule {

	private static float[] C;
	private static float[][] D;
	
	public static float[] calculate(float[][] determinant, float[] constants) {
	
		CramersRule.D = determinant;
		CramersRule.C = constants;
		float[] solution = new float[3];
		float d  = switchColumn();
		
		if (d == 0) return null;  // no solution
		
		switchConstants(0); 
		solution[0] = switchColumn() / d;  // dx
		
		switchConstants(0);
		switchConstants(1);
		solution[1] = switchColumn() / d;  // dy

		switchConstants(1);
		switchConstants(2);
		solution[2] = switchColumn() / d;  // dz
		
		return solution;
	}
	
	public float[] calculateG(float[][] determinant, float[] constants) {
	
		CramersRule.D = determinant;
		CramersRule.C = constants;
		float[] solution = new float[3];
		float d  = switchColumn();
		
		if (d == 0) return null;  // no solution
		
		switchConstants(0); 
		solution[0] = switchColumn() / d;  // dx
		
		switchConstants(0);
		switchConstants(1);
		solution[1] = switchColumn() / d;  // dy

		switchConstants(1);
		switchConstants(2);
		solution[2] = switchColumn() / d;  // dz
		
		return solution;
	}
	private static void switchConstants(int column) {
		for (int i = 0; i < D.length; i++) {
			float temp = D[i][column];
			D[i][column] = C[i];
			C[i] = temp;
		}
	}

	private static float switchColumn() {
		return
			D[0][0] * (D[1][1] * D[2][2] - D[1][2] * D[2][1]) -  
			D[0][1] * (D[1][0] * D[2][2] - D[1][2] * D[2][0]) +
			D[0][2] * (D[1][0] * D[2][1] - D[1][1] * D[2][0]);
	}

	public static void print(float[] solution) {
		System.out.println();
		System.out.println("Solution: " + 
				"(" + solution[0] + ", " +
				solution[1] + ", " + solution[2] + ")");
		System.out.print("\n");
	}
	
	public float[] solution(float determinant[][], float constants[]) {
		System.out.println("Resolviendo: ");
		System.out.println( "( " + determinant[0][0] +"x ) + ( " + determinant[0][1]+ "y ) + ( "+ determinant[0][2] + "z ) = " + constants[0]);
		System.out.println( "( " + determinant[1][0] +"x ) + ( " + determinant[1][1]+ "y ) + ( "+ determinant[1][2] + "z ) = " + constants[1]);
		System.out.println( "( " + determinant[2][0] +"x ) + ( " + determinant[2][1]+ "y ) + ( "+ determinant[2][2] + "z ) = " + constants[2]);
		
		float result[] = CramersRule.calculate(determinant, constants);

		print(result);
		return(result);

	}
}