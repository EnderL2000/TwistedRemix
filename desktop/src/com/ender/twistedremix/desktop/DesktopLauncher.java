package com.ender.twistedremix.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ender.twistedremix.TwistedRemix;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true"); TODO Work on borderless Windowed

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Twisted Remix";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;
		config.addIcon("Icons/AppIcon.png", Files.FileType.Internal);
		new LwjglApplication(new TwistedRemix(), config);
	}
}
