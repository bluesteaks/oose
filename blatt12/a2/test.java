public class test{
	public static void main(String[] args){
TierKaefig<?> keafig= new TierKaefig<Katze>();
TierKaefig<Katze> keafig2=(TierKaefig<Katze>) keafig;
keafig2.setInsasse(new Katze());

	}
}

class TierKaefig<E> {
private E insasse;
public void setInsasse(E x){
insasse= x;
}
public E getInsasse(){
return insasse;
}
}
class Tier {
}
class Hund extends Tier{
}
class Katze extends Tier{
}