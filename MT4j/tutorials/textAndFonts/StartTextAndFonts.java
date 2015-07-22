/**
 * 
 */
package textAndFonts;

import org.mt4j.MTApplication;

/**
 * @author adalberto
 *
 */
public class StartTextAndFonts extends MTApplication {

	/* (non-Javadoc)
	 * @see org.mt4j.MTApplication#startUp()
	 */
	@Override
	public void startUp() {
		addScene(new TextAndFontsScene(this, "Text And Fonts Tutorial"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}

}
