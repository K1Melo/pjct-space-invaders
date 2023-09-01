package com.spaceinvaders.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Sprite sprite;
    public int bulletPositionX, bulletPositionY;
    public Sprite bulletSprite;
    private boolean shooting = false;
    public int deltaVelocity = 10;
    public Player(Texture img, Texture bullet){
        sprite = new Sprite(img);
        position = new Vector2((float) Gdx.graphics.getWidth()/2 - 25, 0);

        bulletPositionX = (int) position.x;
        bulletSprite = new Sprite(bullet);
    }

    public void updatePlayer(){
        if (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.graphics.getWidth() - 55 > position.x) {
            position.x += deltaVelocity;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && 5 < position.x) {
            position.x -= deltaVelocity;
        }
    }

    public void moveMissile(){
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            shooting = true;
        }
        if (shooting && bulletPositionY < Gdx.graphics.getHeight()) {
            bulletPositionY += 10;
        } else {
            bulletPositionX = (int) position.x;
            bulletPositionY = (int) sprite.getHeight()/2 - 20;
            shooting = false;
        }
    }

    public void draw(SpriteBatch batch){
        this.moveMissile();
        this.updatePlayer();
        bulletSprite.setPosition(bulletPositionX + sprite.getWidth()/2, bulletPositionY + sprite.getHeight()/2 - 10);
        bulletSprite.draw(batch);
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
