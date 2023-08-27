package com.spaceinvaders.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture nave, bullet, alien;
	Player player;
	Alien[] aliens;
	int aliensWidth = 11;
	int aliensHeight = 5;
	int aliensSpace = 20;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		nave = new Texture("nave.png");
		bullet = new Texture("bullet.png");
		alien = new Texture("alien.png");
		player = new Player(nave, bullet);
		aliens = new Alien[aliensWidth*aliensHeight];
		int aux = 0;
		for(int i = 0; i < aliensHeight; i++){
			for(int j = 0; j < aliensWidth; j++){
				aux++;
				aliens[i] = new Alien(new Vector2(j*aliensSpace, i*aliensSpace), alien);
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.draw(batch);
		for(int i = 0; i < aliens.length; i++) {
			aliens[i].draw(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nave.dispose();
	}
}
