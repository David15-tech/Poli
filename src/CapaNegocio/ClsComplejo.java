/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author USER
 */
public class ClsComplejo {
    //Atributos de la clase
    
    private int numReal;
    private int numImaginario;
    private String oper;

    
    //Ingresamos los Contructores para nuestra clase
    
    public ClsComplejo(int numReal, int numImaginario, String oper) {
        this.numReal = numReal;
        this.numImaginario = numImaginario;
        this.oper = oper;
    }
    
    public ClsComplejo(ClsComplejo num){
        numReal = num.numReal;
        numImaginario = num.numImaginario; 
    }
    
    public ClsComplejo(){
        numReal = 0;
        numImaginario = 0;
    }

    
    
    //Metodos de acceso a las variables
    public int getNumReal() {
        return numReal;
    }
    public int getNumImaginario() {
        return numImaginario;
    }
    public String getOper() {
        return oper;
    }
    
    
    
    //Metodos de modificacion a las variables
    public void setNumReal(int numReal) {
        this.numReal = numReal;
    }
    public void setNumImaginario(int numImaginario) {
        this.numImaginario = numImaginario;
    }
    public void setOper(String oper) {
        this.oper = oper;
    }
    
    
    
    //Imprimira la expresion mas adecuada
    
    public String toString(){
        String expr;
        if(numImaginario==0 && numReal==0){
            expr="0";
        }
        else{
            if(numImaginario==0){
                expr=numReal+"";
            }
            if(numReal==0){
                expr=numImaginario+"";
            }else{
                if("-".equals(oper))
                    expr= numReal+" "+" "+numImaginario+"i";
                else
                    expr= numReal+" "+oper+" "+numImaginario+"i";
            }
        }
        return expr;
    }
    
    //Metodos para operar a los Complejos
    
    public ClsComplejo sumar(ClsComplejo c){
        ClsComplejo res = new ClsComplejo();
        res.numImaginario = c.numImaginario+numImaginario;
        res.numReal = c.numReal+numReal;
        return res;
    }
    
    public ClsComplejo restar(ClsComplejo c){
        ClsComplejo res = new ClsComplejo();
        res.numImaginario = numImaginario-c.numImaginario;
        res.numReal = numReal-c.numReal;
        return res;
    }
    
    public ClsComplejo multiplicar(ClsComplejo c){
        ClsComplejo res = new ClsComplejo();
        res.numImaginario = numReal*c.numImaginario+numImaginario*c.numReal;
        res.numReal = c.numReal*numReal-numImaginario*c.numImaginario;
        return res;
    }
    
    public ClsComplejo dividir(ClsComplejo c){
        ClsComplejo res = new ClsComplejo();
        res.numImaginario = (numImaginario*c.numReal-numReal*c.numImaginario)
                            /(c.numImaginario*c.numImaginario+c.numReal*c.numReal);
        res.numReal = (c.numReal*numReal+numImaginario*c.numImaginario)
                      /(c.numImaginario*c.numImaginario+c.numReal*c.numReal);
        return res;
    }
    
    
    
}
