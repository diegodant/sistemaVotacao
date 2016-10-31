package daoImpl;

import javax.inject.Named;

import dao.UsuarioDao;
import model.Usuario;

@Named
public class UsuarioDaoImpl implements UsuarioDao{
	
	private Usuario u;
	
	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		u=usuario;
		return u;
	}

	@Override
	public Usuario getUsuario() {
		return u;
	}

}
