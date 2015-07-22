/**
 * 
 */
package multitouchGesturesOnComponents;

import org.mt4j.MTApplication;

/**
 * @author adalberto
 *
 */
public class StartMultitouchGesturesOnComponents extends MTApplication {

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new MultitouchGesturesOnComponentsScene(this, "MT Gestures On Components"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
