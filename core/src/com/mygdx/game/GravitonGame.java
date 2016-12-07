package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GravitonGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ball;
	Texture blackhole;

	Ball playerBall;

	int width, height;

	GameInput input;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ball = new Texture("ball.png");
		blackhole = new Texture("blackhole.png");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		playerBall = new Ball(ball, width / 2, height / 2);
		input = new GameInput();
		Gdx.input.setInputProcessor(input);
		input.addEventListener(playerBall);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		playerBall.update();
		playerBall.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ball.dispose();
		blackhole.dispose();
	}
}
