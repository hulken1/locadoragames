package Contrutores;

public class Login {
	public boolean validarLogin(String nomeUsuario, String senhaUsuario) {
		
		boolean existe = false;
		
		if((nomeUsuario.equals("admin")) && (senhaUsuario.equals("123"))) {
			existe = true;
		}
		
		return existe;
	}
	
	
	public int retornarNivel() {
		return 1;
	}
	
}
