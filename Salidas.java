/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Conexion.Conexion;
import Logica.RegresionLineal;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Salidas {
    public static double obtenerValorX() {
        String input = JOptionPane.showInputDialog(null, "Ingresa un valor para predecir");
        System.out.println( Double.parseDouble(input));
        return Double.parseDouble(input);
    }

    public void mostrarResultado() throws IOException, InvalidFormatException {
        Conexion ob1 = new Conexion();
        ob1.conexionExcel();
        Conexion conexion = new Conexion();
        double[][] data = conexion.conexionExcel();
        RegresionLineal regresionLineal = new RegresionLineal(data);    

        String input = JOptionPane.showInputDialog(null, "Ingresa un valor para predecir");
        System.out.println(Double.parseDouble(input));
        double x = Double.parseDouble(input);
        double respuesta = regresionLineal.formulaRegresionLineal(x);
        RegresionLineal regresionLineal2 = new RegresionLineal();
        regresionLineal2.guardar(respuesta, x);
        System.out.println("El valor de la pendiente b= " +regresionLineal.b);
        System.out.println("El valor de la intersección a= " +regresionLineal.a);
        System.out.println("La predicción para x = " + x + " da como respuesta y: " + respuesta );
        JOptionPane.showMessageDialog(null, "Guardado en bases de datos con éxito");
        
        
    
    }
    
    
    


    }