public class Fehler {
public static void g() throws Exception{
System.out.println( "Ausgabe 1");
throw new Exception ();
}
public static void f() throws Exception{
try
{
g();
System.out.println("Ausgabe 2");
}
catch (Exception e)
{
System.out.println("Ausgabe 3");
}
}
public static void main (String args[]){
try
{
f();
}
catch(Exception e)
{
System.out.println("Ausgabe 4");
}
}
}