import processing.core.PApplet;
import processing.core.PImage;
import java.lang.Math;

public class Sketch extends PApplet {

  // PImage Variables
  PImage desert;
  PImage camel;

  float fltCamelX = -100;
  float fltCamelY = 500;
  float fltCamelSpeedX = 2;
  float fltCamelSpeedY = 1;

  float meteorX = 0;
  float meteorY = 300;
  float xSpeed = 3;
  float ySpeed = 3;

  int intDegrees;


  public void settings() {
    size(1000, 1000);
  }


  public void setup() {
    //loading in the images
    desert = loadImage("desert.png");
    camel = loadImage("image-removebg-preview.png");
  }


  public void draw() {
    //pastes the desert background
    image(desert, 0, 0);

    //draws the camel and the movement of it
    image(camel,fltCamelX,fltCamelY);
    fltCamelX += fltCamelSpeedX;
    fltCamelY += fltCamelSpeedY;
    
    if (fltCamelX > 700 || fltCamelX < -100){
      fltCamelSpeedX *=-1;
    }

    if (fltCamelY > 660 || fltCamelY < 0){
      fltCamelSpeedY *=-1;
    }
    


  // Draws the burning meteor and makes it into a sin wave movement
  ellipse(meteorX, meteorY, 80, 80);
  ellipse(meteorX, meteorY, 70, 70);
  fill(139, 0, 0);
  ellipse(meteorX+12, meteorY-13,10,10);
  ellipse(meteorX-15, meteorY-2, 15, 15);
  ellipse(meteorX+10, meteorY+15, 25, 25);
  fill(255,0,0);

  intDegrees +=1;

  meteorX = meteorX + xSpeed;
  meteorY += 5*cos(radians(intDegrees))+ySpeed;

  if(meteorX < 0 || meteorX > width-50) {
    xSpeed = xSpeed * -1;
  }
  if(meteorY <= 100 || meteorY > height-100) {
    ySpeed = ySpeed * -1;
    
	
  }
}


}