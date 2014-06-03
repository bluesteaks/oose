public class Damenproblem {
	private int n;
	private int[][] feld;
	public int num;

	public Damenproblem (int d) {
		this.n=d;
		feld=new int[d][d];
	}
	public void ausgabe() {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(feld[i][j]+ " ");
			System.out.println();
		}
		System.out.println();

	}

	public boolean korrektPlatziert() {
		//gehe Spaltenweise Damen durch
		for(int j=0;j<n;j++){
			int i=0;
			boolean found=false;

			//finde Zele der Dame
			for(i=0;i<n;i++){
				if(feld[i][j]==1){
					found=true;
					break;
				}
			}

			if(!found)
				return true;

			for(int k=-i;k<n-i;k++){
				//diagonale oben links nach unten rechts
				if(i+k>=0 && i+k <n &&j+k>=0 && j+k <n && k!=0){
					if(feld[i+k][j+k]==1){
						return false;
					}
				}

				//andere diagonale
				if(i+k>=0 && i+k <n &&j-k>=0 && j-k <n && k!=0){
					if(feld[i+k][j-k]==1){
						return false;
					}
				}

				//vertikale
				if(i+k>=0 && i+k <n && k!=0){
					if(feld[i+k][j]==1){
						return false;
					}
				}
			}

			//horizontale
			for(int k=-j;j+k<n;k++)
				if(k!=0){
					if(feld[i][j+k]==1){
						return false;
					}
				}	
		}

		return true;
	}

	public void platziere(int j){
		//müssen noch platzieren
		if(j<n)
			for(int i=0;i<n;i++){
				feld[i][j]=1;
				if(korrektPlatziert())
					platziere(j+1);				

				feld[i][j]=0;
			}

		//haben alles platziert
		if(j==n && korrektPlatziert()){
			ausgabe();
			num++;
		}

	}

	static public void main (String[] arg) {
		Damenproblem dOk = new Damenproblem (4);
		dOk.feld[1][0] = 1;
		dOk.feld[3][1] = 1;
		dOk.feld[0][2] = 1;
		dOk.feld[2][3] = 1;

		if (dOk.korrektPlatziert()) {
			System.out.println ("dOk ist eine moegliche Loesung!:");
		}
		else {
			System.out.println ("dOk ist keine erlaubte Loesung:");
		}

		dOk.ausgabe();

		Damenproblem d= new Damenproblem(5);
		d.platziere(0);
		System.out.println(d.num);
	}
}