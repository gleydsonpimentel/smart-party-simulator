package br.com.novaroma.smartparty.controlador;

import br.com.novaroma.smartparty.dao.IDao;
import br.com.novaroma.smartparty.entities.Manager;
import br.com.novaroma.smartparty.estruturas.Estruturas;
import br.com.novaroma.smartparty.factories.Factory;

public class ControladorManager {

    private IDao dao = Factory.getDao();
    
    public boolean verificarLoginGerente(String login, String senha){
        
        return login.equals("admin") && senha.equals("admin");
    };
    
    public void cadastrarGerente(String name, String cpf, String email, long fone, int age,int anoContratacao){
    
        Manager manager = new Manager(name, cpf, email, fone, age, anoContratacao);
        
        dao.insert(manager, Estruturas.getArvore());
    
    }
    
}
