package com.learning.spring.workshop.boot.sample;

public class SimpleMessage {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }
   public String getMessage(){
      return this.message;
   }
}