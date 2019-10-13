import javax.swing.JSlider;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RangeSlider extends JSlider {

	public RangeSlider(int orientation, int min, int max, int value, int upperValue) {
		this.orientation = SwingConstants.HORIZONTAL;
		setModel(new DefaultBoundedRangeSliderModel(value, 0, upperValue, 0, min, max));
		updateUI();
	}
	

	@Override
    public void updateUI() {
        setUI(new RangeSliderUI(this));
        updateLabelUIs();
    }
	
	public int getUpperValue() {
        if (getModel().getClass() != DefaultBoundedRangeSliderModel.class)
            return 0;

        return ((DefaultBoundedRangeSliderModel) getModel()).getUpperValue();
    };
    
	public int getValue() {
        if (getModel().getClass() != DefaultBoundedRangeSliderModel.class)
            return 0;

        return ((DefaultBoundedRangeSliderModel) getModel()).getValue();
    };

    public void setUpperValue(int n) {

    };

}
