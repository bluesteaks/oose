import java.util.*;

/**
* Diese Klasse repräsentiert reelle mxn-Matrizen
*/
class DoubleMatrix{
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
	public DoubleMatrix matrixMult(DoubleMatrix B, int numThreads) {
		if(this.numcols != B.numrows){
			System.err.println("Die Dimensionen sind inkompatibel ("+this.numcols+"!="+B.numrows+")");
			return null;
		}
		
		List<Cell> cells = new LinkedList<Cell>();
		for(int i=0;i<this.numrows;i++)
			for(int j=0;j<B.numcols;j++)
				cells.add(new Cell(i,j));

		DoubleMatrix C= new DoubleMatrix(this.numrows,B.numcols);

		Thread[] t = new Thread[numThreads];
		for(int i=0;i<numThreads;i++)
			t[i]= new Thread(new DotProduct(this,B,C,cells));

		for(int i=0;i<numThreads;i++)
			try{t[i].join();} catch(InterruptedException ex) {}

		return C;
	}

	public DoubleMatrix matrixMultOld(DoubleMatrix B) {
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
}

class Cell{
	private int x,y;
	public Cell(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
}

class DotProduct implements Runnable {
	DoubleMatrix A,B,C;
	List<Cell> cells;

	public DotProduct(DoubleMatrix A, DoubleMatrix B, DoubleMatrix C, List<Cell> cells){
		this.A=A;
		this.B=B;
		this.C=C;
		this.cells=cells;
	}

	public void run() {
		while(true){
			Cell cell=null;
			synchronized(cells){
				if (cells.isEmpty())
					return;
				cell = cells.get(0);
				cells.remove(cell);
			}

			int x=cell.getX();
			int y=cell.getY();
			double c=0;

			for(int k=0;k<A.numcols;k++)
				c+=A.entries[x][k]*B.entries[k][y];

			synchronized(C){
				C.entries[x][y]=c;
			}

		}
	}
}

public class DoubleMatrixThreads {
	public static void main(String args[]){
		double[][] array=new double[200][200];
		double[][] array2=new double[200][200];

		for (int i = 0; i < array.length; i++) {
		    for (int j = 0; j < array[i].length; j++) {
		        array[i][j] = (int)(Math.random()*10);
		        array2[i][j] = (int)(Math.random()*10);
		    }
		}

		DoubleMatrix A = new DoubleMatrix(array);
		DoubleMatrix B = new DoubleMatrix(array2);

		long tix = System.currentTimeMillis();
		{
			A.matrixMult(B,4);
		}
		System.out.println(System.currentTimeMillis()-tix);

		tix = System.currentTimeMillis();
		{
			A.matrixMultOld(B);
		}
		System.out.println(System.currentTimeMillis()-tix);

	}
}