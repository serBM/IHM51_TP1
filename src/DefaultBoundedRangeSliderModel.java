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
	public void setMinimum(int n) {
		int newMax = Math.max(n, max);
		int newValue = Math.max(n, value);
		int newUpperValue = Math.max(n, upperValue);
	}

	@Override
	public int getMaximum() {
		return this.max;
	}

	@Override
	public void setMaximum(int n) {
		int newMin = Math.min(n, min);
		int newValue = Math.min(n, value);
		int newUpperValue = Math.min(n, upperValue);
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setValue(int n) {
		n = Math.min(n, Integer.MAX_VALUE - extent);

		int newValue = Math.max(n, min);
		if (newValue + extent > upperValue)
			newValue = upperValue - extent;
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
	public void setExtent(int n) {
		int newExtent = Math.max(0, n);
		if (value + newExtent > upperValue)
			newExtent = upperValue - value;
	}
	

	public int getUpperValue() {
		return this.upperValue;
	}
	
	public void setUpperValue(int n) {
		n = Math.min(n, Integer.MAX_VALUE - upperExtent);

		int newValue = Math.max(n, min);
		if (newValue + upperExtent > max)
			newValue = max - upperExtent;
	}
	
	public void setUpperExtent(int n) {
		int newExtent = Math.max(0, n);
		if (upperValue + newExtent > max)
			newExtent = max - upperValue;
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
