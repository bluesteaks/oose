import java.io.*;

public class exe {
public static void main(String[] args)
throws FileNotFoundException {
FileReader f=new FileReader("exe.java");
try {
while (true) {
int c=f.read();
if (c<0) return;
System.out.print((char)c);
}
}
catch(IOException e) {}
}
}