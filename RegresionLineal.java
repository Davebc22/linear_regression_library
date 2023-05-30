/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.PredictionDAO;

public class RegresionLineal {
    
    
   double regresion;
    double sumX = 0;
    double sumY = 0;
    double meanX=0;
    double meanY=0;
    double numerador = 0;
    double denominador = 0;
    public double b;
    public double a;
    private double[] inputX;
    private double[] outputY;
    
    
    
        public RegresionLineal (double[][] data ){
            this.inputX = data[0];
            this.outputY = data[1];

        }
        
        public RegresionLineal(){}

        private  void medias() {
    
            for (double value : inputX) {
            sumX+=(value/2);
             }
            meanX = sumX / inputX.length;
            for (double value2 : outputY) {
            sumY+=(value2/2);
            meanY= sumY / inputX.length;
            }


        }
    
    
        private double coeficientesPendientes(){
            
            medias();

            for (int i = 0; i < inputX.length; i++) {
            numerador +=(inputX[i]-meanX)*(outputY[i]-meanY);
            denominador += (Math.pow(inputX[i]-meanX,2));
            
            }
            b = numerador/denominador;
            a= meanY-(b*(meanX));  
            return b;
            }
         
     
         
        public double formulaRegresionLineal(double x) {
         
            medias();
            coeficientesPendientes();
            double rValue= 0;
            rValue = a+(b*x);
            return rValue;

            }
        
        
 
        
        public boolean guardar(double input, double output){
             PredictionDAO ob = new PredictionDAO();
             boolean resultado = ob.crear(String.valueOf(input), String.valueOf(output));
             return resultado;
        } 
         
        
}