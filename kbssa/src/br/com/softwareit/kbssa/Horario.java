package br.com.softwareit.kbssa;

public enum Horario {

	MANHA("Manhã"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String descricao;
	
	private Horario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
