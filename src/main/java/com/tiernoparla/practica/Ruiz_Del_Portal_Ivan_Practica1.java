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
    
    public static void main(String[] args) {
        int[] mensaje;
        int[] bitsnecesarios;
        int[] sender;
        
        mensaje = MensajeRandom(10);
        System.out.println(Arrays.toString(mensaje));

        bitsnecesarios = Bitsnecesarios(mensaje);
        System.out.println(Arrays.toString(bitsnecesarios));
        
        sender = Sendermedio(mensaje);
        System.out.println(Arrays.toString(sender));
    } //main

} //Practica1
