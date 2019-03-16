
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TheGridPane extends Application {
	public void start (Stage primaryStage){
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(11,12,13,14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		pane.add(new Label ("First Name"), 0,0); 
		pane.add(new Label ("MI:"), 0,1);
        pane.add(new Label("Last Name:"), 0,2);  
		//pane.getChildren().addAll(new Label ("First Name"), new TextField(), new Label("MI:"));
		TextField tfMi = new TextField ();
		tfMi.setPrefColumnCount(1);
		//pane.getChildren().addAll(tfMi, new Label("Last Name:"), new TextField());
		FlowPane fp = new FlowPane();
		fp.getChildren().add(tfMi);
		pane.add(new TextField(), 1,0);
		pane.add(fp, 1,1);
		pane.add(new TextField(), 1,2);
		
		Scene scene = new Scene(pane, 200, 200);
	    primaryStage.setTitle("ShowFlowPane"); 
	    primaryStage.setScene(scene);               
	    primaryStage.show(); 
	    

	}
	
	public static void main(String[] args){
		launch(args);
	}


}
