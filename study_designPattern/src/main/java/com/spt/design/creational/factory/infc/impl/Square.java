package com.spt.design.creational.factory.infc.impl;

import com.spt.design.creational.factory.infc.Shape;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}