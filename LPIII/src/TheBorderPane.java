
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TheBorderPane extends Application {
	public void start (Stage primaryStage){
		
			    primaryStage.setTitle("BorderPane Test");
			    BorderPane bp = new BorderPane();
			    bp.setPadding(new Insets(10, 20, 10, 20));
			    
			    FlowPane pane = new FlowPane();
			    pane.setAlignment(Pos.CENTER);
				pane.setPadding(new Insets(11,12,13,14));
				pane.setHgap(5);
				pane.setVgap(5);
				
				pane.getChildren().addAll(new Label ("Name"), new TextField(), new Button("Buscar"));
				bp.setTop(pane);
				
				
				
				ListView lista = new ListView();
				lista.getItems().add("Item 1");
				lista.getItems().add("Item 2");
				lista.getItems().add("Item 3");
				lista.getItems().add("Item 4");
				lista.getItems().add("Item 5");
				lista.getItems().add("Item 6");
				lista.getItems().add("Item 7");
				lista.getItems().add("Item 8");
				lista.getItems().add("Item 9");
				lista.getItems().add("Item 10");
				
			    Button btnLeft = new Button("Left");
			    bp.setLeft(lista);
			    
			    TableView table = new TableView();
			    

			    Button btnCenter = new Button("Center");
			    bp.setCenter(table);

			    //Button btnRight = new Button("Right");
			    //bp.setRight(btnRight);

			    
			    Button btnBottomA = new Button("A");
			    Button btnBottomB = new Button("B");
			    Button btnBottomC = new Button("C");
			    Button btnBottomD = new Button("D");
			    
			    FlowPane pane2 = new FlowPane();
			    pane2.setAlignment(Pos.CENTER);
				pane2.getChildren().add(btnBottomA);
				pane2.getChildren().add(btnBottomB);
				pane2.getChildren().add(btnBottomC);
				pane2.getChildren().add(btnBottomD);
				
			    bp.setBottom(pane2);

			    Scene scene = new Scene(bp, 300, 250);
			    primaryStage.setScene(scene);
			    primaryStage.show();
			  }
	    
	
	public static void main(String[] args){
		launch(args);
	}


}
