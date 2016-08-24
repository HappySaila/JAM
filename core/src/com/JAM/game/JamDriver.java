package com.JAM.game;

import Screens.MenuScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JamDriver extends Game {
	public static final int SCR_H = 900;
	public static final int SCR_W =  1080;
	public SpriteBatch sb;
	public BitmapFont font;
	private Screen screen;

	@Override
	public void create () {
		sb = new SpriteBatch();
		font = new BitmapFont();
		font.getData().scale(5);
		screen = new MenuScreen(this);
		setScreen(screen);
	}

	@Override
	public void render () {
		super.render();
	}
}
