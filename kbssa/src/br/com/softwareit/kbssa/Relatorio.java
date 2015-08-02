package br.com.softwareit.kbssa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Relatorio {

	private Long id; //id do relatorio
	private Date dataHora; //data hora da criação do relatório
	private String comentario; //comentario que a pessoa quiser fazer
	private int intensidade; //intensidade da dor de cabeça, de 0 a 10
	private String username; //nome do usuário
	
	private Locale local = new Locale("pt","BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", local);
	
	@Override
	public String toString() {
		return "Data: " + sdf.format(getDataHora()) + "\n"
				+ "Como " + getUsername() + " estava se sentindo: " + getComentario() + "\n"
				+ "(toque para obter mais detalhes)";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
