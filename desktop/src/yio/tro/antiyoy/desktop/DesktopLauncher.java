package yio.tro.antiyoy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import yio.tro.antiyoy.YioGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// only edit scale
		// formulas preserves 16:9 aspect ratio
		final int scale = 60;
		config.height = 16 * scale;
		config.width = 9 * scale;

		// game would not be proportional if resized
		config.resizable = false;

		new LwjglApplication(new YioGdxGame(), config);
	}
}
