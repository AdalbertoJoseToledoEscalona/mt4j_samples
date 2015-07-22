/**
 * 
 */
package multitouchGesturesOnComponents;

import org.mt4j.MTApplication;
import org.mt4j.components.interfaces.IMTComponent3D;
import org.mt4j.components.visibleComponents.shapes.AbstractShape;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.input.gestureAction.DefaultDragAction;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.AbstractComponentProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.scaleProcessor.ScaleProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;

import components.MyComponent;

/**
 * @author adalberto
 *
 */
public class MultitouchGesturesOnComponentsScene extends AbstractScene {

	/**
	 * @param mtApplication
	 * @param name
	 */
	public MultitouchGesturesOnComponentsScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		
		
		MTRectangle component = new MTRectangle(0, 0, 100, 100, mtApplication);
		
		component.unregisterAllInputProcessors();
		component.removeAllGestureEventListeners();
		
		//Setting up multi-touch gesture functionality 
		
		component.registerInputProcessor(new DragProcessor(mtApplication));
		component.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				
				DragEvent de = (DragEvent) ge;
				de.getTargetComponent().translateGlobal(de.getTranslationVect()); //Moves the component
				
				switch (de.getId()) {
				case MTGestureEvent.GESTURE_STARTED:
					System.out.println("Drag Gesture on component " + de.getTargetComponent() +  " started");
					break;
					
				case MTGestureEvent.GESTURE_UPDATED:
					System.out.println("Drag Gesture on component " + de.getTargetComponent() +  " updated");
					break;
					
				case MTGestureEvent.GESTURE_ENDED:
					System.out.println("Drag Gesture on component " + de.getTargetComponent() +  " ended");
					break;

				default:
					break;
				}
				
				
				return false;
			}
		});
		
		//component.addGestureListener(DragProcessor.class, new DefaultDragAction());
		
		
		// Default input processors 
		
		AbstractShape.createDefaultGestures = false;
		
		MTRectangle r = new MTRectangle(300, 300, 100, 100, mtApplication);
		r.unregisterAllInputProcessors();
		r.registerInputProcessor(new TapProcessor(mtApplication));
		r.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent) ge;
				
				IMTComponent3D target = te.getTargetComponent();
				
				if (target instanceof MTRectangle) {
					MTRectangle rectangle = (MTRectangle) target;
					switch (te.getTapID()) {
					case TapEvent.BUTTON_DOWN:
						System.out.println("Button down state on " + target);
						rectangle.setFillColor(new MTColor(200, 100, 100));
						break;
						
					case TapEvent.BUTTON_UP:
						System.out.println("Button up state on " + target);
						rectangle.setFillColor(new MTColor(255, 255, 255));
						break;
						
					case TapEvent.BUTTON_CLICKED:
						System.out.println("Button clicked state on " + target);
						rectangle.setFillColor(new MTColor(255, 255, 255));
						break;

					default:
						break;
					}
				}
				
				return false;
			}
		});
		
		
		// Removing registered input processors 
		
		for (AbstractComponentProcessor ip : component.getInputProcessors()) {
			if (ip instanceof ScaleProcessor) {
				component.unregisterInputProcessor(ip);
			}
		}
		component.removeAllGestureEventListeners(ScaleProcessor.class);
		
		getCanvas().addChild(component);
		getCanvas().addChild(r);
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

}
