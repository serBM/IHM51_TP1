import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View {
	
	RangeSlider slidDistA, slidDistB, slidBedroom, slidCost;
	HashMap<Integer, Home> listHome = new HashMap<>();
	int nHome = 10;
	
	public View() {

		// Create views swing UI components
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quit();
			}
		});
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		JButton printButton = new JButton("Print");
		printButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				print();
			}
		});

		JLabel textDistA = new JLabel("Distance to A", JLabel.CENTER);
		RangeSlider slidDistA = new RangeSlider(SwingConstants.HORIZONTAL, 0, 100, 25, 75);
		slidDistA.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("low : "+slidDistA.getValue());
			}
		});
		JLabel textDistB = new JLabel("Distance to B", JLabel.CENTER);
		slidDistB = new RangeSlider(SwingConstants.HORIZONTAL, 0, 100, 25, 75);
		JLabel textBedroom = new JLabel("Bedroom", JLabel.CENTER);
		slidBedroom = new RangeSlider(SwingConstants.HORIZONTAL, 0, 100, 25, 75);
		JLabel textCost = new JLabel("Cost", JLabel.CENTER);
		slidCost = new RangeSlider(SwingConstants.HORIZONTAL, 0, 100, 25, 75);

		JSplitPane splitButtonR = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, resetButton, quitButton);
		JSplitPane splitButtonL = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, saveButton, printButton);

		JSplitPane splitButton = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitButtonR, splitButtonL);

		JSplitPane splitDistA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textDistA, slidDistA);
		JSplitPane splitDistB = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textDistB, slidDistB);
		JSplitPane splitBedroom = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textBedroom, slidBedroom);
		JSplitPane splitCost = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textCost, slidCost);
		

		JSplitPane splitSlid1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitDistA, splitDistB);
		JSplitPane splitSlid2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitBedroom, splitCost);
		JSplitPane splitSlid = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitSlid1, splitSlid2);
		
		JSplitPane splitLateral = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitButton, splitSlid);
		splitSlid.setEnabled(false);

		

		MapArea map = new MapArea();
		map.setPreferredSize(new Dimension(400, 400));
		map.setLayout(new GridLayout(1, 1));
		
		for (int i = 0; i < nHome; i++) {
			listHome.put(i, new Home("Maison " + i, (int) (Math.random()*400), (int) (Math.random()*400), (int) (Math.random()*10), (int) (Math.random()*10000)));

			map.setLayout(new GridLayout(1, 1));
			map.add(listHome.get(i));
		}
		
		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("TP1");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(splitLateral, BorderLayout.EAST);
		frame.getContentPane().add(map, BorderLayout.WEST);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void reset() {
		System.out.println("reset");
	}

	public void quit() {
		System.out.println("quit");
	}

	public void save() {
		System.out.println("save");
	}

	public void print() {
		System.out.println("print");
	}
}
