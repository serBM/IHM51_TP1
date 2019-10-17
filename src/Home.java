
public class Home {

	private String name;
	private float xCoordinate;
	private float yCoordinate;
	private int nbRoom;
	private int price;
	

	public Home(String name, float xCoordinate, float yCoordinate, int nbRoom, int price) {
		this.name = name;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate ;
		this.nbRoom = nbRoom;
		this.price = price;
	}

	public float getyCoordinate() {
		return yCoordinate;
	}

	public float getxCoordinate() {
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
