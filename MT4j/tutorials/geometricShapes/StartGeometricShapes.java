/**
 * 
 */
package geometricShapes;

import org.mt4j.MTApplication;

/**
 * @author adalberto
 *
 */
public class StartGeometricShapes extends MTApplication {

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new GeometricShapesScene(this, "Geometric Shapes"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
