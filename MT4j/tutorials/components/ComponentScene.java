/**
 * 
 */
package components;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.interfaces.IMTComponent3D;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.IMTInputEventListener;
import org.mt4j.input.inputData.AbstractCursorInputEvt;
import org.mt4j.input.inputData.InputCursor;
import org.mt4j.input.inputData.MTInputEvent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

import processing.core.PGraphics;

/**
 * @author adalberto
 *
 */
public class ComponentScene extends AbstractScene {

	/**
	 * @param mtApplication
	 * @param name
	 */
	public ComponentScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		MTComponent a = new MTComponent(mtApplication);
		MTComponent b = new MTComponent(mtApplication);
		a.addChild(b);
		a.removeChild(b);
		
		//MyComponent component = new MyComponent(mtApplication);
		
		MTTextArea component = new MTTextArea(mtApplication, 
				FontManager.getInstance().createFont(mtApplication, "arial.ttf", 
				50,									//Font size
				new MTColor(255, 255, 255, 255),	//Font fill color
				new MTColor(255, 255, 255, 255)));	// Font outline color
		
		component.setNoFill(true);
		//component.setNoStroke(true);
		
		component.setText("Hello World!");
		
		component.removeAllGestureEventListeners();
		component.removeAllChildren();
		
		component.addInputListener(new IMTInputEventListener() {
			
			@Override
			public boolean processInputEvent(MTInputEvent inEvt) {
				if (inEvt instanceof AbstractCursorInputEvt) { //Most input events in MT4j are an instance of AbstractCursorInputEvt (mouse, multi-touch..)
					AbstractCursorInputEvt cursorInputEvt = (AbstractCursorInputEvt) inEvt;
					InputCursor cursor = cursorInputEvt.getCursor();
					IMTComponent3D target = cursorInputEvt.getTargetComponent();
					switch (cursorInputEvt.getId()) {
					case AbstractCursorInputEvt.INPUT_DETECTED:
						System.out.println("Input Detected on: " + target + " at " + cursor.getCurrentEvtPosX() + ", " + cursor.getCurrentEvtPosY());
						break;
					case AbstractCursorInputEvt.INPUT_UPDATED:
						System.out.println("Input updated on: " + target + " at " + cursor.getCurrentEvtPosX() + ", " + cursor.getCurrentEvtPosY());
						break;
					case AbstractCursorInputEvt.INPUT_ENDED:
						System.out.println("Input ended on: " + target + " at " + cursor.getCurrentEvtPosX() + ", " + cursor.getCurrentEvtPosY());
						break;

					default:
						break;
					}
				} else {
					//handle other input events
				}
				return false;
			}
		});
		
		this.getCanvas().addChild(component);
		
	}

	/* (non-Javadoc)
	 * @see org.mt4j.sceneManagement.AbstractScene#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.mt4j.sceneManagement.AbstractScene#shutDown()
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void drawAndUpdate(PGraphics graphics, long timeDelta) {
		super.drawAndUpdate(graphics, timeDelta);
		//System.out.println("timeDelta = " + timeDelta);
	}

}
