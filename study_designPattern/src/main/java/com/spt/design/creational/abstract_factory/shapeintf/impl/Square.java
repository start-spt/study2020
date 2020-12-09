package com.spt.design.creational.abstract_factory.shapeintf.impl;

import com.spt.design.creational.abstract_factory.shapeintf.Shape;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}