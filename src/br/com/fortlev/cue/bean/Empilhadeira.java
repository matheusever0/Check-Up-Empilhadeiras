package br.com.fortlev.cue.bean;

import java.sql.Date;


/**
 *
 * @author matheus.s
 */
public class Empilhadeira {
    private int id; 
    private int numeroEmp;
    private int numeroDeSerie;
    private String modelo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroEmp() {
        return numeroEmp;
    }

    public void setNumeroEmp(int numeroEmp) {
        this.numeroEmp = numeroEmp;
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public Empilhadeira() {
    }

    public Empilhadeira(int id, int numeroEmp, int numeroDeSerie, String modelo) {
        this.id = id;
        this.numeroEmp = numeroEmp;
        this.numeroDeSerie = numeroDeSerie;
        this.modelo = modelo;
    }

    
    
    
    
    }
    
    

