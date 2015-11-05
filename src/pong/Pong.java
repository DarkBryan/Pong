/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class Pong extends Application {
    final int WORLD_WIDTH = 600;
    final int WORLD_HEIGHT = 400;
    @Override
    public void start(Stage primaryStage) {
         Group root = new Group();
         Scene scene = new Scene(root, WORLD_WIDTH, WORLD_HEIGHT, Color.BLACK);
         primaryStage.setTitle("Pong FX");
         primaryStage.setScene(scene);
         primaryStage.show();
         
         Rectangle marciano1 = new Rectangle(200, 10, 30, 20);
         Circle pelota = new Circle(200, 20, 10);
         pelota.setFill(Color.YELLOW);
         marciano1.setFill(Color.WHITE);
         root.getChildren().add(pelota);
      
         new AnimationTimer() {
            @Override
            public void handle(long now) {
                double posx = pelota. getTranslateX();
                posx--;
                pelota.setTranslateX(posx);
                
                if (posx < 1) {
                    posx++;
                    pelota.setTranslateX(posx);
                }
            
            }
         }.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
