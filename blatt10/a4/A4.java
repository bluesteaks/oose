interface MapCarInterface {
	public void action(TNode n);
}

class ListOutOfBoundsException extends Exception{}

class TList<T> {
	// Kopf der Liste
	private TNode<T> head;
	//Konstruktoren
	public TList() {
		head = null;
		// null repräsentiert leere Liste
	}

	public void insertFirst(T elem) {
		// Neue Listenzelle erzeugen,
		// deren next Feld auf head zeigt.
		TNode<T> tmp = new TNode<T>(elem, head);
		// head auf neuen Anfang setzen
		head = tmp;
	}

	public void insertLast(T elem) {
		TNode<T> tmp=head;
		// Trivialfall: leere Liste
		if (head == null)
		{
		head = new TNode<T>(elem);
		return;
		}
		// Allgemeinfall:
		// zum Ende der Liste gehen
		while (tmp.next != null)
		tmp = tmp.next;
		// neue Listenzelle erzeugen und anfügen
		tmp.next = new TNode<T>(elem);
	}

	public TNode<T> get(int i) throws ListOutOfBoundsException {
		TNode<T> node=head;

		for(int j=0;j<i;j++){
			if(node.next!=null)
				node=node.next;
			else
				throw new ListOutOfBoundsException();
		}

		return node;
	}

	public void delete(int i) throws ListOutOfBoundsException {
		TNode<T> node=head;

		if(i==0){
			head=head.next;
			node=null;
		}
		else{
			for(int j=0;j<i-1;j++){
				if(node.next!=null)
					node=node.next;
				else
					throw new ListOutOfBoundsException();
			}

			if(node.next==null)
				throw new ListOutOfBoundsException();
			else
				node.next=(node.next).next;
		}
	}

	public void insert(T elem, int i) throws ListOutOfBoundsException {
		TNode<T> node=head;
		if(i==0)
			insertFirst(elem);
		else{
			for(int j=0;j<i-1;j++){
				if(node.next!=null)
					node=node.next;
				else
					throw new ListOutOfBoundsException();
			}

			TNode<T> tmp=new TNode<T>(elem,node.next);
			node.next=tmp;
		}
	}

	public String toString() {
		// Initialize
		StringBuffer sb = new StringBuffer();
		TNode x;
		sb.append("(");
		x=head;
		// Print
		while (x != null) {
			sb.append(x.data.toString());
			sb.append(" ");
			x = x.next;
		}
		// Finalize
		sb.append(")");
		return sb.toString();
	}

	public void mapcar(MapCarInterface p) {
		for(TNode<T> cursor = head; cursor != null; cursor = cursor.next)
		p.action(cursor);
	}
}

class TNode<T> {
	T data;
	// Datenelement
	TNode<T> next; // nächste Listenzelle
	// Selektoren
	public T getData()
	{ return data; }

	public TNode<T> getNext ()
	{ return next; }

	void setData(T nd)
	{ data = nd; }

	void setNext(TNode<T> nn)
	{ next = nn; }

	//Konstruktoren
	public TNode(T a)
	{ data = a; next = null; }

	public TNode(T a, TNode<T> n)
	{ data = a; next = n; }
}

class CountIntAction implements MapCarInterface {
	// Benoetigte Membervariablen hier einfuegen
	public int count;
	// Implementierung der action Methode
	public void action(TNode n) {
		if(n.data instanceof Integer)
			count++;
	}
}

class SumIntAction implements MapCarInterface {
	// Benoetigte Membervariablen hier einfuegen
	public int sum;
	// Implementierung der action Methode
	public void action(TNode n) {
		if(n.data instanceof Integer)
			sum+=(int)n.data;
	}
}

public class A4 {
	public static void main(String[] args) {
		TList<Object> l = new TList<Object>();
		l.insertFirst(new Integer(12));
		l.insertFirst("OOSE");
		l.insertFirst(new Integer(15));
		CountIntAction cia = new CountIntAction();
		l.mapcar(cia);
		System.out.println("Anzahl: " + cia.count);

		/*SumIntAction sia = new SumIntAction();
		l.mapcar(sia);
		System.out.println("Summe: " + sia.sum);*/
	}
}