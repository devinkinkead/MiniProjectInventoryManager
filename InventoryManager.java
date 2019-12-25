package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;



public class InventoryManager extends Application {
	
		public void start(Stage primaryStage) {
			primaryStage.show();
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25,25,25,25));
	    
	        Button btn = new Button("Check In");
	        HBox hbBtn = new HBox(10);
	        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	        hbBtn.getChildren().add(btn);
	        grid.add(hbBtn,1,4);
	        
	        
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
			TextField textF = new TextField();
    		//Need another set on action.
    		textF.setPromptText("SKU: ");
    		String test = textF.getText();
    		Label label = new Label("Please Type SKU...");
    		// Will definitely want to make a method...
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER_LEFT);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25,25,25,25));
    		
	        Button btn = new Button("Submit");
	        HBox hbBtn = new HBox(10);
	        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	        hbBtn.getChildren().add(btn);
	        grid.add(hbBtn,1,4);
	        
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	        	
	        	@Override
	        	public void handle(ActionEvent e) {
	        		Label label2 = new Label();
	        		label2.setText(textF.getText());
	        		grid.add(label2,0,4);
	        	}
	        
	        
	        });
	        
	        
    		grid.add(label,0,0);
    		grid.add(textF,0,1);
    		Scene scene2 = new Scene(grid,300,300);
    		primaryStage.setScene(scene2);
		}
		
		

		
		
		 public static void main(String[] args) {
		       launch(args);
		    }
	}

