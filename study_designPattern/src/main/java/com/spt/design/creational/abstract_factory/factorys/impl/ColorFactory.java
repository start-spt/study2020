package com.spt.design.creational.abstract_factory.factorys.impl;

import com.spt.design.creational.abstract_factory.factorys.AbstractFactory;
import com.spt.design.creational.abstract_factory.colorintf.Color;
import com.spt.design.creational.abstract_factory.colorintf.impl.Blue;
import com.spt.design.creational.abstract_factory.colorintf.impl.Green;
import com.spt.design.creational.abstract_factory.colorintf.impl.Red;
import com.spt.design.creational.abstract_factory.shapeintf.Shape;

public class ColorFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      if(color == null){
         return null;
      }        
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}