package com.patrader;

import com.patrader.dto.Desecho.Desecho;
import com.patrader.dto.Desecho.DesechoSolido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger logger = LogManager.getLogger(Test.class);


    public static void main(String[] args) {
        DesechoSolido d = new DesechoSolido();
        d.setPeso2(2.0d);
        printPeso(d);

    }

    public static void printPeso(Desecho desecho) {

        System.out.println( ((DesechoSolido) desecho).getPeso2());
    }

    public static String notacionCientifica(Float flotante) {
        return String.format("%6.3e", flotante);
    }
}