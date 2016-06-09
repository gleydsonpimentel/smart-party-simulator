package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;

//VER HERANCA DEPOIS!

public class NoArvore {

    private NoArvore left;
    private NoArvore right;
    private int height;
    private Entity entity;
    
    public NoArvore (Entity entity) {
        this.entity = entity;
    }
    public NoArvore (Entity entity, NoArvore left, NoArvore right) {
        this.entity = entity;
        this.left = left;
        this.right = right;
    }

    public NoArvore getLeft() {
        return left;
    }

    public void setLeft(NoArvore left) {
        this.left = left;
    }

    public NoArvore getRight() {
        return right;
    }

    public void setRight(NoArvore right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
