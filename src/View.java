import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
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

		JSplitPane splitButtonR = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, resetButton, quitButton);
		JSplitPane splitButtonL = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, saveButton, printButton);
		JSplitPane splitButton = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitButtonR, splitButtonL);
		
	
		JLabel textDistA = new JLabel("Distance to A", JLabel.CENTER);
		JSlider slidDist1 = new JSlider();

		
		JLabel textDistB = new JLabel("Distance to B", JLabel.CENTER);
		JSlider slidDist2 = new JSlider();
		

		JSplitPane splitDistA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textDistA, slidDist1);
		JSplitPane splitDistB = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textDistB, slidDist2);
		
		JLabel textBedroom = new JLabel("Bedroom", JLabel.CENTER);
		JLabel label1Range1 = new JLabel("3", JLabel.CENTER);
		JLabel label2Range1 = new JLabel("7", JLabel.CENTER);
		RangeSlider slidBed = new RangeSlider(SwingConstants.HORIZONTAL, 0, 9, 3, 7);
		slidBed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label1Range1.setText(slidBed.getValue() + "");
				label2Range1.setText(slidBed.getUpperValue() + "");
			}
		});
		
		JPanel range1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.2;
		c.gridx = 0;
		range1.add(label1Range1, c);
		c.gridx = 1;
		c.weightx = 1;
		range1.add(slidBed);
		c.gridx = 2;
		c.weightx = 0.2;
		range1.add(label2Range1, c);
		JSplitPane splitBedroom = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textBedroom, range1);

		
		JLabel textCost = new JLabel("Cost", JLabel.CENTER);
		JLabel label1Range2 = new JLabel("3M", JLabel.CENTER);
		JLabel label2Range2 = new JLabel("7M", JLabel.CENTER);
		slidCost = new RangeSlider(SwingConstants.HORIZONTAL, 0, 9, 3, 7);
		slidCost.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label1Range2.setText(slidCost.getValue() + "M");
				label2Range2.setText(slidCost.getUpperValue() + "M");
			}
		});
		
		JPanel range2 = new JPanel(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.2;
		c2.gridx = 0;
		range2.add(label1Range2, c2);
		c2.gridx = 1;
		c2.weightx = 1;
		range2.add(slidCost);
		c2.gridx = 2;
		c2.weightx = 0.2;
		range2.add(label2Range2, c2);

		JSplitPane splitCost = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textCost, range2);
	

		JSplitPane splitSlid1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitDistA, splitDistB);
		JSplitPane splitSlid2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitBedroom, splitCost);
		JSplitPane splitSlid = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitSlid1, splitSlid2);

		JSplitPane splitLateral = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitButton, splitSlid);
		splitSlid.setEnabled(false);

		MapArea map = new MapArea();
		map.setPreferredSize(new Dimension(400, 350));
		map.setLayout(new GridLayout(1, 1));

		for (int i = 0; i < nHome; i++) {
			listHome.put(i, new Home("Maison " + i, (int) (Math.random() * 400), (int) (Math.random() * 400),
					(int) (Math.random() * 10), (int) (Math.random() * 10000)));

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
