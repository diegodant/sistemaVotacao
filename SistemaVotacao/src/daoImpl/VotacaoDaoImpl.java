package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.VotacaoDao;
import model.Restaurante;
import model.Usuario;

public class VotacaoDaoImpl implements VotacaoDao {

	private List<model.Restaurante> listaRestaurante = new ArrayList<Restaurante>();

	private List<Usuario>listaUsuario = new ArrayList<Usuario>();
	

	@Override
	public List<Usuario> listar() {
		listaUsuario.clear();
		
		listaUsuario.add(new Usuario(1,"João"));
		listaUsuario.add(new Usuario(2,"Maria"));
		listaUsuario.add(new Usuario(3,"Pedro"));
		listaUsuario.add(new Usuario(4,"Joana"));
		listaUsuario.add(new Usuario(5,"Rebeca"));
		
		return listaUsuario;
	}
	
	@Override
	public List<Restaurante> listarTodosRestaurantes() {
		listaRestaurante.clear();
		
		
		listaRestaurante.add(new Restaurante(1,"Beluga"));
		listaRestaurante.add(new Restaurante(2,"Churrascaria Majórica"));
		listaRestaurante.add(new Restaurante(3,"La Mole"));
		listaRestaurante.add(new Restaurante(4,"OutBack"));
		listaRestaurante.add(new Restaurante(5,"Sabor de Casa"));
		listaRestaurante.add(new Restaurante(6,"Frontera"));
		listaRestaurante.add(new Restaurante(7,"Kimura"));
		listaRestaurante.add(new Restaurante(8,"Mauá"));
		listaRestaurante.add(new Restaurante(9,"Cruzeiro do Sul"));
		listaRestaurante.add(new Restaurante(10,"Bakers"));
		
		return listaRestaurante;
	}



}
