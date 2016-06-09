package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;
import br.com.novaroma.smartparty.entities.Person;

public class DoubleList {

    private NoDuplo first;
    private NoDuplo last;
    private int quantity;
 
    public void removerQualquerPosicao(int position) {

        if (position == 1) {

            removerNoComeco();

        } else if (position == quantity) {

            removerNoFim();

        } else {
            NoDuplo ant = retornarNo(position - 1);
            NoDuplo prox = retornarNo(position + 1);

            ant.setProx(prox);
            prox.setAnt(ant);
            quantity--;
        }
    }

    public void removerNoComeco() {

        if (listaVazia()) {

            throw new IllegalArgumentException("Não há nada para excluir");

        } else if (quantity == 1) {

            setFirst(null);
            setLast(null);

        } else {

            first = first.getProx();
            first.setAnt(null);

        }

        quantity--;
    }

    public void removerNoFim() {

        if (listaVazia()) {

            throw new IllegalArgumentException("Não há nada para excluir");

        } else if (quantity == 1) {

            setFirst(null);
            setLast(null);
        } else {

            NoDuplo temp = last.getAnt();

            temp.setProx(null);

            setLast(temp);
        }

        quantity--;

    }

    public void inserirNoFim(Entity entity) {

        if (listaVazia()) {

            inserirNoComeco(entity);

        } else {

            NoDuplo novoNo = new NoDuplo(null, last, entity);

            last.setProx(novoNo);
            last = novoNo;

            quantity++;
        }

    }

    public void inserirQualquerPosicao(Entity entity, int position) {

        if (position == 1) {

            inserirNoComeco(entity);

        } else if (position == quantity + 1) {

            inserirNoFim(entity);

        } else {

            NoDuplo ant = retornarNo(position - 1);
            NoDuplo prox = ant.getProx();
            NoDuplo novoNo = new NoDuplo(prox, ant, entity);

            prox.setAnt(novoNo);
            ant.setProx(novoNo);
            quantity++;

        }

    }

    public void inserirNoComeco(Entity entity) {

        NoDuplo novoNo = new NoDuplo(first, null, entity);

        if (!listaVazia()) {

            first.setAnt(first);

        }

        first = novoNo;

        if (listaVazia()) {
            last = first;
        }

        quantity++;

    }

    public String exibirLista() {

        NoDuplo temp = first;
        String nomes = "";

        while (temp != null) {
            if (temp.getEntity() instanceof Person) {
                Person person = (Person) temp.getEntity();

                nomes += person.getName() + " ";
            } else {
                nomes += temp.getEntity().getId() + " ";
            }

            temp = temp.getProx();

        }
        return nomes;
    }

    public String exibirListaReversa() {

        NoDuplo temp = last;
        String nomes = "";

        while (temp != null) {
            if (temp.getEntity() instanceof Person) {
                Person person = (Person) temp.getEntity();

                nomes += person.getName() + " ";
            } else {
                nomes += temp.getEntity().getId() + " ";
            }

            temp = temp.getAnt();
        }

        return nomes;

    }

    public boolean listaVazia() {

        return first == null;
    }

    private void setFirst(NoDuplo first) {
        this.first = first;
    }

    private void setLast(NoDuplo last) {
        this.last = last;
    }

    public int exibirQuantidade() {

        return quantity;
    }

    private NoDuplo retornarNo(int position) {

        if (!verifyPosition(position)) {
            throw new IllegalArgumentException("Posicao invalida!");
        }

        NoDuplo temp = first;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.getProx();
        }
        return temp;

    }

    private boolean verifyPosition(int position) {
        return position > 0 && position <= quantity + 1;
    }

}
