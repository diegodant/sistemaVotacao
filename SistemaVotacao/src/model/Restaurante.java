package model;

public class Restaurante {
	
	private Integer idRestaurante;
	private String nomeRestaurante;
	
	
	
	public Restaurante() {
		super();
	}
	public Restaurante(Integer idRestaurante, String nomeRestaurante) {
		super();
		this.idRestaurante = idRestaurante;
		this.nomeRestaurante = nomeRestaurante;
	}
	public Integer getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public String getNomeRestaurante() {
		return nomeRestaurante;
	}
	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRestaurante == null) ? 0 : idRestaurante.hashCode());
		result = prime * result + ((nomeRestaurante == null) ? 0 : nomeRestaurante.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		if (idRestaurante == null) {
			if (other.idRestaurante != null)
				return false;
		} else if (!idRestaurante.equals(other.idRestaurante))
			return false;
		if (nomeRestaurante == null) {
			if (other.nomeRestaurante != null)
				return false;
		} else if (!nomeRestaurante.equals(other.nomeRestaurante))
			return false;
		return true;
	}
	
	
	

}
