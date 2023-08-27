package com.spaceinvaders.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture nave, bullet;
	Player player;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		nave = new Texture("nave.png");
		bullet = new Texture("bullet.png");
		player = new Player(nave, bullet);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nave.dispose();
	}
}
