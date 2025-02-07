/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.eci.arep.microspring.server;

/**
 *
 * @author tomas.suarez
 */
@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public static String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hola " + name;
    }
    
    @GetMapping("/pi")
    public static String pi(@RequestParam(value = "name", defaultValue = "val") String name) {
        return Double.toString(Math.PI);
    }
    
    
}
