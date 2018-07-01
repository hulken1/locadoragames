/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrutores;

import java.util.ArrayList;

public class CadastroJogos {
    
    private String txtNomeJogo;
    private String fabricante;
    private String txtQuantidade;
    private String txtGenero;
    private String dataLancamento;
    
    public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public static ArrayList<CadastroJogos> dadosJogos = new ArrayList<>();

    /**
     * @return the txtNomeJogo
     */
    public String getTxtNomeJogo() {
        return txtNomeJogo;
    }

    /**
     * @param txtNomeJogo the txtNomeJogo to set
     */
    public void setTxtNomeJogo(String txtNomeJogo) {
        this.txtNomeJogo = txtNomeJogo;
    }

    /**
     * @return the txtCaracteristicas
     */
 

    /**
     * @return the txtValorJogo

    /**
     * @return the txtQuantidade
     */
  
    /**
     * @return the txtGenero
     */
    public String getTxtGenero() {
        return txtGenero;
    }

    /**
     * @param txtGenero the txtGenero to set
     */
    public void setTxtGenero(String txtGenero) {
        this.txtGenero = txtGenero;
    }

    /**
     * @return the txtQuantidade
     */
    public String getTxtQuantidade() {
        return txtQuantidade;
    }

    /**
     * @param txtQuantidade the txtQuantidade to set
     */
    public void setTxtQuantidade(String txtQuantidade) {
        this.txtQuantidade = txtQuantidade;
    }

    
    
}