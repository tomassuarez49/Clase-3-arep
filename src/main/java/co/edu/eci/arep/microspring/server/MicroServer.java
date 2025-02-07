/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.eci.arep.microspring.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tomas.suarez
 */
public class MicroServer {

    public static Map<String, Method> services = new HashMap();

    public static void main(String[] args) throws Exception {

        loadComponents(args);
        System.out.println(simulateRequests("/greeting"));
        System.out.println(simulateRequests("/pi"));
        System.out.println(simulateRequests("/e"));

    }

    private static void loadComponents(String[] args) throws Exception {
        Class c = Class.forName(args[0]);
        if (!c.isAnnotationPresent(RestController.class)) {
            System.exit(0);
        }
        for (Method m : c.getDeclaredMethods()) {
            if (m.isAnnotationPresent(GetMapping.class)) {
                GetMapping a = m.getAnnotation(GetMapping.class);
                services.put(a.value(), m);

            }
        }

    }

    private static String simulateRequests(String route) throws Exception {
        Method m = services.get(route);
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "\"resp\":\"" + m.invoke(null, "pedro") + "\"}";
        return response;
    }

}
