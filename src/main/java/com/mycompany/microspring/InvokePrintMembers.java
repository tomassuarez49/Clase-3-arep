/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.microspring;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author tomas.suarez
 */
public class InvokePrintMembers {
    
    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[]{Member[].class, String.class};
            
            Method m = c.getDeclaredMethod("PrintMembers", argTypes);
            
            Class otraClase = LinkedList.class;
            
            
            System.out.format("invoking %s.printMembers()%n", c.getName());
            m.invoke(null, otraClase.getDeclaredFields(), "Fields");
            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    
}
