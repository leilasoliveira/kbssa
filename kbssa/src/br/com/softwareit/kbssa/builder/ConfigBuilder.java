package br.com.softwareit.kbssa.builder;

import br.com.softwareit.kbssa.modelo.Configs;

public class ConfigBuilder {

	private String emailUsuario;
	private String nomeMedico;
	private String emailMedico;
	
	public ConfigBuilder emailDoUsuario(String emailDoUsuario){
		this.emailUsuario = emailDoUsuario;
		return this;
	}
	
	public ConfigBuilder emailDoMedico(String emailDoMedico){
		this.emailMedico = emailDoMedico;
		return this;
	}
	
	public ConfigBuilder nomeDoMedico(String nomeDoMedico){
		this.nomeMedico = nomeDoMedico;
		return this;
	}
	
	public Configs build(){
		return new Configs(emailUsuario, nomeMedico, emailMedico);
	}
	
}
