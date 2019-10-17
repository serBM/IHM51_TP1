import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapArea extends JPanel {
	
	HashMap<Integer, Home> listHome = new HashMap<>();
	int nHome = 0;
	
	@Override
	public void paintComponent(Graphics g) {
		
		/*for (int i = 0; i < nHome; i++) {
			listHome.put(i, new Home("Maison " + i, (int) (Math.random()*400), (int) (Math.random()*400), (int) (Math.random()*10), (int) (Math.random()*10000)));
			g.drawRect(listHome.get(i).getxCoordinate(), listHome.get(i).getyCoordinate(), 10, 10);
			g.drawLine(listHome.get(i).getxCoordinate()-5, listHome.get(i).getyCoordinate()+5, listHome.get(i).getxCoordinate()+5, listHome.get(i).getyCoordinate()-5);
			g.drawLine(listHome.get(i).getxCoordinate()+5, listHome.get(i).getyCoordinate()-5, listHome.get(i).getxCoordinate()+15, listHome.get(i).getyCoordinate()+5);
		}*/
	}
}
