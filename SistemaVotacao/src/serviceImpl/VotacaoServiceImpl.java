package serviceImpl;

import java.util.List;

import javax.inject.Inject;

import dao.VotacaoDao;
import model.Restaurante;
import model.Usuario;
import service.VotacaoService;


public class VotacaoServiceImpl implements VotacaoService{
	
	@Inject
	private VotacaoDao dao;


	@Override
	public List<Usuario> listarTodos() {

		return dao.listar();
	}


	@Override
	public List<Restaurante> listarTodosRestaurantes() {
		return dao.listarTodosRestaurantes();
	}

}
