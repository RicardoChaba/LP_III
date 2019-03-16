import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestaRelogio extends Application {
	
	Relogio clock = new Relogio();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(clock, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

     public static void main(String[] args) {
        launch(args);
    }
}
	
