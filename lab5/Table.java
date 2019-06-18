
public class Table {
	private static int[][] secretTable = new in[10][10];
	private int numOfRows;

	public Table() { 
		numOfRows = 0;
	}

	public void addRow( int[] rowToAdd) {
		for (int i =0; i <rowToAdd.length()-1; i++) {
			secretTable[numOfRows][i] = rowToAdd[i];
		}
	}

	public static void main(String[] args) {
		Table t1 = new Table();
		System.out.print("x int, y int")
		int[] row1 = new int[2, 5];
		int[] row2 = new int[8, 3];
		int[] row3 = new int[13, 7];
		t1.addRow(row1);
		t1.addRow(row2);
		t1.addRow(row3);

		for(int i = 0; i < 20; i++) {
      		for(int j = 0; j < 20; j++) {
         		System.out.printf("%5d ", a[i][j]);
      		}
      		System.out.println();
   		}
	}
}