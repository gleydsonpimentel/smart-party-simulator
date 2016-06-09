
package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;

public class Fila {

    private Entity fila[];
    private int first;
    private int last;
    private int quantity;

    public Fila() {
        fila = new Entity[50];
    }

    public Fila(int length) {
        fila = new Entity[length];
    }

    public void toQueue(Entity entity) {

        if (!filaCheia()) {
            fila[last] = entity;
            last++;
            quantity++;

            if (last >= fila.length) {
                last = 0;
            }
        }
    }

    public void dequeue() {

        if (!filaVazia()) {
            fila[first] = null;
            first++;
            quantity--;

            if (first >= fila.length) {
                first = 0;
            }
        }
    }

    public String verPrimeiro() {

        String primeiroNome = "";

        if (!filaVazia()) {
            primeiroNome = fila[first].getId();
        }

        return primeiroNome;
    }

    public String verFila() {

        String fullQueue = "";
        int temp = first;

        if (!filaVazia()) {
            for (int i = 0; i < quantity; i++) {
                fullQueue += fila[temp].getId() + " ";
                temp++;

                if (temp >= fila.length) {
                    temp = 0;
                }
            }
        }

        return fullQueue;
    }

    private boolean filaVazia() {
        return quantity == 0;
    }

    private boolean filaCheia() {
        return quantity == fila.length;
    }
    
    public Entity search(String id) {
       
        Entity entityX = null;
        int temp = first;
        
         if (!filaVazia()) {
            for (int i = 0; i < quantity; i++) {
                if (id.equalsIgnoreCase(fila[temp].getId())) {
                    entityX = fila[temp];
                }
                temp++;

                if (temp >= fila.length) {
                    temp = 0;
                }
            }
        }
        
        return entityX;
    }
    
    public void update(Entity entity) {
        
         int temp = first;
        
         if (!filaVazia()) {
            for (int i = 0; i < quantity; i++) {
                if (entity.getId().equalsIgnoreCase(fila[temp].getId())) {
                    fila[temp] = entity;
                }
                temp++;

                if (temp >= fila.length) {
                    temp = 0;
                }
            }
        }
    }
}

