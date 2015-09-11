package br.com.softwareit.kbssa.modelo;

public class Configs {

	private String emailUsuario;
	private String nomeMedico;
	private String emailMedico;
	
	public Configs(String emailUsuario, String nomeMedico, String emailMedico) {
		this.emailMedico = emailMedico;
		this.nomeMedico = nomeMedico;
		this.emailUsuario = emailUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}
	
	
}
