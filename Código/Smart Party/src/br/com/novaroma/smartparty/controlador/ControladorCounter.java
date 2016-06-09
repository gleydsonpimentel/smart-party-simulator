package br.com.novaroma.smartparty.controlador;

import br.com.novaroma.smartparty.dao.IDao;
import br.com.novaroma.smartparty.factories.Factory;

public class ControladorCounter {

    private IDao dao = Factory.getDao();
    
    public boolean verificarLoginContador(String login, String senha){
        
        return login.equals("admin") && senha.equals("admin");
    }
    
}
