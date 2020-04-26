import java.io.InputStream;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextField;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.sun.midp.io.j2me.storage.File;

public class KeyEventMIDlet extends MIDlet implements CommandListener {
	private Command exitCommand;
	private Display display;
	private Canvas keyCanvas;
	private String actualLog = new String();
	private Form screen;
	private TextField nombre;
	private TextField logField;
	private Command PlayCommand;



	// private Form screen;

	public KeyEventMIDlet() {
		// Obtenemos el objeto Display del midlet.
		display = Display.getDisplay(this);


		// Creamos la pantalla principal (un formulario)
		screen = new Form("UI");
		nombre = new TextField("Nombre","",30,TextField.ANY);
		logField = new TextField("Log","",255,TextField.ANY);

		screen.append(nombre);
		screen.append(logField);




		keyCanvas = new Canvas() {
			private int keyCode;

			public void paint(Graphics g) {

				g.setColor(255, 255, 255);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(200, 200, 0);
				g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD,
						Font.SIZE_MEDIUM));

				if (this.keyCode > 0) {
					g.drawString("keyPressed " + ((char) this.keyCode), 50, 50,
							Graphics.HCENTER | Graphics.BOTTOM);
				} else {

					int code = getGameAction((int) this.keyCode);

					String gameAction;
					switch (getGameAction(code)) {
					case LEFT:
						gameAction = "LEFT";
						break;
					case RIGHT:
						gameAction = "RIGHT";
						break;
					case UP:
						gameAction = "UP";
						break;
					case DOWN:
						gameAction = "DOWN";
						break;
					case FIRE:
						gameAction = "FIRE";
						break;
					case GAME_A:
						gameAction = "GAME_A";
						break;
					case GAME_B:
						gameAction = "GAME_B";
						break;
					case GAME_C:
						gameAction = "GAME_C";
						break;
					case GAME_D:
						gameAction = "GAME_D";
						break;
					default:
						gameAction = (new Integer(code)).toString();
					}

					g.drawString("keyPressed " + gameAction, 50, 50,
							Graphics.HCENTER | Graphics.BOTTOM);
				}

				g.setColor(255, 255, 255);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.setColor(200, 200, 0);
				g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD,
						Font.SIZE_MEDIUM));
				actualLog = "Logging on screen: " + actualLog;
				System.out.println(actualLog);
				g.drawString(actualLog, 50, 50, Graphics.HCENTER
						| Graphics.BOTTOM);

			}

			protected void keyPressed(int keyCode) {
				if (keyCode > 0) {
					System.out.println("keyPressed " + ((char) keyCode));
					System.out.println("keyReleased " + ((char) keyCode));

				} else {

					System.out.println("keyPressed action "
							+ getGameAction(keyCode));
					System.out.println("keyReleased action "
							+ getGameAction(keyCode));
				}

				this.keyCode = keyCode;
				this.repaint();



				playMp3();

			}

		};

		// Creamos el comando Salir.
		exitCommand = new Command("Salir", Command.EXIT, 2);
	    PlayCommand = new Command("PlayMp3", Command.SCREEN, 3);


	//	keyCanvas.addCommand(exitCommand);

		// Añadimos el comando Salir e indicamos que clase lo manejará
		//keyCanvas.setCommandListener(this);

		screen.addCommand(exitCommand);
		screen.addCommand(PlayCommand);
		screen.setCommandListener(this);

	}

	public void startApp() throws MIDletStateChangeException {
		// Seleccionamos la pantalla a mostrar
		//display.setCurrent(keyCanvas);
		display.setCurrent(screen);
	}

	private void playMp3() {
		try {

			String f = File.getStorageRoot();
			System.out.println("root: "+ f);
			actualLog = "root:"+f ;
			String userDir = System.getProperty("user.dir");
			logField.setString(actualLog + " ++ "+ userDir);

			String file = nombre.getString();
			InputStream is = getClass().getResourceAsStream(file);

			actualLog = "get resource mp3";
			System.out.println(actualLog);
			keyCanvas.repaint();
			//logField.setString(actualLog);

			if (is == null) {
				is = getClass().getResourceAsStream("/droidmarch.mp3");
				actualLog = "get resource = null";
				System.out.println(actualLog);
				//logField.setString(actualLog);
				keyCanvas.repaint();
			}
			Player player = null;

			player = Manager.createPlayer(is, "audio/mpeg");

			player.setLoopCount(2);

			actualLog = "player created";
			System.out.println(actualLog);
			keyCanvas.repaint();
			//logField.setString(actualLog);

			player.realize();

			actualLog = "player realize";
			System.out.println(actualLog);
			keyCanvas.repaint();
			//logField.setString(actualLog);

			// get volume control for player and set volume to max
			VolumeControl vc = (VolumeControl) player
					.getControl("VolumeControl");

			actualLog = "Volume control";
			System.out.println(actualLog);
			keyCanvas.repaint();
			//logField.setString(actualLog);

			if (vc != null) {
				vc.setLevel(100);

				actualLog = "Volume to max";
				System.out.println(actualLog);
				keyCanvas.repaint();
				//logField.setString(actualLog);

			}
			player.prefetch();

			actualLog = "prefetch";
			System.out.println(actualLog);
			keyCanvas.repaint();
		//	logField.setString(actualLog);

			player.start();

			actualLog = "start";
			System.out.println(actualLog);
			keyCanvas.repaint();
			//logField.setString(actualLog);

		} catch (Exception e) {
			System.out.println("mp3 exception" + e.getMessage());
			e.printStackTrace();

		}
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean incondicional) {
	}

	public void commandAction(Command c, Displayable s) {
		// Salir
		if (c == exitCommand) {
			destroyApp(false);
			notifyDestroyed();
		}
		if(c== PlayCommand){
			playMp3();
		}
	}
}
