package com.example.demoESB.entities;


import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "idcliente")
    private Integer idCliente;
    @Column(name = "nombre")
    private String empresaCliente;
    @Column(name = "ruc")
    private String empresaRUC;
    @Column(name = "pais")
    private String pais;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getEmpresaCliente() {
        return empresaCliente;
    }

    public void setEmpresaCliente(String empresaCliente) {
        this.empresaCliente = empresaCliente;
    }

    public String getEmpresaRUC() {
        return empresaRUC;
    }

    public void setEmpresaRUC(String empresaRUC) {
        this.empresaRUC = empresaRUC;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
