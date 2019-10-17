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
		JLabel label1Range1 = new JLabel("3", JLabel.CENTER);
		JLabel label2Range1 = new JLabel("7", JLabel.CENTER);
		RangeSlider slidDistA = new RangeSlider(SwingConstants.HORIZONTAL, 0, 9, 3, 7);
		slidDistA.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				label1Range1.setText(slidDistA.getValue() + "");
				label2Range1.setText(slidDistA.getUpperValue() + "");
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

		JPanel range1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.2;
		c.gridx = 0;
		range1.add(label1Range1, c);
		c.gridx = 1;
		c.weightx = 1;
		range1.add(slidDistA);
		c.gridx = 2;
		c.weightx = 0.2;
		range1.add(label2Range1, c);


		JSplitPane splitDistA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textDistA, range1);
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
