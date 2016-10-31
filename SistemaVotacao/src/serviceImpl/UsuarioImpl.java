package serviceImpl;

import javax.inject.Inject;

import dao.UsuarioDao;
import model.Usuario;
import service.UsuarioService;

public class UsuarioImpl implements UsuarioService{

	@Inject
	private UsuarioDao dao;
	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		return dao.addUsuario(usuario);
	}

	@Override
	public Usuario getUsuario() {
		return dao.getUsuario();
	}

}
