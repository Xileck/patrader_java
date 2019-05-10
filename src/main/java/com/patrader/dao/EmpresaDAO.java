package com.patrader.dao;

public class EmpresaDAO {
    private static EmpresaDAO ourInstance = new EmpresaDAO();

    public static EmpresaDAO getInstance() {
        return ourInstance;
    }

    private EmpresaDAO() {
    }


}
