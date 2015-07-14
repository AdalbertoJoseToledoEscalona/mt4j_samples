/**
 * 
 */
package helloWorld;

import org.mt4j.MTApplication;

/**
 * @author adalberto
 *
 */
public class StartHelloWorld extends MTApplication {

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new HelloWorldScene(this, "Hello World Scene"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
