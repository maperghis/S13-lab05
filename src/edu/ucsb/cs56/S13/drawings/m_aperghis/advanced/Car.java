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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 11, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Car(double x, double y, double width, double height)
    {
    
	double bodyHeight = .55 * height;
	double topHeight = height - bodyHeight;	
	double topWidth = .70 * width;
	double bodyUpperLeftY = y + topHeight;
	double wheelRadius = .18 * width;
	double wheel1UpperLeftX = x + wheelRadius + (width * 0.09);
	double wheel2UpperLeftX = x + width - wheelRadius - (width * 0.09);

	//Make body of car
	Rectangle2D.Double body =
	    new Rectangle2D.Double(x, bodyUpperLeftY,
				   width, bodyHeight);

	
	//Make the top of the car
	GeneralPath top = new GeneralPath();
	top.moveTo(x + (width * 0.2), y + topHeight);
        top.lineTo(x + (width * 0.3), y);
	top.lineTo(x + width, y);
	top.lineTo(x + width, y + topHeight);

        
	//Make the first wheel
	Circle wheel1 = new Circle(wheel1UpperLeftX,
				   y+height,
				   wheelRadius);
	
	//Make the second wheel
	Circle wheel2 = new Circle(wheel2UpperLeftX,
				   y+height,
				   wheelRadius);

	//Add all the parts of the car
	GeneralPath wholeCar = this.get();
	wholeCar.append(body, false);
	wholeCar.append(top, false);
	wholeCar.append(wheel1, false);
	wholeCar.append(wheel2, false);

    }

}
