/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class Conexion {
    
    double [] inputX;
    double [] outputY;
    
    public double [][] conexionExcel() throws IOException, InvalidFormatException {
        String filePath = "C:\\Users\\daveb\\Documents\\NetBeansProjects\\TP2\\src\\datosmuestra.xlsx";
        String sheetName = "Hoja1";
        int columnX = 0; // Número de columna para la variable X (empezando desde 0)
        int columnY = 1; // Número de columna para la variable Y (empezando desde 0)

        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() + 1;
            
            inputX = new double[rowCount];
            outputY = new double[rowCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
             
                           
                 System.out.println("Valor X: " + row.getCell(columnX) + ", Valor Y: " + row.getCell(columnY));
                // Obtener inputX y outputY desde las celdas correspondientes
                double x = Double.parseDouble(row.getCell(columnX).toString());
                double y = Double.parseDouble(row.getCell(columnY).toString());

                // Guardar los valores en los arreglos
                inputX[i] = x;
                outputY[i] = y;
             
            }

       
        } catch (IOException e) {
            
            System.out.println(e);
        }
        return new double[][]{ inputX, outputY };
    }
}
