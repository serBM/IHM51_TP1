import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI{

	public RangeSliderUI(JSlider b) {
		super(b);
	}

	public static ComponentUI createUI(JComponent b) {
        return new RangeSliderUI((JSlider) b);
    }
}
