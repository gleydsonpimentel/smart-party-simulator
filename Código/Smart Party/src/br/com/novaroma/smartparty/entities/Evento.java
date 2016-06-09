package br.com.novaroma.smartparty.entities;


public class Evento extends Entity {

    private String id;
    private String atracao;
    private int pessoasExtimadas;
    private int pessoasNoEvento;
    private double valorIngresso;
    
    
    public Evento(String id, String atracao, int pessoasExtimadas, double valorIngresso) {
        this.id = id;
        this.atracao = atracao;
        this.pessoasExtimadas = pessoasExtimadas;
        this.valorIngresso = valorIngresso;
        this.pessoasNoEvento=0;
    }

    public Evento(String id, int pessoasExtimadas, double valorIngresso) {
        this.id = id;
        this.pessoasExtimadas = pessoasExtimadas;
        this.valorIngresso = valorIngresso;
        this.atracao="Não houveram atrações";
        this.pessoasNoEvento=0;
    }

    public Evento(String id, String atracao, double valorIngresso) {
        this.id = id;
        this.atracao = atracao;
        this.valorIngresso = valorIngresso;
        this.pessoasExtimadas=0;
        this.pessoasNoEvento=0;
    }

    public Evento(String id, double valorIngresso) {
        this.id = id;
        this.valorIngresso = valorIngresso;
        this.atracao="Não Houveram atrações";
        this.pessoasExtimadas=0;
        this.pessoasNoEvento=0;
    }

    public Evento() {
    
    }
    
    public int getPessoasNoEvento() {
        return pessoasNoEvento;
    }

    public void setPessoasNoEvento(int pessoasNoEvento) {
        this.pessoasNoEvento = pessoasNoEvento;
    }    
    
    public String getAtracao() {
        return atracao;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public int getPessoasExtimadas() {
        return pessoasExtimadas;
    }

    public void setPessoasExtimadas(int pessoasExtimadas) {
        this.pessoasExtimadas = pessoasExtimadas;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }
    
    @Override
    public String getId() {
        return id;
    }

}
