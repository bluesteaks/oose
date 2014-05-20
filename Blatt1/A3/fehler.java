int[] zahlen = {1, 2, 3, 10, 25, 36, 70};
for (int i=1; i<=zahlen.length; i++) { //muss heißen for(int i=0); i<zahlen.length;i++) denn arrays sind von 0,...,length-1 indiziert
if (zahlen[i] = 25) { //nutze == anstatt = (denn wir wollen einen Vergleich, keine Zuweisung)
System.out.println("Die Zahl wurde gefunden!");
}
}