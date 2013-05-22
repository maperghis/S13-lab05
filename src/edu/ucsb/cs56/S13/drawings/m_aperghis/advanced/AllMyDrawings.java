package edu.ucsb.cs56.S13.drawings.m_aperghis.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A class with static methods for drawing various pictures
   
   @author Miranda Aperghis
   @version for CS56, lab05, S13, 19/05/2013  
*/

public class AllMyDrawings
{
    /** Draw a picture with a few cars 
     */

    public static void drawPicture1(Graphics2D g2) {

	Car c1 = new Car(100,250,100,100);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a green car that's half the size, 
	// and moved over 100 pixels up in the y direction

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,0,-100);
	g2.setColor(Color.GREEN); g2.draw(c2);
	
	// Car that is 2x bigger than the original
	// and moved 100 pixels to the right
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,100,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// Set the thick stroke
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFDEE00)); 
	g2.draw(c2); 

	// Sign the image
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few cars by Miranda Aperghis", 20,20);

    }


    /** Draw a picture with a few cars and a car with a trailer
     */
    public static void drawPicture2(Graphics2D g2) {

	//Draw some cars
	Car large = new Car(400,400,50,20);
	Car small = new Car(80,50,200,300);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(small);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x045DB0)); 

	// Draw a car with a trailer
	CarWithTrailer ct1 = new CarWithTrailer(200,100,100,100);
	g2.draw(ct1);

	// Rotate the car with trailer 90 degrees around its center
	// then translate it 200 pixels in the x direction and
	// 100 in the y direction
	Shape ct2 = ShapeTransforms.rotatedCopyOf(ct1, Math.PI/2.0);
	ct2 = ShapeTransforms.translatedCopyOf(ct2,200,100);
	g2.setColor(new Color(0x8F00FF)); 
	g2.draw(ct2);
	
	// Sign the image
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some cars and cars with trailers by Miranda Aperghis", 20,20);
    }
  
    /** Draw a different picture with a few cars with trailers
     */

    public static void drawPicture3(Graphics2D g2) {

	Stroke thick = new BasicStroke (5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFDEE00)); 

	// Draw a car with a trailer
	CarWithTrailer ct1 = new CarWithTrailer(200,100,100,100);
	g2.draw(ct1);

	// Rotate the car with trailer 90 degrees around its center
	// then translate it 200 pixels in the x direction and
	// 100 in the y direction
	Shape ct2 = ShapeTransforms.rotatedCopyOf(ct1, Math.PI/2.0);
	ct2 = ShapeTransforms.translatedCopyOf(ct2,200,100);
	g2.setColor(new Color(0xE30022)); 
	g2.draw(ct2);

	// Repeat rotations 3 more times to create a nice pattern
	Shape ct3 = ShapeTransforms.rotatedCopyOf(ct2, Math.PI/2.0);
	ct3 = ShapeTransforms.translatedCopyOf(ct3,-200,100);
	g2.setColor(new Color(0x66FF00)); 
	g2.draw(ct3);	

	Shape ct4 = ShapeTransforms.rotatedCopyOf(ct3, Math.PI/2.0);
	ct4 = ShapeTransforms.translatedCopyOf(ct4,-200,-100);
	g2.setColor(new Color(0x1C1CF0)); 
	g2.draw(ct4);	

	// Sign the image
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some cars with trailers by Miranda Aperghis", 20,20);

    }
    

}
