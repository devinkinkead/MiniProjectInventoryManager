package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;



public class InventoryManager extends Application {
		private InventorySystem inv = new InventorySystem();
		public void start(Stage primaryStage) {
			
			primaryStage.show();
	        GridPane grid = new GridPane();
	        Utilities.paneSet(grid);
	    
	        Button btn = new Button("Check In");
	        HBox hBox = new HBox(10);
	        hBox.setAlignment(Pos.BOTTOM_RIGHT);
	        hBox.getChildren().add(btn);
	        grid.add(hBox,1,4);
	        
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	
	        	@Override
	        	public void handle(ActionEvent e) {
	        		CheckIn(primaryStage);
	        	}
	        
	        });
	        
	        
	        
	        
	        Scene scene = new Scene(grid,300,300);
	        
	        primaryStage.setScene(scene);
	    }
		
		
		public void CheckIn(Stage primaryStage) {
			// New Window for CheckIn
			Scene scene2 = new Scene(new Group());
			
			
			//Create Table Columns
			
			TableView table = new TableView();
			Label tLabel = new Label("Devices Available to Check In");
			table.setEditable(true);
			TableColumn numCol = new TableColumn("#");
	        TableColumn skuCol = new TableColumn("SKU");
	        TableColumn nameCol = new TableColumn("Name");
	        TableColumn statusCol = new TableColumn("Status");
	        
	        table.getColumns().addAll(numCol,skuCol,nameCol,statusCol);
		
	        
			// Create textField (Device #)
	        TextField textF = new TextField();
	        
    		//Need another set on action.
			inv.printDeviceList();
    		textF.setPromptText("Please Type Device#");
    		
    		
    		
    		
	        
	       // HBox (for Device Entry)
	        HBox hBox = new HBox();
	        
	        // Create Submit Button
	        Button btn = new Button("Submit");
	        hBox.getChildren().addAll(textF,btn);
	        hBox.setSpacing(3);
	        
	        
	        // Vbox setup (For Table...And adding Device Entry)
	        VBox vbox = new VBox(); vbox.setSpacing(5); 
			vbox.setPadding(new Insets(10, 0,0, 10)); 
			vbox.getChildren().addAll(tLabel, table,hBox);
	        
    		
	        // Put Vbox into the Scene
	        ((Group) scene2.getRoot()).getChildren().addAll(vbox);
    		
    		// Place Scene into the GUI
    		primaryStage.setScene(scene2);
    		primaryStage.setTitle("Device Check In");
    		primaryStage.show();
    		
    		
    		// Process Input in Text Field when Submit Button is pushed
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	
	        	@Override
	        	public void handle(ActionEvent e) {
	        		
	        		String device = textF.getText();
	        		
//	        		inv.checkIn(device);
	        		
	        		
	        	}
	        
	        });
	        
	        
		}
		
		

		
		
		 public static void main(String[] args) {
		       launch(args);
		    }
	}

