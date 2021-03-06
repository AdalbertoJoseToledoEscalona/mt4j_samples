/**
 * 
 */
package geometricShapes;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTPolygon;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;

import processing.core.PImage;

/**
 * @author adalberto
 *
 */
public class GeometricShapesScene extends AbstractScene {

	/**
	 * @param mtApplication
	 * @param name
	 */
	public GeometricShapesScene(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		this.setClearColor(new MTColor(0, 0, 0, 255));
		
		this.registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
		
		Vertex[] v = new Vertex[]{
			new Vertex(0, 0, 0, 	255, 0, 0, 255),
			new Vertex(100, 0, 0, 	0, 255, 0, 255),
			new Vertex(50, 50, 0, 	0, 0, 255, 255),
		};
		MTPolygon p = new MTPolygon(mtApplication, v);
		
		getCanvas().addChild(p);
		
		
		MTEllipse ellipse = new MTEllipse(mtApplication, new Vector3D(100, 100, 0), 60, 40);

		ellipse.setFillColor(new MTColor(0,0,255));

		//ellipse.setNoFill(true);
		
		ellipse.setStrokeColor(new MTColor(255, 0, 255));
		ellipse.setStrokeWeight(3);
		
		//ellipse.setNoStroke(true);
		
		PImage p1 = mtApplication.loadImage(MT4jSettings.getInstance().getDefaultImagesPath() + "keyb2.png");
		ellipse.setTexture(p1);
		
		ellipse.setPositionGlobal(new Vector3D(200, 250, 100));
		
		getCanvas().addChild(ellipse);
		
		/*
    Vertex[ getVerticesLocal()
    returns the shape's vertices
    Note: if we change the vertices or their attributes, the changes will only be consistent if we invoke the setVertices method with the changed vertices afterwards!
    void setVertices(Vertex[)
    sets new vertices for the shape, calculates a new bounding shape
    GeometryInfo getGeometryInfo()
    returns the shape's geometryInfo object
    void setGeometryInfo(GeometryInfo geometryInfo)
    sets new vertices (and eventually new normals and indices), calculates a new bounding shape */
		
		
		
		
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
