import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

public class RangeSliderUI extends BasicSliderUI {

	private Rectangle upperThumb;
	private Rectangle unionRect;

	public RangeSliderUI(JSlider b) {
		super(b);
	}

	public static ComponentUI createUI(JComponent b) {
		return new RangeSliderUI((JSlider) b);
	}

	@Override
	public void installUI(JComponent c) {
		this.upperThumb = new Rectangle();
		this.unionRect = new Rectangle();
		super.installUI(c);
	}

	@Override
	public void uninstallUI(JComponent c) {
		this.upperThumb = null;
        this.unionRect = null;
		super.uninstallUI(c);
	}

	@Override
	protected TrackListener createTrackListener(JSlider slider) {
		return null;
	}

	@Override
	protected void calculateThumbSize() {
        Dimension size = getThumbSize();
        thumbRect.setSize(size.width, size.height);
        upperThumb.setSize(size.width, size.height);
	}

	@Override
	protected void calculateThumbLocation() {
        super.calculateThumbLocation();

        int valuePosition = xPositionForValue(((RangeSlider) slider).getUpperValue());

        upperThumb.x = valuePosition - upperThumb.width / 2;
        upperThumb.y = trackRect.y;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);

		Rectangle clip = g.getClipBounds();

		if (clip.intersects(upperThumb))
			paintThumb(g);
	}

	@Override
	public void paintThumb(Graphics g) {
		Rectangle knobBounds = thumbRect;
		subPaintThumb(g, knobBounds);

		knobBounds = upperThumb;
		subPaintThumb(g, knobBounds);
	}

	private void subPaintThumb(Graphics g, Rectangle knobBounds) {
		int w = knobBounds.width;
		int h = knobBounds.height;

		g.translate(knobBounds.x, knobBounds.y);

		if (slider.isEnabled())
			g.setColor(slider.getBackground());
		else
			g.setColor(slider.getBackground().darker());

		g.fillRect(0, 0, w, h);

		g.setColor(Color.black);
		g.drawLine(0, h - 1, w - 1, h - 1);
		g.drawLine(w - 1, 0, w - 1, h - 1);

		g.setColor(getHighlightColor());
		g.drawLine(0, 0, 0, h - 2);
		g.drawLine(1, 0, w - 2, 0);

		g.setColor(getShadowColor());
		g.drawLine(1, h - 2, w - 2, h - 2);
		g.drawLine(w - 2, 1, w - 2, h - 3);

		g.translate(-knobBounds.x, -knobBounds.y);
	}

	public void setUpperThumbLocation(int x, int y) {
        unionRect.setBounds(upperThumb);

        upperThumb.setLocation(x, y);

        SwingUtilities.computeUnion(upperThumb.x, upperThumb.y, upperThumb.width, upperThumb.height, unionRect);
        slider.repaint(unionRect.x, unionRect.y, unionRect.width, unionRect.height);
	}

}
