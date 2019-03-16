
import java.math.BigDecimal;
import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TheTabForm extends Application {
	
	Button btnBottomA;
    Button btnBottomB; 
    Button btnBottomC; 
    Button btnBottomD; 
    Button btnBottomE; 
    TabPane tabPane;
    TableView table;
    Tab tab1,tab2;
    ContextMenu ctxMenu;
    MenuItem mnuEdit, mnuDelete;
    TextField txtKeyword, txtName, txtProucts, txtItem;
    Label labelKeyword, labelOption, name, type, qtty, price;
    
    
   
	public void start (Stage primaryStage){
		
			    primaryStage.setTitle("TabForm Test");
			    BorderPane bp = new BorderPane();
			    bp.setPadding(new Insets(10, 20, 10, 20));
			    
			    FlowPane pane = new FlowPane();
			    pane.setAlignment(Pos.CENTER);
				pane.setPadding(new Insets(11,12,13,14));
				pane.setHgap(5);
				pane.setVgap(5);
				
				TextField keywordInput = new TextField();
				
				labelKeyword = new Label("Keyword");
				labelKeyword.setOpacity(0);
				
				txtKeyword = new TextField();
				txtKeyword.setOpacity(0);
				
				labelOption = new Label("Option");
				labelOption.setOpacity(0);
				
				
				
				
				
				
				keywordInput.setOnKeyPressed(e-> {keyword_onAction(e);});
				
				pane.getChildren().addAll(new Label ("Keyword"), keywordInput, new Label("Option"));
				ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList( "Name", "Products", "Item"));
				
				pane.getChildren().add(cb);		
			    bp.setTop(pane);
			    
			    tabPane = new TabPane();
			    tab1 = new Tab();
			    tab2 = new Tab();
			    tab1.setText("Products");
			    tab1.setOnSelectionChanged(e -> {tab1_onSelectionChange(e);});
			    tab2.setText("Edit");
			    
			    
			    GridPane gp = new GridPane();
			    gp.add(new Label ("Name: "), 0,0);
			    gp.add(new TextField(),1,0);
			    gp.add(new Label ("Type:"),0,1);
			    gp.add(new ChoiceBox(FXCollections.observableArrayList( "Item 1", "Item 2", "Item 3")),1,1);
			    gp.add(new Label ("Qtty: "), 0,2);
			    gp.add(new TextField(),1,2);
			    gp.add(new Label ("Price: "), 0,3);
			    gp.add(new TextField(),1,3);
			    gp.add(new Button("Select Picture"),0,4);
			    
			    
			    
		
			    table = new TableView();
			    
			    table.setEditable(true);
			    
			    table.setOnMouseClicked(e -> {table_onMouseCliked(e);});
			    
			    final ObservableList<Produto> produtos = FXCollections.observableArrayList(
			            new Produto("Cerveja",ProductType.Bebida,new BigDecimal(40),10),
			            new Produto("Sabão",ProductType.Limpeza,new BigDecimal(8),5),
			            new Produto("Arroz",ProductType.Comida,new BigDecimal(5),25)
			           
			          );
			    
			    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			    
			    TableColumn productName = new TableColumn("Name");
			    productName.setCellValueFactory(new PropertyValueFactory<Produto, String>("name"));
			    
			    productName.setCellFactory(TextFieldTableCell.forTableColumn());
			    productName.setOnEditCommit(
			    		new EventHandler<CellEditEvent<Produto, String>>(){
			    	@Override
			    	public void handle(CellEditEvent<Produto, String> t){
			    		((Produto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
			    	}
			    }
			   
			  );
			    
			    TableColumn productType = new TableColumn("Type");
			    productType.setCellValueFactory(new PropertyValueFactory<Produto, String>("type"));
			    
			    productType.setCellFactory(ChoiceBoxTableCell.forTableColumn(ProductType.values()));
			    productType.setOnEditCommit(
			    		new EventHandler<TableColumn.CellEditEvent<Produto, ProductType >>(){
			    	@Override
			    	public void handle(CellEditEvent<Produto, ProductType> t){
			    		((Produto) t.getTableView().getItems().get(t.getTablePosition().getRow())).setType(t.getNewValue());
			    	}
			    }
			   
			  );
			    
			    TableColumn productPrice = new TableColumn("Price");
			    productPrice.setCellValueFactory(new PropertyValueFactory<Produto, BigDecimal>("price"));
			    
			    TableColumn productQtty = new TableColumn("Qtty");
			    productQtty.setCellValueFactory(new PropertyValueFactory<Produto, BigDecimal>("qtty"));
			    
			    TableColumn productImage = new TableColumn("Image");
			    productImage.setCellValueFactory(new PropertyValueFactory<Produto, ImageView>("image"));
			    
			    table.getColumns().addAll(productName,productType,productPrice,productQtty,productImage);
			    table.setItems(produtos);
			    
			    ctxMenu = new ContextMenu();
			    mnuEdit = new MenuItem("Edit");
			    mnuEdit.setOnAction(e-> {mnuEdit_onAction(e);});
			    mnuDelete = new MenuItem("Delete");
			    mnuDelete.setOnAction(e-> {mnuDelete_onAction(e);});
			    ctxMenu.getItems().addAll(mnuEdit, mnuDelete);
			    table.setContextMenu(ctxMenu);

	
			    tab1.setContent(table);
			    tab2.setContent(gp);
			    tabPane.getTabs().add(tab1);
			    tabPane.getTabs().add(tab2);
			    bp.setCenter(tabPane);
			    
			    btnBottomA = new Button("New");
			    btnBottomA.setOnAction(e-> {btnBottomA_onAction(e);});
			    btnBottomB = new Button("Confirm");
			    btnBottomB.setDisable(true);
			    btnBottomB.setOnAction(e-> {btnBottomB_onAction(e);});
			    btnBottomC = new Button("Edit");
			    btnBottomC.setOnAction(e-> {btnBottomC_onAction(e);});
			    btnBottomD = new Button("Cancel");
			    btnBottomD.setDisable(true);
			    btnBottomD.setOnAction(e-> {btnBottomD_onAction(e);});
			    btnBottomE = new Button("Delete");
			    btnBottomE.setOnAction(e-> {btnBottomE_onAction(e);});
			    
			    FlowPane pane2 = new FlowPane();
			    pane2.setAlignment(Pos.CENTER);
				pane2.getChildren().add(btnBottomA);
				pane2.getChildren().add(btnBottomB);
				pane2.getChildren().add(btnBottomC);
				pane2.getChildren().add(btnBottomD);
				pane2.getChildren().add(btnBottomE);
				
			    bp.setBottom(pane2);

			    Scene scene = new Scene(bp, 300, 250);
			    
			    scene.getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), new Runnable(){
			    	public void run (){
			    		keywordInput.requestFocus();
			    	}
			    });
			    
			    primaryStage.setScene(scene);
			    primaryStage.show();
			  }
	
	
	    
	
	private void mnuDelete_onAction(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	private void mnuEdit_onAction(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	private void tab1_onSelectionChange(Event e) {
		if (tab1.isSelected() && btnBottomA.isDisabled()) {
			   tabPane.getSelectionModel().select(tab2);
			   Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Diálogo de Informação");
			   alert.setHeaderText("Pesquisa não permitida!");
			   alert.setContentText("Você está editando um registro. Você tem que CONFIRMAR ou CANCELAR sua operação.");
			   alert.showAndWait();
		}
	}




	private void table_onMouseCliked(MouseEvent e) {
		if(e.getClickCount()>=2)
			tabPane.getSelectionModel().select(1);
		
	}




	private void keyword_onAction(KeyEvent e) {
		if(e.getCode()== KeyCode.ENTER)
			tabPane.getSelectionModel().select(0);
		
	}




	private void btnBottomE_onAction(ActionEvent e) {
		setEditable(true);
		
	}




	private void btnBottomD_onAction(ActionEvent e) {
		setEditable(false);
	
	}




	private void btnBottomC_onAction(ActionEvent e) {
		setEditable(true);
		
	}




	private void btnBottomB_onAction(ActionEvent e) {
		setEditable(false);
		
	}




	private void btnBottomA_onAction(ActionEvent e) {
		setEditable(true);
	}
	
	public void setEditable(boolean edit){
		btnBottomA.setDisable(edit);
		btnBottomB.setDisable(!edit);
		btnBottomC.setDisable(edit);
		btnBottomD.setDisable(!edit);
		btnBottomE.setDisable(edit);
		
	}




	public static void main(String[] args){
		launch(args);
	}


}
