package br.com.novaroma.smartparty.dao;

import br.com.novaroma.smartparty.entities.Entity;
import br.com.novaroma.smartparty.estruturas.*;


public interface IDao {

    
    void insert(Entity entity, Arvore arvore);
    void insert(Entity entity, List doubleList);
    void insert(Entity entity, Fila fila);
    void insert(Entity entity, Pilha pilha);

    void delete(String id, Arvore arvore);
    void delete(String id, List doubleList);
    void delete(Fila fila);   
    void delete(Pilha pilha);
    
    void update(Entity entity, Arvore arvore);
    void update(Entity entity, List doubleList);
    void update(Entity entity, Fila fila);
    void update(Entity entity, Pilha pilha);

    Entity search(String id, Arvore arvore);
    Entity search(String id, List doubleList);
    Entity search(String id, Fila fila);
    Entity search(String id, Pilha pilha);
    
}
