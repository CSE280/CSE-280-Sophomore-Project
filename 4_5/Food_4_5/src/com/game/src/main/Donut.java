package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.classes.EntityB;

public class Donut extends GameObject implements EntityB{
	
	Random r = new Random();
	private Textures tex;
	private Game game;
	private Controller c;
	
	private int speed = r.nextInt(3) + 1;
	
	public Donut(double x, double y, Textures tex, Controller c, Game game){
		super(x,y);
		this.tex = tex;
		this.c = c;
		this.game = game;
		
	}
	
	public void tick(){
		y += speed;
		
		if(y > (Game.HEIGHT * Game.SCALE)){
			speed = r.nextInt(3) + 1;
			y = -10;
			x = r.nextInt(640);
		}
		
		if(Physics.Collision(this,game.ea))
		{
			c.removeEntity(this);
		}
		
	}

	
	public void render(Graphics g){
		g.drawImage(tex.donut, (int)x, (int)y, null);
		
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);

	}
	
	public double getY(){
		return y;
	}

	public void setY(double y){
		this.y = y;
	}


	public double getX() {
		return x;
	}

}
