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
	int aliensSpace = 50;
	float xDelta = 1;

	
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
				Vector2 position = new Vector2(j*aliensSpace, i*aliensSpace);
				position.x += (float) Gdx.graphics.getWidth() /2;
				position.y += Gdx.graphics.getHeight();

				position.x -= ((float) aliensWidth /2)*aliensSpace;
				position.y -= aliensHeight*aliensSpace;

				aliens[aux] = new Alien(position, alien);
				aux++;
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.draw(batch);
        for (int i = 0; i < aliens.length; i++) {
			if (aliens[i].alive){
				if (player.bulletSprite.getBoundingRectangle().overlaps(aliens[i].sprite.getBoundingRectangle())) {
					aliens[i].alive = false;
					player.bulletPositionY = 601;
					break;
				}
            	aliens[i].draw(batch);

				aliens[i].position.x += xDelta;
				if (aliens[i].position.x == Gdx.graphics.getWidth() - 50 || aliens[i].position.x == 0) {
					xDelta *= -1;
				}
			}
        }
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nave.dispose();
	}
}
