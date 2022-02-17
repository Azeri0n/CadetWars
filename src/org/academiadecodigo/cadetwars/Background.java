package org.academiadecodigo.cadetwars;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Background {

      public static final int PADDING = 10;
      private Picture picture;


      public Background(String resource){
          picture = new Picture(PADDING, PADDING, resource);
          picture.draw();
      }

      public int getWidth(){
          return picture.getWidth();
      }

  }

