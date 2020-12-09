package com.spt.design.creational.abstract_factory.colorintf.impl;

import com.spt.design.creational.abstract_factory.colorintf.Color;

public class Blue implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}