package model;

public class Votacao {
	
	private Usuario usuario;
	private Restaurante restaurante;
	private Integer qtd;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public Votacao(Usuario usuario, Restaurante restaurante, Integer qtd) {
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.qtd = qtd;
	}
	public Votacao() {
	}
	
	

}
