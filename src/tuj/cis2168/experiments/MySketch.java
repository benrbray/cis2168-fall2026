package tuj.cis2168.experiments;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PGraphics;

//////////////////////////////////////////////////

public class MySketch extends PApplet {

	Scene scene = new Scene();

	public void settings(){
		size(500, 500);
	}
	
	public void draw(){
		background(64);
		scene.draw(this.g);
	}
	
	public void mousePressed(){
		// 
	}
	
	public static void main(String[] args){
		String[] processingArgs = {"MySketch"};
		MySketch mySketch = new MySketch();
		PApplet.runSketch(processingArgs, mySketch);
	}
}

//////////////////////////////////////////////////

class Scene implements Drawable {
	
	List<Drawable> drawables;
	
	Scene() {
		this.drawables = new ArrayList<>();
		this.drawables.add(new Rectangle(100, 40, 10, 10, 0xFF000000));
	}

	public void draw(PGraphics g) {
		for(var d : this.drawables) {
			d.draw(g);
		}
	}
}

//////////////////////////////////////////////////

// VERSION 1 -- Good Version

interface Shape {
	float area();
}

interface Drawable {
	void draw(PGraphics g);
}

class Rectangle implements Shape, Drawable {

	float x;
	float y;
	float width;
	float height;
	int color; // ARGB
	
	Rectangle(float width, float height, float x, float y, int color) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public void draw(PGraphics g) {
		g.noStroke();
		g.fill(this.color);
		g.rect(this.x, this.y, this.width, this.height);
	}

	public float area() {
		return this.width * this.height;
	}
}

class Text implements Drawable {

	String message;
	float color;
	float x;
	float y;
	
	Text(String message) {

	}

	public void draw(PGraphics g) {
		g.fill(this.color);
		g.text(this.message, this.x, this.y);
	}
}