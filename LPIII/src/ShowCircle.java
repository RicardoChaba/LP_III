import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
 

public class ShowCircle extends Application {
	public void start(Stage primaryStage)
	{

		Pane pane = new Pane();
		
		Circle circle = new Circle ();
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		
		//circle.setStroke(Color.BLACK);
		//circle.setFill(Color.WHITE);
		circle.setStyle("-fx-stroke: black; -fx-fill:green;");
		pane.getChildren().add(circle);
		
		pane.setRotate(45);
		pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
		Scene scene = new Scene(pane, 200, 200, Color.CYAN);
		primaryStage.setTitle("ShowCirlce");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
