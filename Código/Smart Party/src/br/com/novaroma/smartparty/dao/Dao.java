package br.com.novaroma.smartparty.dao;

import br.com.novaroma.smartparty.entities.Entity;
import br.com.novaroma.smartparty.estruturas.*;


public class Dao implements IDao{

    @Override
    public void insert(Entity entity, Arvore arvore) {
        arvore.insert(entity);
    }

    @Override
    public void insert(Entity entity, List list) {
        list.addLast(entity);
    }

    @Override
    public void insert(Entity entity, Fila fila) {
        fila.toQueue(entity);
    }

    @Override
    public void insert(Entity entity, Pilha pilha) {
        pilha.empilhar(entity);
    }

    @Override
    public void delete(String id, Arvore arvore) {
        arvore.delete(id);
    }

    @Override
    public void delete(String id, List list) {
        list.removeBetween(list.searchPosition(id));
    }

    @Override
    public void delete(Fila fila) {
        fila.dequeue();
    }

    @Override
    public void delete(Pilha pilha) {
        pilha.desempilhar();
    }

    @Override
    public void update(Entity entity, Arvore arvore) {
        arvore.update(entity);
    }

    @Override
    public void update(Entity entity, List list) {
        list.update(entity);
    }

    @Override
    public void update(Entity entity, Fila fila) {
        fila.update(entity);
    }

    @Override
    public void update(Entity entity, Pilha pilha) {
        pilha.update(entity);
    }

    @Override
    public Entity search(String id, Arvore arvore) {
        return arvore.search(id).getEntity();
    }

    @Override
    public Entity search(String id, List list) {
        return list.returnLink(list.searchPosition(id)).getEntity();
    }

    @Override
    public Entity search(String id, Fila fila) {
        return fila.search(id);
    }

    @Override
    public Entity search(String id, Pilha pilha) {
        return pilha.search(id);
    }
    
}
