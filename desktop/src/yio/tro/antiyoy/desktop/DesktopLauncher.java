package yio.tro.antiyoy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import yio.tro.antiyoy.YioGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1280;
		config.width = 720;
		new LwjglApplication(new YioGdxGame(), config);
	}
}
