package dao;

import java.util.List;

import model.Restaurante;
import model.Usuario;

public interface VotacaoDao {
	

	 List<Usuario> listar();
	 List<Restaurante> listarTodosRestaurantes();

	

}
