import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeListener;

public class DefaultBoundedRangeSliderModel implements BoundedRangeModel {

	private int value = 0;
	private int upperValue = 0;
	private int extent = 0;
	private int upperExtent = 0;
	private int min = 0;
	private int max = 100;
	private boolean isAdjusting = false;

	public DefaultBoundedRangeSliderModel() {
	}

	public DefaultBoundedRangeSliderModel(int value, int extent, int upperValue, int upperExtent, int min, int max) {
		if (max >= min && value >= min && value + extent >= value && value + extent <= upperValue
				&& upperValue + extent >= upperValue && upperValue + upperExtent <= max) {
			this.value = value;
			this.upperValue = upperValue;
			this.extent = extent;
			this.upperExtent = upperExtent;
			this.min = min;
			this.max = max;
		} else
			throw new IllegalArgumentException("invalid range properties");
	}

	@Override
	public int getMinimum() {
		return this.min;
	}

	@Override
	public void setMinimum(int newMinimum) {
		this.min = newMinimum;

	}

	@Override
	public int getMaximum() {
		return this.max;
	}

	@Override
	public void setMaximum(int newMaximum) {
		this.max = newMaximum;

	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int newValue) {
		this.value = newValue;

	}

	@Override
	public void setValueIsAdjusting(boolean b) {
		this.isAdjusting = b;

	}

	@Override
	public boolean getValueIsAdjusting() {
		return this.isAdjusting;
	}

	@Override
	public int getExtent() {
		return this.extent;
	}

	@Override
	public void setExtent(int newExtent) {
		this.extent = newExtent;

	}

	@Override
	public void setRangeProperties(int value, int extent, int min, int max, boolean adjusting) {
		this.value = value;
		this.extent = extent;
		this.min = min;
		this.max = max;
		this.isAdjusting = adjusting;
	}

	@Override
	public void addChangeListener(ChangeListener x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChangeListener(ChangeListener x) {
		// TODO Auto-generated method stub

	}

}
