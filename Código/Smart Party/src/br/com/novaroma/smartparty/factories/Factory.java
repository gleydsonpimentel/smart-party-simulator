package br.com.novaroma.smartparty.factories;

import br.com.novaroma.smartparty.dao.Dao;
import br.com.novaroma.smartparty.dao.IDao;

public class Factory {

    public static IDao getDao(){
        return new Dao();
    }
    
}
