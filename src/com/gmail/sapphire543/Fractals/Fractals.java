package com.gmail.sapphire543.Fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fractals extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/** Project Configurations */
	private final int iterations = 4;
	private final boolean debug = false;
	public byte type = 0;
	public byte gen = 0;
	
	public Fractals() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setSize(1200, 1030);
	}

	public static void main(String[] args) {
		Fractals fractals = new Fractals();
		fractals.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics = (Graphics2D) g;
		List<Line2D> lines = new ArrayList<>();
		
		if (gen == 0) {
			Line2D lineA = new Line2D.Float(850, 670, 150, 670);
			Line2D lineB = new Line2D.Float(500, 60, 850, 670);
			Line2D lineC = new Line2D.Float(150, 670, 500, 60);
			
			lines.add(lineA);
			lines.add(lineB);
			lines.add(lineC);
		} else if (gen == 2) {
			
			//200,200,650,650
			Line2D lineA = new Line2D.Float(200, 650, 200, 200);
			Line2D lineB = new Line2D.Float(200, 200,650, 200);
			Line2D lineC = new Line2D.Float(650, 650, 200, 650);
			Line2D lineD = new Line2D.Float(650, 200, 650, 650);
			
			lines.add(lineA);
			lines.add(lineB);
			lines.add(lineC);
			lines.add(lineD);
		}
		
		for (int i = 0; i < iterations; i++) {
			List<Line2D> temp = new ArrayList<>();
			for (Line2D baseLine : lines) {
				Point2D p1 = baseLine.getP1();
				Point2D p2 = baseLine.getP2();
				if (type == 0) {
					float distance = (float) p1.distance(p2);
					float a = (float) Math.atan2((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
					
					Point2D n1 = new Point2D.Float((float) (p1.getX() + ((distance / 3) * Math.sin(a))), (float) (p1.getY() + ((distance / 3) * Math.cos(a))));
					Point2D n2 = new Point2D.Float((float) (n1.getX() + ((distance / 3) * Math.sin(Math.toRadians(Math.toDegrees(a) + 60)))), (float) (n1.getY() + ((distance / 3) * Math.cos(Math.toRadians(Math.toDegrees(a) + 60)))));
					Point2D n3 = new Point2D.Float((float) (p1.getX() + ((distance / 3) * 2 * Math.sin(a))), (float) (p1.getY() + ((distance / 3) * 2 * Math.cos(a))));
					Line2D newLine1 = new Line2D.Float(n1, n2);
					Line2D newLine2 = new Line2D.Float(n2, n3);
					
					Line2D micLine1 = new Line2D.Float(p1, n1);
					Line2D micLine2 = new Line2D.Float(n3, p2);
					
					temp.add(newLine1);
					temp.add(newLine2);
					temp.add(micLine1);
					temp.add(micLine2);
				}
				if (type == 1) {
					float distance = (float) p1.distance(p2);
					float a = (float) Math.atan2((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
					
					Point2D n1 = new Point2D.Float((float) (p1.getX() + ((distance / 3) * Math.sin(a))), (float) (p1.getY() + ((distance / 3) * Math.cos(a))));
					Point2D n2 = new Point2D.Float((float) (n1.getX() + ((distance / 3) * Math.sin(Math.toRadians(Math.toDegrees(a) + 90)))), (float) (n1.getY() + ((distance / 3) * Math.cos(Math.toRadians(Math.toDegrees(a) + 90)))));
					Point2D n3 = new Point2D.Float((float) (p1.getX() + ((distance / 3) * 2 * Math.sin(a))), (float) (p1.getY() + ((distance / 3) * 2 * Math.cos(a))));
					Point2D n4 = new Point2D.Float((float) (n3.getX() + ((distance / 3) * Math.sin(Math.toRadians(Math.toDegrees(a) + 90)))), (float) (n3.getY() + ((distance / 3) * Math.cos(Math.toRadians(Math.toDegrees(a) + 90)))));

					Line2D newLine1 = new Line2D.Float(n1, n2);
					Line2D newLine2 = new Line2D.Float(n2, n4);
					Line2D newLine3 = new Line2D.Float(n4, n3);
					
					Line2D micLine1 = new Line2D.Float(p1, n1);
					Line2D micLine2 = new Line2D.Float(n3, p2);
					
					temp.add(newLine1);
					temp.add(newLine2);
					temp.add(newLine3);
					temp.add(micLine1);
					temp.add(micLine2);
				}
				if (type == 2) {
					float distance = (float) p1.distance(p2);
					float a = (float) Math.atan2((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
					
					Point2D n1 = new Point2D.Float((float) (p1.getX() + ((distance / 3) * Math.sin(Math.toRadians(Math.toDegrees(a) + 45)))), (float) (p1.getY() + ((distance / 3) * Math.cos(Math.toRadians(Math.toDegrees(a) + 45)))));
					Point2D n2 = new Point2D.Float((float) (p2.getX() + ((distance / 3) * Math.sin(Math.toRadians(Math.toDegrees(a) - 135)))), (float) (p2.getY() + ((distance / 3) * Math.cos(Math.toRadians(Math.toDegrees(a) - 135)))));
					
					Line2D newLine1 = new Line2D.Float(p1, n1);
					Line2D newLine2 = new Line2D.Float(n1, n2);
					Line2D newLine3 = new Line2D.Float(n2, p2);
					
					temp.add(newLine1);
					temp.add(newLine2);
					temp.add(newLine3);
				}
			}
			if (debug) {
				for (Line2D line : lines) {
					graphics.draw(line);
				}
			}
			lines.clear();
			lines.addAll(temp);
		}
		for (Line2D line : lines) {
			graphics.draw(line);
		}
		lines.clear();
	}
}