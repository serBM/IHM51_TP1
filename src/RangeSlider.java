import javax.swing.JSlider;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RangeSlider extends JSlider {

	public RangeSlider(int orientation, int min, int max, int value, int upperValue) {
		this.orientation = SwingConstants.HORIZONTAL;
		setModel(new DefaultBoundedRangeSliderModel(value, 0, upperValue, 0, min, max));
		updateUI();
	}
}
