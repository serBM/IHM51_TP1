import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

public class View {
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
		RangeSlider slidDistA = new RangeSlider(0, 0, 10, 5, 7);
		JLabel textDistB = new JLabel("Distance to B", JLabel.CENTER);
		JSlider slidDistB = new JSlider(0, 100);
		JLabel textBedroom = new JLabel("Bedroom", JLabel.CENTER);
		JSlider slidBedroom = new JSlider(0, 100);
		JLabel textCost = new JLabel("Cost", JLabel.CENTER);
		JSlider slidCost = new JSlider(0, 100);
		// Create controller
		// Controller controller = new Controller(searchTermTextField, model);
		// filterButton.addActionListener(controller);

		// Set the view layout
		/*
		 * JPanel ctrlPane = new JPanel(); ctrlPane.add(searchTermTextField);
		 * ctrlPane.add(quitButton); ctrlPane.add(saveButton);
		 * ctrlPane.add(printButton);
		 */

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

		

		JLabel test = new JLabel("test", JLabel.CENTER);
		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("TP1");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(splitLateral, BorderLayout.EAST);
		frame.getContentPane().add(test, BorderLayout.WEST);
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
