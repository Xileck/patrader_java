package com.patrader;

import com.patrader.dao.BitacoraErrorDAO;
import com.patrader.dto.Desecho;

public class Test {


    public static void main(String[] args) {

        BitacoraErrorDAO.getInstance().insertBitacoraError("","","");

    }

    public static void printPeso(Desecho desecho) {

    }

    public static String notacionCientifica(Float flotante) {
        return String.format("%6.3e", flotante);
    }
}