package Contrutores;

import javax.swing.table.DefaultTableModel;

public class Acoes {

    public void clientes(String nomeCliente,String cpfCliente,String enderecoCliente,
    		String nEndereco,
           String nResidencial,
            String nCelular) {

        Clientes c = new Clientes();
        c.setTxtNomeCliente(nomeCliente);
        c.setTxtCPF(cpfCliente);
        c.setTxtEnderecoCliente(enderecoCliente);
        c.setTxtNumeroEndereco(nEndereco);
        c.setTxtNumeroRes(nResidencial);
        c.setTxtCelular(nCelular);

        Clientes.dadosClientes.add(c);
    }

        public DefaultTableModel listarClientes() {

        //DefaultTableModel
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("DataNascimento");
        modelo.addColumn("Endereco");
        modelo.addColumn("Nº");               
        modelo.addColumn("CEP");
        modelo.addColumn("Telefone");
        modelo.addColumn("Celular");
       

        for (int indice = 0; indice < Clientes.dadosClientes.size(); indice++) {

            modelo.addRow(new Object[]{
                Clientes.dadosClientes.get(indice).getTxtNomeCliente(),
                Clientes.dadosClientes.get(indice).getTxtCPF(),
                Clientes.dadosClientes.get(indice).getTxtDataNascimento(),
                Clientes.dadosClientes.get(indice).getTxtEnderecoCliente(),  
                Clientes.dadosClientes.get(indice).getTxtNumeroEndereco(),
                Clientes.dadosClientes.get(indice).getTxtCep(),
                Clientes.dadosClientes.get(indice).getTxtNumeroRes(),
                Clientes.dadosClientes.get(indice).getTxtCelular()
               

            });

        }

        //Retorno
        return modelo;
    }
        
            public void jogos(String nomeJogo , String fabricante , String quantidadeJogo , String genero,String dataLancamento){
        
        CadastroJogos cj = new CadastroJogos();
        cj.setTxtNomeJogo(nomeJogo);
        cj.setFabricante(fabricante);
        cj.setDataLancamento(dataLancamento);
        cj.setTxtQuantidade(quantidadeJogo);
        cj.setTxtGenero(genero);
        
        CadastroJogos.dadosJogos.add(cj);
    }
           public DefaultTableModel listaDeJogos() {
        	   
        	       
        	        DefaultTableModel modeloListaJogo = new DefaultTableModel();
        	        modeloListaJogo.addColumn("Jogo");
        	        for (int indice = 0; indice < CadastroJogos.dadosJogos.size(); indice++) {
        	        	modeloListaJogo.addRow(new Object[]{
        	                    CadastroJogos.dadosJogos.get(indice).getTxtNomeJogo()
        	                    
        	            });
        	        }
        	          
        	        return modeloListaJogo;     
        	   
           }
         public DefaultTableModel listarJogos(){       
    
        DefaultTableModel modeloJogo = new DefaultTableModel();
        modeloJogo.addColumn("Nome Jogo");
        modeloJogo.addColumn("Fabricante");
        modeloJogo.addColumn("Data Lançamento");
        modeloJogo.addColumn("Quantidade");
        modeloJogo.addColumn("Genero");
        
        for (int indice = 0; indice < CadastroJogos.dadosJogos.size(); indice++) {
        modeloJogo.addRow(new Object[]{
                CadastroJogos.dadosJogos.get(indice).getTxtNomeJogo(),
                CadastroJogos.dadosJogos.get(indice).getFabricante(),
                CadastroJogos.dadosJogos.get(indice).getDataLancamento(),
                CadastroJogos.dadosJogos.get(indice).getTxtQuantidade(),
                CadastroJogos.dadosJogos.get(indice).getTxtGenero()
            });
        }
          
        return modeloJogo;
     }
         public void alterarCliente(String nomeCliente,String cpfCliente,String dataNascimento, String enderecoCliente,
        		 String nEndereco,
            String cepCliente, String nResidencial,
            String nCelular,  int linha){
             
              Clientes c = new Clientes();
            c.setTxtNomeCliente(nomeCliente);
            c.setTxtCPF(cpfCliente);
            c.setTxtDataNascimento(dataNascimento);
            c.setTxtEnderecoCliente(enderecoCliente);
            c.setTxtNumeroEndereco(nEndereco);          
            c.setTxtCep(cepCliente);
        	c.setTxtNumeroRes(nResidencial);
        	c.setTxtCelular(nCelular);
        	
        
        Clientes.dadosClientes.set(linha,c);
         }
         
         public void excluiCliente(int linha){
             Clientes.dadosClientes.remove(linha);
         }
         public void alterarJogo(String nomeJogo,String fabricante , String dataLancamento,String quantidade,String genero,int linha) {
        	 
        	 CadastroJogos c = new CadastroJogos();
        	 c.setTxtNomeJogo(nomeJogo);
        	 c.setFabricante(fabricante);
        	 c.setDataLancamento(dataLancamento);
        	 c.setTxtQuantidade(quantidade);
        	 c.setTxtGenero(genero);
        	 CadastroJogos.dadosJogos.set(linha,c);
        	 
         }
         public void excluirJogo(int linha) {
        	 CadastroJogos.dadosJogos.remove(linha);
         }
         public void locacao(String nomeCliente, String nomeJogo, int dias,String valor) {
        	 Locacao l = new Locacao();
        	 
        	l.setNomeCliente(nomeCliente);
        	l.setNomeJogo(nomeJogo);
        	l.setDias(dias);
        	l.setValor(valor);
        	
        	
        	Locacao.dadosLocacao.add(l);
        	
         }
         public DefaultTableModel listaLocacao(){       
        	    
             DefaultTableModel locacao = new DefaultTableModel();
             locacao.addColumn("Nome Cliente");
             locacao.addColumn("Nome Jogo");
             locacao.addColumn("Dias");
             locacao.addColumn("Valor");
             
             
             for (int indice = 0; indice < Locacao.dadosLocacao.size(); indice++) {
            	 locacao.addRow(new Object[]{
            			 Locacao.dadosLocacao.get(indice).getNomeCliente(),
            			 Locacao.dadosLocacao.get(indice).getNomeJogo(),
            			 Locacao.dadosLocacao.get(indice).getDias(),
            			 Locacao.dadosLocacao.get(indice).getValor()
                     
                 });
             }
               
             return locacao;
          }
         public void alteraLoca(String nomeCliente, String nomeJogo, int dias,int linha) {
        	 Locacao l = new Locacao();
        	 
        	l.setNomeCliente(nomeCliente);
        	l.setNomeJogo(nomeJogo);
        	l.setDias(dias);
        	
        	Locacao.dadosLocacao.set(linha,l);
        	
         }
         public void devolver(int linha){
             Locacao.dadosLocacao.remove(linha);
         }
}

    
    
