import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class DefaultBoundedRangeSliderModel implements BoundedRangeModel {

	private int value = 0;
	private int upperValue = 0;
	private int extent = 0;
	private int upperExtent = 0;
	private int min = 0;
	private int max = 100;
	private boolean isAdjusting = false;
	
	protected EventListenerList listenerList = new EventListenerList();
	
	protected transient ChangeEvent changeEvent = null;

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
		int newExtent = Math.min(newUpperValue - newValue, extent);
		int newUpperExtent = Math.min(newMax - newUpperValue, upperExtent);
		setRangeProperties(newValue, newExtent, newUpperValue, newUpperExtent, n, newMax, isAdjusting);
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
		int newExtent = Math.min(n - newMin, extent);
		int newUpperExtent = Math.min(n - newValue, upperExtent);
		setRangeProperties(newValue, newExtent, newUpperValue, newUpperExtent, newMin, n, isAdjusting);
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
		setRangeProperties(newValue, extent, upperValue, upperExtent, min, max, isAdjusting);
	}

	@Override
	public void setValueIsAdjusting(boolean b) {
		setRangeProperties(value, extent, upperValue, upperExtent, min, max, b);
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
		setRangeProperties(value, newExtent, upperValue, upperExtent, min, max, isAdjusting);
	}
	

	public int getUpperValue() {
		return this.upperValue;
	}
	
	public void setUpperValue(int n) {
		n = Math.min(n, Integer.MAX_VALUE - upperExtent);

		int newValue = Math.max(n, min);
		if (newValue + upperExtent > max)
			newValue = max - upperExtent;
		setRangeProperties(value, extent, newValue, upperExtent, min, max, isAdjusting);
	}
	
	public void setUpperExtent(int n) {
		int newExtent = Math.max(0, n);
		if (upperValue + newExtent > max)
			newExtent = max - upperValue;
		setRangeProperties(value, extent, upperValue, newExtent, min, max, isAdjusting);
	}

	@Override
	public void setRangeProperties(int value, int extent, int min, int max, boolean adjusting) {
		this.value = value;
		this.extent = extent;
		this.min = min;
		this.max = max;
		this.isAdjusting = adjusting;
	}
	
	public int getUpperExtent() {
		return upperExtent;
	}

	@Override
	public void addChangeListener(ChangeListener x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChangeListener(ChangeListener x) {
		// TODO Auto-generated method stub

	}
	
	public void setRangeProperties(int newValue, int newExtent, int newUpperValue, int newUpperExtent, int newMin,
			int newMax, boolean adjusting) {
		if (newMin > newMax)
			newMin = newMax;
		if (newValue > newUpperValue)
			newUpperValue = newValue;
		if (newUpperValue > newMax)
			newMax = newUpperValue;
		if (newValue < newMin)
			newMin = newValue;

		if ((long) newExtent + (long) newValue > newUpperValue)
			newExtent = newUpperValue - newValue;
		if ((long) newUpperExtent + (long) newUpperValue > newMax)
			newUpperExtent = newMax - newUpperValue;

		if (newExtent < 0)
			newExtent = 0;
		if (newUpperExtent < 0)
			newUpperExtent = 0;

		boolean isChange = newValue != value || newExtent != extent || newUpperValue != upperValue
				|| newUpperExtent != upperExtent || newMin != min || newMax != max || adjusting != isAdjusting;

		if (isChange) {
			value = newValue;
			extent = newExtent;
			upperValue = newUpperValue;
			upperExtent = newUpperExtent;
			min = newMin;
			max = newMax;
			isAdjusting = adjusting;

			fireStateChanged();
		}
	}
	

	protected void fireStateChanged() {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2)
			if (listeners[i] == ChangeListener.class) {
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				((ChangeListener) listeners[i + 1]).stateChanged(changeEvent);
			}
	}

}
