package com.JAM.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.JAM.game.JamDriver;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = JamDriver.SCR_W;
		config.height = JamDriver.SCR_H;
		config.title = "John and Michael";
		new LwjglApplication(new JamDriver(), config);
	}
}
