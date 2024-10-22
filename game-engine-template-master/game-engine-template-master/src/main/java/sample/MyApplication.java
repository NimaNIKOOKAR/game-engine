package sample;

import framework.geometry.FrameworkVector;
import framework.physical.PhysicalEngine;
import framework.physical.PhysicalObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MyApplication extends Application {

	private static final int INITIAL_X = 100;
	private static final int INITIAL_Y = 100;

	@Override
	public void start(Stage stage) {
		Scene scene = createScene();

		stage.setTitle("Moving an image");

		stage.setScene(scene);
		stage.show();

		Image image = new Image("sample/image.png");
		ImageView imageView = new ImageView(image);
		imageView.setX(INITIAL_X);
		imageView.setY(INITIAL_Y);

		PhysicalObject physicalObject = new PhysicalObject(1, INITIAL_X, INITIAL_Y, 100, 100);
		physicalObject.setVelocity(new FrameworkVector(5, 10));

		PhysicalEngine PE = new PhysicalEngine();
		PE.addObject(physicalObject);

		Group root = (Group) scene.getRoot();
		root.getChildren().add(imageView);  // Add this line

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				PE.update();
				imageView.setX(physicalObject.getX()%600);
				imageView.setY(physicalObject.getY()%600);
			}
		}.start();
	}

	private static Scene createScene() {
		Image image = new Image("sample/image.png");

		// Creating a Group object
		Group root = new Group();

		// Creating and returning a scene object
		return new Scene(root, 600, 600);
	}

	public static void main(String[] args) {
		launch();
	}
}
