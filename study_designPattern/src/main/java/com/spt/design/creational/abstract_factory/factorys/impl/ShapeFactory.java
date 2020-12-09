package com.spt.design.creational.abstract_factory.factorys.impl;

import com.spt.design.creational.abstract_factory.factorys.AbstractFactory;
import com.spt.design.creational.abstract_factory.colorintf.Color;
import com.spt.design.creational.abstract_factory.shapeintf.Shape;
import com.spt.design.creational.abstract_factory.shapeintf.impl.Circle;
import com.spt.design.creational.abstract_factory.shapeintf.impl.Rectangle;
import com.spt.design.creational.abstract_factory.shapeintf.impl.Square;

public class ShapeFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }        
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      return null;
   }
}