package com.spt.design.creational.abstract_factory.colorintf.impl;

import com.spt.design.creational.abstract_factory.colorintf.Color;

public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}