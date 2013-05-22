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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a car with a trailer that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc. It extends the Car Class.
      
   @author Miranda Aperghis
   @version for CS56, lab06, S13, 19/05/2013
   @see Car
   
*/
public class CarWithTrailer extends Car implements Shape
{
     /**
       Constructor

       @param x x coord of bottom left corner of car
       @param y y coord of bottom left corner of car
       @param width width of the car
       @param height height of the car
     */
    public CarWithTrailer(double x, double y, double width, double height)
    {
	// construct the basic car
	super(x,y,width,height);

	//Radius of wheels
    	double wheelRadius = 0.15 * width;	
	double bottomCarY = y + height - wheelRadius;
	//Trailer co-ordinates
	double trailerTopLeftX = x + width + (width*0.2);
	double trailerTopLeftY = bottomCarY - (height * 0.45);
	double trailerWidth = width * 0.7;
	double trailerHeight = y + height - trailerTopLeftY - wheelRadius;

	//Draw trailer
	Rectangle2D.Double trailer =
	    new Rectangle2D.Double(trailerTopLeftX,
				   trailerTopLeftY,
				   trailerWidth,
				   trailerHeight); 

	double wheel1CenterX = trailerTopLeftX + (trailerWidth * 0.05) + wheelRadius;
	double wheel2CenterX = trailerTopLeftX + trailerWidth - (trailerWidth * 0.05) - wheelRadius;

	//Draw cirlces
	Circle wheel1 = new Circle(wheel1CenterX,bottomCarY,wheelRadius);
	Circle wheel2 = new Circle(wheel2CenterX,bottomCarY,wheelRadius);

	//Draw trailer connection
	GeneralPath g = new GeneralPath();
	g.moveTo(x+width,y+(height*0.5));
	g.lineTo(trailerTopLeftX,y+(height*0.5));
	g.moveTo(trailerTopLeftX,y+(height*0.52));
	g.lineTo(x+width,y+(height*0.52));
	
	//Get the GeneralPath that we are going to append the new trailer to
        GeneralPath wholeCar = this.get();
        wholeCar.append(trailer, false);
	wholeCar.append(wheel1, false);
	wholeCar.append(wheel2, false);
	wholeCar.append(g, false);
        
    }

}
