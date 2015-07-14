/**
 * 
 */
package componentTransformationsAndCoordinateSpaces;

import org.mt4j.MTApplication;

/**
 * @author adalberto
 *
 */
public class StartComponentTransformation extends MTApplication {

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new ComponentTransformationScene(this, "Component Scene"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
