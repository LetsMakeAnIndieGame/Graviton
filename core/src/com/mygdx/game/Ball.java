package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ball implements InputEventListener {
    private Texture texture;
    private int x, y;
    private final int speed = 3;
    private double angleToTarget;
    private boolean isFired = false;

    public Ball(Texture texture, int x, int y) {
        this.texture = texture;
        this.x = x; this.y = y;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void update() {
        if (isFired) {
            x += Math.cos(angleToTarget) * speed;
            y += Math.sin(angleToTarget) * speed;
        }
    }

    @Override
    public void notifyEvent(int event, int screenX, int screenY, int pointer, int button) {
        if (event == GameInput.TOUCH_DOWN) {
            isFired = true;
            Gdx.app.log("Ball heard touchdown", "" + screenX + ", " + screenY);

            int diffX = screenX - x;
            int diffY = Gdx.graphics.getHeight() - screenY - y;

            angleToTarget = Math.atan2((double)diffY, (double)diffX);
        }
    }
}
