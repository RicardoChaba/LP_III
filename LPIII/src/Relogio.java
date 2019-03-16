import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


public class Relogio extends Pane implements Runnable {
	
	
	//Pane root = new Pane();
	
	Circle relogio;
	Line hora, minuto,segundo;
	Text dozeTxt, tresTxt, seisTxt, noveTxt, digital;
	
	
	private void geraRelogio() {
	
	int centroX, centroY, raioRelogio;
	centroX = 200;
	centroY = 200;
	raioRelogio = 100;
	
	relogio = new Circle(centroX, centroY, raioRelogio);
	relogio.setFill(Color.WHITE);
	relogio.setStroke(Color.BLACK);
	
	dozeTxt = new Text(centroX-5, centroY-raioRelogio+12, "12");
	dozeTxt.setFill(Color.BLACK);
	
	tresTxt = new Text(centroX+raioRelogio-10, centroY+3, "3");
	tresTxt.setFill(Color.BLACK);
	
	seisTxt = new Text(centroX-3, centroY+raioRelogio-3, "6");
	seisTxt.setFill(Color.BLACK);
	
	noveTxt = new Text(centroX-raioRelogio+3, centroY+5, "9");
	noveTxt.setFill(Color.BLACK);
	
	Calendar calendar = GregorianCalendar.getInstance();

	hora = new Line(centroX, centroY, centroX, centroY - 20);
    hora.setStroke(Color.BLACK);
    hora.setStrokeWidth(3);
    Rotate rotateHora = new Rotate();

    int horaInt = calendar.get(Calendar.HOUR);
    int grausHora = horaInt * (360 / 12);
    rotateHora.setAngle(grausHora);
    rotateHora.setPivotX(centroX);
    rotateHora.setPivotY(centroY);
    hora.getTransforms().add(rotateHora);
	
    minuto = new Line(centroX, centroY, centroX, centroY - 40);
    minuto.setStroke(Color.GOLD);
    minuto.setStrokeWidth(3);
    Rotate rotateMin = new Rotate();

    int minInt = calendar.get(Calendar.MINUTE);
    int anguloMinuto = minInt * (360 / 60);
    System.out.println(anguloMinuto + " angulo Minuto");
    rotateMin.setAngle(anguloMinuto); 
    
    rotateMin.setPivotX(centroX);
    rotateMin.setPivotY(centroY);
    minuto.getTransforms().add(rotateMin);

    segundo = new Line(centroX, centroY, centroX, centroY - 60);
    segundo.setStroke(Color.GOLD);
    segundo.setStrokeWidth(3);

    Rotate rotateSeg = new Rotate();
    int segInt = calendar.get(Calendar.SECOND);
    rotateSeg.setAngle(segInt * 6); 
    System.out.println(segInt);
    rotateSeg.setPivotX(centroX);
    rotateSeg.setPivotY(centroY);
    segundo.getTransforms().add(rotateSeg);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String horaT = sdf.format(System.currentTimeMillis());

    digital = new Text(horaT);
    digital.setX(centroX - 40);
    digital.setY(centroY + 150);
    digital.setFont(Font.font("Arial", 20));
    
    getChildren().clear();

	getChildren().addAll(relogio,dozeTxt,tresTxt,seisTxt,noveTxt,hora,minuto,segundo,digital);
	
	
		
}

	 @Override
	 public void run() {
	      while (true) {
	         try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            Platform.runLater(new Runnable() {
	                @Override
	                public void run() {
	                   geraRelogio();
	                }
	            });
	        }
	}
}

