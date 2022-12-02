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
        return mensaje;
    }//MensajeRandom

    //Busca la cantidad de bits necesarios para el mensaje
    static int[] Bitsnecesarios(int[] mensaje) {
        int nbits;
        double p = 1;
        while (Math.pow(2, p) < p + mensaje.length + 1) {
            p++;
        } //for
        nbits = (int) p;
        //System.out.println(nbits);
        int[] bitsnecesarios = new int[nbits + mensaje.length + 1];
        return bitsnecesarios;
    } //sender

    //añade el mensaje a la Array y pone 2 en cada bit de redundancia
    static int[] Sendermedio(int[] mensaje) {
        int posibit = 0;
        int posimens = 0;
        int[] sender = Bitsnecesarios(mensaje);
        for (int i = 1; i < sender.length; i++) {
            if (i == Math.pow(2, posibit)) {
                sender[i] = 2;
                posibit++;
            } //if
            else {
                sender[i] = mensaje[posimens++];
            } //else
        } //for
        return sender;
    }//sendermedio
    
    //busca que bits de mensaje tiene que comparar con cada bit de redundancia
    static int[] Senderfinal(int[] mensaje, int bitsnecesarios, int[] senderfinal) {
        int posibit;
        int bitssuma;
        int[] bitstotales = new int[bitsnecesarios];
        for (posibit = 0; posibit < bitsnecesarios; posibit++) {
            int bitr = (int) Math.pow(2,posibit);
                if (posibit == Math.pow(2, posibit)) {
                    for(int j = 0; j < mensaje.length; j++){
                        int bittemp = bitr & j;
                        if(bittemp == bitr){
                            bitssuma = mensaje[j];
                        } //if  
                    } //for
                    bitssuma = bitstotales[posibit];
                } //if
        } //for
        return senderfinal;
    } //Senderfinal
    
    //calcula en cada bit de redundancia y global si pone 0 o 1
    static int[] Senderfinal2(int[] mensaje, int bitstotales, int[] senderfinal2){
        for(int i = 0; i < bitstotales; i++){
            if (Senderfinal % 2 = 0){
                mensaje (int) [Math.pow(2,i)] = 0;
            } //if
            else (Senderfinal % 2 = 1){
                mensaje (int) [Math.pow(2,i)] = 1;
            } //else
            if (Senderfinal % 2 = 0){
                mensaje[0] = 0;
            } //if
            else (Senderfinal % 2 = 1){
                mensaje[0] = 1;
            } //else
        } //for
        return senderfinal2;
    } //Senderfinal2
    
    //genera 0, 1 o 2 cambios random al sender
    static int[] CambiosRandom(int[] noiser) {
        int nmodificaciones = (int) (Math.random() * 3);
        int xposiciones;
        System.out.println("Se han realizado " + nmodificaciones + " modificacion/es");
        for (int i = 0; i < nmodificaciones; i++) {
            xposiciones = (int) (Math.random() * noiser.length);
            if (noiser[xposiciones] == 0) {
                noiser[xposiciones] = 1;
            } //if
            else {
                noiser[xposiciones] = 0;
            } //else
        } //for
        return (noiser);
    }//CambiosRandom
    
    public static void main(String[] args) {
        int[] mensaje;
        int[] bitsnecesarios;
        int[] sender;
        int[] senderfinal2;
        int[] noiser;
        
        mensaje = MensajeRandom(10);
        System.out.println(Arrays.toString(mensaje));

        bitsnecesarios = Bitsnecesarios(mensaje);
        System.out.println(Arrays.toString(bitsnecesarios));
        
        sender = Sendermedio(mensaje);
        System.out.println(Arrays.toString(sender));
        
        //senderfinal2 = Senderfinal2(mensaje);
        //System.out.println(Arrays.toString(senderfinal2);
        
        noiser = CambiosRandom (sender);
        System.out.println(Arrays.toString(noiser));
    } //main

} //Practica1
