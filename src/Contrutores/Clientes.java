/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrutores;

import java.util.ArrayList;

public class Clientes {
    private String txtNomeCliente;
    private String txtEnderecoCliente;
    private String txtCPF;
    private String txtDataNascimento;
    private String txtCep;
    private String txtNumeroRes;
    private String txtCelular;
    private String txtNumeroEndereco;
    
    public static ArrayList<Clientes> dadosClientes = new ArrayList<>();

    /**
     * @return the txtNomeCliente
     */
    public String getTxtNomeCliente() {
        return txtNomeCliente;
    }

    /**
     * @param txtNomeCliente the txtNomeCliente to set
     */
    public void setTxtNomeCliente(String txtNomeCliente) {
        this.txtNomeCliente = txtNomeCliente;
    }

    /**
     * @return the txtEnderecoCliente
     */
    public String getTxtEnderecoCliente() {
        return txtEnderecoCliente;
    }

    /**
     * @param txtEnderecoCliente the txtEnderecoCliente to set
     */
    public void setTxtEnderecoCliente(String txtEnderecoCliente) {
        this.txtEnderecoCliente = txtEnderecoCliente;
    }

    /**
     * @return the txtCPF
     */
    public String getTxtCPF() {
        return txtCPF;
    }

    /**
     * @param txtCPF the txtCPF to set
     */
    public void setTxtCPF(String txtCPF) {
        this.txtCPF = txtCPF;
    }

    /**
     * @return the txtDataNascimento
     */
    public String getTxtDataNascimento() {
        return txtDataNascimento;
    }

    /**
     * @param txtDataNascimento the txtDataNascimento to set
     */
    public void setTxtDataNascimento(String txtDataNascimento) {
        this.txtDataNascimento = txtDataNascimento;
    }

    /**
     * @return the txtCep
     */
    public String getTxtCep() {
        return txtCep;
    }

    /**
     * @param txtCep the txtCep to set
     */
    public void setTxtCep(String txtCep) {
        this.txtCep = txtCep;
    }

    /**
     * @return the txtNumeroRes
     */
    public String getTxtNumeroRes() {
        return txtNumeroRes;
    }

    /**
     * @param txtNumeroRes the txtNumeroRes to set
     */
    public void setTxtNumeroRes(String txtNumeroRes) {
        this.txtNumeroRes = txtNumeroRes;
    }

    /**
     * @return the txtCelular
     */
    public String getTxtCelular() {
        return txtCelular;
    }

    /**
     * @param txtCelular the txtCelular to set
     */
    public void setTxtCelular(String txtCelular) {
        this.txtCelular = txtCelular;
    }

    /**
     * @return the txtNumeroEndereco
     */
    public String getTxtNumeroEndereco() {
        return txtNumeroEndereco;
    }

    /**
     * @param txtNumeroEndereco the txtNumeroEndereco to set
     */
    public void setTxtNumeroEndereco(String txtNumeroEndereco) {
        this.txtNumeroEndereco = txtNumeroEndereco;
    }

}
