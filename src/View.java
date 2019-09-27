import javax.swing.JFrame;
import javax.swing.JSlider;


public class View {
	public View() {
		
        // Create views swing UI components 
        /*JTextField searchTermTextField = new JTextField("Dynamic Home Finder");
        JButton resetButton = new JButton("Reset");
        JButton quitButton = new JButton("Quit");
        JButton saveButton = new JButton("Save");
        JButton printButton = new JButton("Print");	
        JTable table = new JTable();
 */
 
		JSlider slidTest = new JSlider(0, 10);
        //Create controller
        //Controller controller = new Controller(searchTermTextField, model);
        //filterButton.addActionListener(controller);
 
        // Set the view layout
       /* JPanel ctrlPane = new JPanel();
        ctrlPane.add(searchTermTextField);
        ctrlPane.add(quitButton);
        ctrlPane.add(saveButton);
        ctrlPane.add(printButton);*/
        

 /*
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, ctrlPane2);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);
 */
        // Display it all in a scrolling window and make the window appear
        JFrame frame = new JFrame("TP1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(slidTest);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
