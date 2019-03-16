import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyJavaFX extends Application{
	
	public void start(Stage prymareStage)
	{
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("OK"));
		Button btOK = new Button("OK");
		Scene scene = new Scene (pane, 200, 250);
		prymareStage.setTitle("MyJavaFX");
		prymareStage.setScene(scene);
		prymareStage.show();
	}

public static void main(String[] args){
	launch(args);
}
}
