package com.spt.design.creational.abstract_factory.factorys;

import com.spt.design.creational.abstract_factory.colorintf.Color;
import com.spt.design.creational.abstract_factory.shapeintf.Shape;

public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}