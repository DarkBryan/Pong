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
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class Pong extends Application {
    final int WORLD_WIDTH = 600;
    final int WORLD_HEIGHT = 400;
     double dirx =  0;
     double diry = 0;
     double gravityY1 = 0;
     double gravityY2 = 0;
     double startpelotax = (WORLD_WIDTH/2)-5;
     double startpelotay = 90;
     double scorej1 = 0;
     double scorej2 = 0;
     int startpala1x = 20;
     
    @Override
    public void start(Stage primaryStage) {
         Group root = new Group();
         Scene scene = new Scene(root, WORLD_WIDTH, WORLD_HEIGHT, Color.BLACK);
         primaryStage.setTitle("Pong FX");
         primaryStage.setScene(scene);
         primaryStage.show();
         
         Rectangle lineacentral = new Rectangle(6, 400);
         lineacentral.setTranslateX(294);
         
         Rectangle pala1 = new Rectangle(10, 50);
         pala1.setTranslateX(20);
         pala1.setTranslateY(90);
         
         Rectangle pala2 = new Rectangle(10, 50);
         pala2.setTranslateX(570);
         pala2.setTranslateY(10);
         
         Circle pelota = new Circle(10,Color.WHITE);
         //pelota.setTranslateX(pelotainicialx);
         //pelota.setTranslateY(100);
         
         lineacentral.setFill(Color.WHITE);
         pala1.setFill(Color.WHITE);
         pala2.setFill(Color.WHITE);
        
         root.getChildren().add(lineacentral);
        
         root.getChildren().add(pala1);
         root.getChildren().add(pala2);
         
         Text score = new Text(String.valueOf(dirx));
         score.setFont(Font.font(STYLESHEET_CASPIAN));
         score.setFill(Color.WHITE);
         root.getChildren().add(score);
         

        
         
         new AnimationTimer() {
            @Override
            public void handle(long now) {
              
                double posx = pelota. getTranslateX();
                double posy = pelota.getTranslateY();
                double posy1 = pala1.getTranslateY();
                double posy2 = pala2.getTranslateY();
                
                pelota.setTranslateY(posy + diry);
                pelota.setTranslateX(posx + dirx);
                pala1.setTranslateY(posy1 + gravityY1);
                pala2.setTranslateY(posy2 + gravityY2);
                //Cambio de direccion al llegar al borde
//                if (posx + dirx <= 5){
//                   dirx = 3;
//                } if (posx + dirx >= 595){
//                   dirx = - 3;
                 if (posy + diry <= 5){
                   diry = 3;
                } if (posy + diry >= 395){
                   diry = - 3;                         
                } if (posy1 + gravityY1 <= 3){
                   gravityY1 = 0; 
                } if (posy1 + gravityY1 >= 348){
                  gravityY1 = 0;
                } if (posy2 + gravityY2 <= 1){
                   gravityY2 = 0; 
                } if (posy2 + gravityY2 >= 348){
                  gravityY2 = 0;
                }
                //Cambio de direccion al tocar la pala
                if (pelota.getTranslateX()+13 <=  pala1.getTranslateX()+33){
                    if (pelota.getTranslateY()+13 >= pala1.getTranslateY()+33 && pelota.getTranslateY() <= pala1.getTranslateY()+50){
                    dirx = 3;
                    }
                }
               
            }
         }.start();

         scene.setOnKeyPressed(new EventHandler<KeyEvent> () {
             @Override
             public void handle(KeyEvent event) {
                  double posy1 = pala1.getTranslateY();
                 switch (event.getCode())  {                  
                     case W:                      
                         if (posy1 + gravityY1 <= 3){
                            gravityY1 = 0; 
                         } else gravityY1 = - 3;
                         break;
                     case S:
  
                         gravityY1 = 3;
                         break;
                     case DOWN:
                         gravityY2 =  3;
                         break;
                     case UP:
                         gravityY2 = - 3;
                         break;    
                     case SPACE:
                         double x = Math.random();
                         double x2 = Math.random();
                         root.getChildren().remove(pelota);
                         root.getChildren().add(pelota);
                         pelota.setTranslateX(startpelotax);
                         pelota.setTranslateY(startpelotay);
                         if (x <=0.5) {
                             dirx = -3;
                         } else {
                             dirx = 3;}
                         if (x2 <= 0.5) {
                            diry = -3;
                         }  else{
                             diry = 3;}
                 }
             }
         } );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Paint Color(double d, double d0, double d1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
