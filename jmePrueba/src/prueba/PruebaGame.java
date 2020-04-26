package prueba;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.image.Texture;
import com.jme.math.Vector3f;
import com.jme.scene.Node;
import com.jme.scene.Spatial;
import com.jme.scene.shape.Box;
import com.jme.scene.shape.Sphere;
import com.jme.scene.state.TextureState;
import com.jme.util.TextureManager;
import com.jme.util.export.binary.BinaryImporter;
import com.jmex.model.converters.AseToJme;
import com.jmex.model.converters.FormatConverter;
import com.jmex.model.converters.MaxToJme;
import com.jmex.model.converters.Md2ToJme;
import com.jmex.model.converters.Md3ToJme;
import com.jmex.model.converters.MilkToJme;
import com.jmex.model.converters.ObjToJme;
import com.jmex.model.converters.X3dToJme;

public class PruebaGame extends SimpleGame {

	public static void main(String[] args) {
		PruebaGame app = new PruebaGame();
	    app.setConfigShowMode(ConfigShowMode.AlwaysShow);
	    app.start();
	}


	@Override
	protected void simpleInitGame() {
		display.setTitle("Tutorial 1");

		Sphere s = new Sphere("Sphere", 30, 30, 25);
		s.setLocalTranslation(new Vector3f(0,0,-40));
		s.setModelBound(new BoundingBox());
		s.updateModelBound();

		Texture texture = TextureManager.loadTexture(
				PruebaGame.class.getClassLoader().getResource(
		        "res/enemy1.png"),
		        Texture.MinificationFilter.Trilinear,
		        Texture.MagnificationFilter.Bilinear);

		TextureState ts = display.getRenderer().createTextureState();

		ts.setEnabled(true);
		ts.setTexture(texture);
		s.setRenderState(ts);
		rootNode.attachChild(s);
		//rootNode.attachChild(loadModel("res/pepe.obj"));
//		JointController cntrl = (JointController)(myModel.getController(0));
	//	cntrl.setTimes(1, 50);
		//cntrl.setRepeatType(JointController.RT_WRAP);


	}

	private Node loadModel(String fileName) {
		  Spatial model = null;

		  try {
		    String format = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

		    File binary = new File(fileName.substring(0, fileName.lastIndexOf(".") + 1) + "jme");
		    if (!binary.exists()) {
		      FormatConverter formatConverter = null;

		      if (format.equalsIgnoreCase("ase")) {
		        formatConverter = new AseToJme();
		      } else if (format.equalsIgnoreCase("3ds")) {
		        formatConverter = new MaxToJme();
		      } else if (format.equalsIgnoreCase("md2")) {
		        formatConverter = new Md2ToJme();
		      } else if (format.equalsIgnoreCase("md3")) {
		        formatConverter = new Md3ToJme();
		      } else if (format.equalsIgnoreCase("ms3d")) {
		        formatConverter = new MilkToJme();
		      } else if (format.equalsIgnoreCase("obj")) {
		        formatConverter = new ObjToJme();
		      } else if (format.equalsIgnoreCase("x3d")) {
		        formatConverter = new X3dToJme();
		      }

		      File file = new File(fileName);
		      formatConverter.setProperty("texurl", file.getParentFile().toURI().toURL());
		      formatConverter.setProperty("mtllib", file.toURI().toURL());

		      ByteArrayOutputStream output = new ByteArrayOutputStream();

		      formatConverter.convert(file.toURI().toURL().openStream(), output);
		      BinaryImporter importer = BinaryImporter.getInstance();
		      model = (Spatial) importer.load(new ByteArrayInputStream(output.toByteArray()));

		      // BinaryExporter.getInstance().save((Savable) model, binary);
		    } else {
		      model = (Spatial) BinaryImporter.getInstance().load(binary.toURI().toURL());
		    }
		  } catch (Exception exception) {
		    exception.printStackTrace();
		    model = new Box("box", new Vector3f(), 15, 15, 15);
		  }

		  Node node = new Node("model");
		  node.attachChild(model);

		  return node;
		}

}
