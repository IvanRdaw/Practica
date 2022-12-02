package com.tiernoparla.practica;

import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class Ruiz_Del_Portal_Ivan_Practica1 {
    
    // Se crea el Mensaje random en Array
    static int[] MensajeRandom(int longitud) {
        int nrandom;
        int mensaje[] = new int[longitud];
        for (int i = 0; i < mensaje.length; i++) {
            nrandom = (int) (Math.random() * 2);
            mensaje[i] = nrandom;
        }//for
        return (mensaje);
    }//MensajeRandom
    
    public static void main(String[] args) {
        int[] mensaje;
        
        mensaje = MensajeRandom(10);
        System.out.println(Arrays.toString(mensaje)); 
    } //main
    
    
    
    
    
    
    
    
    
} //Practica1
