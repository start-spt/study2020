package com.spt.design.creational.factory.infc.impl;

import com.spt.design.creational.factory.infc.Shape;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}