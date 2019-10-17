import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Home extends JPanel {

	private String name;
	private int xCoordinate;
	private int yCoordinate;
	private int nbRoom;
	private int price;

	@Override
	public void paintComponent(Graphics g) {
		g.drawRect(xCoordinate, yCoordinate, 10, 10);
		g.drawLine(xCoordinate - 5, yCoordinate + 5, xCoordinate + 5, yCoordinate - 5);
		g.drawLine(xCoordinate + 5, yCoordinate - 5, xCoordinate + 15, yCoordinate + 5);
		g.drawString(" " + nbRoom, xCoordinate, yCoordinate);
	}

	public Home(String name, int xCoordinate, int yCoordinate, int nbRoom, int price) {
		this.name = name;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.nbRoom = nbRoom;
		this.price = price;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public String getName() {
		return name;
	}

	public int getNbRoom() {
		return nbRoom;
	}

	public int getPrice() {
		return price;
	}
}
