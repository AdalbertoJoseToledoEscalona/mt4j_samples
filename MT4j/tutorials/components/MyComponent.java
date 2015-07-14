/**
 * 
 */
package components;

import org.mt4j.components.MTComponent;
import org.mt4j.util.camera.Icamera;

import processing.core.PApplet;
import processing.core.PGraphics;

/**
 * @author adalberto
 *
 */
public class MyComponent extends MTComponent {

	/**
	 * @param pApplet
	 */
	public MyComponent(PApplet pApplet) {
		super(pApplet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pApplet
	 * @param name
	 */
	public MyComponent(PApplet pApplet, String name) {
		super(pApplet, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pApplet
	 * @param attachedCamera
	 */
	public MyComponent(PApplet pApplet, Icamera attachedCamera) {
		super(pApplet, attachedCamera);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pApplet
	 * @param name
	 * @param attachedCamera
	 */
	public MyComponent(PApplet pApplet, String name, Icamera attachedCamera) {
		super(pApplet, name, attachedCamera);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drawComponent(PGraphics g) {
		super.drawComponent(g);
		
		g.fill(255, 0, 0);
		g.stroke(0, 0, 255);
		g.triangle(30, 75, 58, 20, 86, 75);
	}

}
