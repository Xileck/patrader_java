package com.patrader;

import com.patrader.dao.BitacoraErrorDAO;
import com.patrader.dto.Desecho;
import com.patrader.dto.DesechoSolido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    private static final Logger logger = LogManager.getLogger(Test.class);


    public static void main(String[] args) {

        //BitacoraErrorDAO.getInstance().insertarBitacoraError2("test","test2","test");
        BitacoraErrorDAO.getInstance().insertBitacoraError("","","");

    }

    public static void printPeso(Desecho desecho) {

    }

    public static String notacionCientifica(Float flotante) {
        return String.format("%6.3e", flotante);
    }
}