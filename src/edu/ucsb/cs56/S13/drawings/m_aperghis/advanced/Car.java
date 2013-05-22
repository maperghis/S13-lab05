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
   A vector drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Miranda Aperghis
   @version for CS56, lab06, S13, 19/05/2013
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of bottom left corner of car
       @param y y coord of bottom left corner of car
       @param width width of the car
       @param height height of the car
     */
    public Car(double x, double y, double width, double height)
    {
	//Radius of wheels
    	double wheelRadius = 0.15 * width;	
	//Edges of wheels
	double leftEdgeWheel1X = x + (width * 0.09);
	double rightEdgeWheel2X = x + width - (width * 0.09);
	double leftEdgeWheel2X = rightEdgeWheel2X - (wheelRadius * 2);
	double rightEdgeWheel1X = leftEdgeWheel1X + (wheelRadius * 2);
	//Body of car
	double bottomCarY = y + height - wheelRadius;
	double bonnetY = bottomCarY - (height * 0.45);
	double windShieldX = x + (width * 0.30);
	double topWindShieldX = x + (width * 0.56);
	//Wheels
	double wheel1CenterX = leftEdgeWheel1X + wheelRadius;
	double wheel1CenterY = bottomCarY;
	double wheel2CenterX = rightEdgeWheel2X - wheelRadius;
	double wheel2CenterY = wheel1CenterY;
	//Windows
	double topLeftWindowX =	x + (width * 0.60); 
	double topLeftWindowY =	y + (height * 0.05);
	double windowWidth = (width * 0.4) - (width * 0.05);	
	double windowHeight = bonnetY - y - (height * 0.05);


	//Make the first wheel
	Circle wheel1 = new Circle(wheel1CenterX,
				   wheel1CenterY,
				   wheelRadius);
	
	//Make the second wheel
	Circle wheel2 = new Circle(wheel2CenterX,
				   wheel2CenterY,
				   wheelRadius);

	//Make body of car
	GeneralPath body = new GeneralPath();
	body.moveTo(leftEdgeWheel1X,bottomCarY);
	body.lineTo(x,bottomCarY);
	body.lineTo(x,bonnetY);
	body.lineTo(windShieldX,bonnetY);
	body.lineTo(topWindShieldX,y);
	body.lineTo(x + width, y);
	body.lineTo(x + width, bottomCarY);
	body.lineTo(rightEdgeWheel2X, bottomCarY);
	body.moveTo(leftEdgeWheel2X, bottomCarY);
	body.lineTo(rightEdgeWheel1X, bottomCarY);

	//Make windows of car
	Rectangle2D.Double window = 
            new Rectangle2D.Double(topLeftWindowX,
				   topLeftWindowY,
				   windowWidth,
				   windowHeight);
	
	GeneralPath windShield = new GeneralPath();
	windShield.moveTo(windShieldX + (height * 0.05), bonnetY);
	windShield.lineTo(topLeftWindowX - (height * 0.05), topLeftWindowY);
	windShield.lineTo(topLeftWindowX - (height * 0.05), bonnetY);
	windShield.lineTo(windShieldX + (height * 0.05), bonnetY); 	
	
	//Add all the parts of the car
	GeneralPath wholeCar = this.get();
	wholeCar.append(wheel1, false);
	wholeCar.append(wheel2, false);
	wholeCar.append(body, false);
	wholeCar.append(window, false);
	wholeCar.append(windShield, false);

    }

}
