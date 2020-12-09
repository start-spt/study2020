package com.spt.design.creational.factory.infc.impl;

import com.spt.design.creational.factory.infc.Shape;

public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}