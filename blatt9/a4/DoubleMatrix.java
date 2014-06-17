/**
* Diese Klasse repräsentiert reelle mxn-Matrizen
*/
public class DoubleMatrix{
	public int numrows,numcols;
	public double[][] entries;

	/** Konstruktor, nimmt nur Dimensionen */
	public DoubleMatrix(int m, int n) {
		numrows=m;
		numcols=n;
		entries=new double[m][n];
	}

	/**Konstruktor, Matrix durch Einträge definieren */
	public DoubleMatrix(double[][] array){
	    this(array.length,array[0].length);

		for (int i=0; i<array.length;i++)
	        for (int j=0; j<array[i].length;j++)
	           entries[i][j] = array[i][j];
	}

	/** Matrix auf Konsole ausgeben*/
	public void print(){
		for(int i=0;i<numrows;i++){
			String row="";
			for(int j=0;j<numcols;j++)
				row+=entries[i][j]+" ";

			System.out.println(row);
		}

		System.out.println();
	}

	/** Empfänger mit Matrix B multiplizieren, gibt Fehler bei inkompatiblen Dimensionen
	* @return Produktmatrix
	*/
	public DoubleMatrix matrixMult(DoubleMatrix B) {
		if(this.numcols != B.numrows){
			System.err.println("Die Dimensionen sind inkompatibel ("+this.numcols+"!="+B.numrows+")");
			return null;
		}

		double[][] array=new double[this.numrows][B.numcols];

		for(int i=0;i<this.numrows;i++)
			for(int j=0;j<B.numcols;j++)
				for(int k=0;k<this.numcols;k++)
					array[i][j]+=this.entries[i][k]*B.entries[k][j];

		return new DoubleMatrix(array);
	}

	public static void main(String args[]){
		double[][] array={{1, 2, 3}, {4, 5, 6}};
		double[][] array2={{1, 2, 3}, {4, 5, 6},{1,2,3}};
		DoubleMatrix mat = new DoubleMatrix(array);
		DoubleMatrix mat2 = new DoubleMatrix(array2);
		mat.print();
		mat2.print();
		mat.matrixMult(mat2).print();

	}
}