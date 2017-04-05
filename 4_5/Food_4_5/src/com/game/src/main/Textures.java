package com.game.src.main;

import java.awt.image.BufferedImage;

public class Textures {
	
	public BufferedImage player, missle, enemy, banana, chicken, donut;
	
	private SpriteSheet ss;
	
	public Textures(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}

	private void getTextures(){
		player = ss.grabImage(1, 1, 64, 64);
		missle = ss.grabImage(2, 1, 64, 64);
		enemy = ss.grabImage(3, 1, 64, 64);
		banana = ss.grabImage(4, 1, 64, 64);
		chicken = ss.grabImage(1, 2, 64, 64);
		donut = ss.grabImage(2, 2, 64, 64);
	}
}
