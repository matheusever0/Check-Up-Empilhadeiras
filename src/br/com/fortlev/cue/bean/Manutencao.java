package br.com.fortlev.cue.bean;

import java.util.Date;

/**
 *
 * @author matheus.s
 */
public class Manutencao {
    private int id; 
    private String tipoDeServico;
    private Date data;
    private int horimetro;
    private int horimetroManutencao;
    private String empilha;
    private String pecasUtilizadas;
    private String responsavel;

    public Manutencao() {
    }
    
    public Manutencao(int id, String tipoDeServico, Date data, int horimetro, int horimetroManutencao, String empilha, String pecasUtilizadas, String responsavel) {
        this.id = id;
        this.tipoDeServico = tipoDeServico;
        this.data = data;
        this.horimetro = horimetro;
        this.horimetroManutencao = horimetroManutencao;
        this.empilha = empilha;
        this.pecasUtilizadas = pecasUtilizadas;
        this.responsavel = responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHorimetro() {
        return horimetro;
    }

    public void setHorimetro(int horimetro) {
        this.horimetro = horimetro;
    }

    public int getHorimetroManutencao() {
        return horimetroManutencao;
    }

    public void setHorimetroManutencao(int horimetroManutencao) {
        this.horimetroManutencao = horimetroManutencao;
    }

    public String getEmpilha() {
        return empilha;
    }

    public void setEmpilha(String empilha) {
        this.empilha = empilha;
    }

    public String getPecasUtilizadas() {
        return pecasUtilizadas;
    }

    public void setPecasUtilizadas(String pecasUtilizadas) {
        this.pecasUtilizadas = pecasUtilizadas;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    
    
    
    
}
