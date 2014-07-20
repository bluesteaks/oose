import java.awt.*;
public class FrameBeispiel extends Frame {
/**
* Erzeugt ein Fenster
* der Groesse 320 x 280.
*/
FrameBeispiel() {
	setSize(320,280);
	setVisible(true);
}

public static void main(String[] args) {
new FrameBeispiel();
}

/**
* Zeichne einige einfache
* graphische Objekte. Diese
* ergeben einen Teil der
* Vereinzelungseinheit.
*/
public void paint(Graphics g) {
// Röhre
g.setColor(Color.black);
g.fillRect(90,5,5,240);
g.fillRect(135,5,5,200);
g.fillRect(90,245,145,5);
g.fillRect(135,205,100,5);
/**
* Zeichnet statisch einen Teil der
* Vereinzelungseinheit in ein Fenster.
*/
// Bälle
g.setColor(Color.red);
g.fillOval(95,80,40,40);
g.setColor(Color.yellow);
g.fillOval(95,120,40,40);
}
}