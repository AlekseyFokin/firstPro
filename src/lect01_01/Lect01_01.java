/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lect01_01;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Фокин
 * Задание: вызвать методы класса Class1, которые помечены аннотацией Run
 */
public class Lect01_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class <?> class1Class=Class.forName("lect01_01.Class1");
            if (class1Class!=null) 
            {System.out.println("Указанный класс найден!");
            Method[] declaredMethods = class1Class.getDeclaredMethods();
            for (Method meth :declaredMethods)
            {
               Annotation[] declaredAnnotations=meth.getAnnotations();
               System.out.println("Для метода "+meth.getName()+" существуют следующие аннотации в количестве "+declaredAnnotations.length+"  :");
               for (Annotation annot :declaredAnnotations)
               {
                   System.out.println(annot.annotationType().getSimpleName());
                   if (annot.annotationType().getSimpleName().equals("Run"))
                   {System.out.println("Я нашел аннотацию Run!");
                   //Создаю экземпляр класса
                   Object o=class1Class.newInstance();
                   meth.invoke(o);
                   }
               }
            }
            
            }
            } catch (ClassNotFoundException ex) {
            System.out.println("Указанный класс не найден.");
        } catch (InstantiationException ex) {
            System.out.println("Ошибка создания объекта.");
        } catch (IllegalAccessException ex) {
            System.out.println("Ошибка доступа к классу.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Неверный аргумент - объект при вызове метода invoke.");
        } catch (InvocationTargetException ex) {
            System.out.println("Ошибка вызова метода invoke.");
        }
       
    }
    
}
