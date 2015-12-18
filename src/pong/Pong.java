/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
     int scorej1 = 0;
     int scorej2 = -1;
     int startpala1x = 20;
     String marcador1 = String.valueOf(scorej1);
     String marcador2 = String.valueOf(scorej2);
    @Override
    public void start(Stage primaryStage) {
         Group root = new Group();
         Scene scene = new Scene(root, WORLD_WIDTH, WORLD_HEIGHT, Color.BLACK);
         primaryStage.setTitle("Pong FX");
         primaryStage.setScene(scene);
         primaryStage.show();
         
         Rectangle lineacentral = new Rectangle(6, 400);
         lineacentral.setTranslateX(293);
         
         Rectangle pala1 = new Rectangle(10, 50);
         pala1.setTranslateX(20);
         pala1.setTranslateY(100);
         
         Rectangle pala2 = new Rectangle(10, 50);
         pala2.setTranslateX(570);
         pala2.setTranslateY(100);
         
         Circle pelota = new Circle(10,Color.WHITE);
         //pelota.setTranslateX(pelotainicialx);
         //pelota.setTranslateY(100);
         
         lineacentral.setFill(Color.WHITE);
         pala1.setFill(Color.WHITE);
         pala2.setFill(Color.WHITE);
        
         root.getChildren().add(lineacentral);
        
         root.getChildren().add(pala1);
         root.getChildren().add(pala2);
         
         Text score1 = new Text(220,60,marcador1);
         score1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
         score1.setFill(Color.GREY);
         root.getChildren().add(score1);
         
         Text score2 = new Text(340,60,marcador2);
         score2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
         score2.setFill(Color.GREY);
         root.getChildren().add(score2);
         
         
         new AnimationTimer() {
            @Override
            public void handle(long now) {
              
                double posx = pelota. getTranslateX();
                double posy = pelota.getTranslateY();
                double posxpala1 = pala1.getTranslateX();
                double posxpala2 = pala2.getTranslateX();
                double posypala1 = pala1.getTranslateY();
                double posypala2 = pala2.getTranslateY();
                
                pelota.setTranslateY(posy + diry);
                pelota.setTranslateX(posx + dirx);
                pala1.setTranslateY(posypala1 + gravityY1);
                pala2.setTranslateY(posypala2 + gravityY2);
                //Reinicio si no choca en las palas
                if (posx + dirx <= 5){
                       double x = Math.random();
                       double x2 = Math.random();
                       pelota.setTranslateX(startpelotax);
                       pelota.setTranslateY(startpelotay);    
                      scorej2++;
                      marcador2 = String.valueOf(scorej2);
                       score2.setText(marcador2);
                } if (posx + dirx >= 595){
                        double x = Math.random();
                        double x2 = Math.random();
                        pelota.setTranslateX(startpelotax);
                        pelota.setTranslateY(startpelotay);
                        scorej1++;
                        marcador1 = String.valueOf(scorej1);
                        score1.setText(marcador1);
                }
                //Rebote bordes superior e inferior
                 if (posy + diry <= 5){
                   diry = 3;
                } if (posy + diry >= 395){
                   diry = - 3;                         
                }
                //Limite de movimiento de las palas
                if (posypala1 + gravityY1 <= 5){
                   gravityY1 = 0; 
                } if (posypala1 + gravityY1 >= 345){
                  gravityY1 = 0;
                }
                
                if (posypala2 + gravityY2 <= 5){
                   gravityY2 = 0; 
                } if (posypala2 + gravityY2 >= 345){
                  gravityY2 = 0;
                }
                //Cambio de direccion al tocar la pala
                if (posx + 13 <=  posxpala1+33){
                    if (posy >= posypala1-33 && posy <= posypala1+50){
                        dirx = 3;
                    }
                } 
                if (posx-13 >=  posxpala2-23){
                    if (posy >= posypala2-33 && posy <= posypala2+50){
                    dirx = -3;
                    }
                } 
               
            }
         }.start();

         scene.setOnKeyPressed(new EventHandler<KeyEvent> () {
             @Override
             public void handle(KeyEvent event) {
                 double posy1 = pala1.getTranslateY();
                 double posy2 = pala2.getTranslateY();
                 switch (event.getCode())  {                  
                     case W:                      
                         if (posy1 + gravityY1 <= 5){
                            gravityY1 = 0; 
                         } else {
                             gravityY1 = - 5;
                         }
                         break;
                     case S:
                        if (posy1 + gravityY1 >= 345){
                            gravityY1 = 0;
                        } else
                            gravityY1 = 5;
                         break;
                     case DOWN:
                         if (posy2 + gravityY2 >= 345){
                            gravityY2 = 0;
                          } else gravityY2 =  5;
                         break;
                     case UP:
                          if (posy2 + gravityY2 <= 5){
                              gravityY2 = 0; 
                          } else gravityY2 = - 5;
                         break;    
                     case SPACE:
                         scorej1 = 0;
                         marcador1 = String.valueOf(scorej1);
                         score1.setText(marcador1);
                         scorej2 = 0;
                         marcador2 = String.valueOf(scorej2);
                         score2.setText(marcador2);
                         double x = Math.random();
                         double x2 = Math.random();
//                         root.getChildren().remove(pelota);
//                         root.getChildren().add(pelota);
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
                          break;
                     case U:
                         scorej2++;
                         marcador2 = String.valueOf(scorej2);
                         score2.setText(marcador2);
                         break;
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
