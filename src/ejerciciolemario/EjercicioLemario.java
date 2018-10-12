/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciolemario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xp
 */
public class EjercicioLemario {

      HashMap <String, Boolean> listaPalabras = new HashMap();
    
      
      
      public static String limpia(String cadena){
	String valor ="";
	if (cadena !=null) {
         valor = cadena;
        valor = valor.toUpperCase();
         }
        return valor;
        }
        
    public void cargaFicheroLemario()
    {
        File fichero = new File("src/ejerciciolemario/lemario-20101017.txt");
      
        try 
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null)
            {
               
                listaPalabras.put(limpia(linea.toUpperCase()),true);
            } 
            
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(EjercicioLemario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(EjercicioLemario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public boolean buscar(String palabra)
    {
        if(listaPalabras.containsKey(palabra))
        {
            return true;
        }
        return false;
    }
    
    public boolean escalera(String[] palabras){
	boolean escaleraPalabras = true;
	int contadorDiferentes;
	for(int i = 0; i<palabras.length-1 &&escaleraPalabras; i++){
	    contadorDiferentes = 0;
	    if(palabras[i].length()==palabras[i+1].length()){
		if(buscar(limpia(palabras[i].toUpperCase()))&&buscar(limpia(palabras[i+1].toUpperCase()))){
		    for(int j = 0; j<palabras[i].length(); j++){
			if(limpia(palabras[i].toUpperCase()).charAt(j)!= limpia(palabras[i+1].toUpperCase()).charAt(j)){
			contadorDiferentes++;
			}
		    }   
		}
		else{
		    return false;
		}
		if(contadorDiferentes!=1){
		   escaleraPalabras = false;
		}
	    }
	    else{
		escaleraPalabras = false;
		return escaleraPalabras;
	    }
	}
	return escaleraPalabras;
    }
    
   
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EjercicioLemario test = new EjercicioLemario();
	test.cargaFicheroLemario();
	
	
	System.out.println("busca palabra");
	System.out.println(test.buscar("aba"));
	System.out.println("");
        
        
	System.out.println("Escalera palabras");
	String[] prueba1 = {"pata", "pato", "rato", "gato", "gata"};
	System.out.println(test.escalera(prueba1));
	System.out.println("");
	
	;
    }
    
        
    
}
