package edu.ucsb.cs56.S13.drawings.m_aperghis.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;
/**
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class CarWithTrailer extends Car implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public CarWithTrailer(double x, double y, double width, double height)
    {
	// construct the basic car
	super(x,y,width,height);
	
	GeneralPath gp = this.get();

	// Make the trailer
	double trailerTopLeftX = x + width + width*0.1;
	double trailerTopLeftY = y + height*0.6;
	double trailerWidth = width*0.5;
	double trailerHeight = height - trailerTopLeftY;

	Rectangle2D.Double trailer =
	    new Rectangle2D.Double(trailerTopLeftX,
				   trailerTopLeftY,
				   trailerWidth,
				   trailerHeight);

        

	// get the GeneralPath that we are going to append the trailer to
        GeneralPath wholeCar = this.get();
        wholeCar.append(trailer, false);
        
    }

}
