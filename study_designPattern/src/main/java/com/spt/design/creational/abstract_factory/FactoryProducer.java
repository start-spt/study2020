package com.spt.design.creational.abstract_factory;

import com.spt.design.creational.abstract_factory.factorys.AbstractFactory;
import com.spt.design.creational.abstract_factory.factorys.impl.ColorFactory;
import com.spt.design.creational.abstract_factory.factorys.impl.ShapeFactory;

public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}