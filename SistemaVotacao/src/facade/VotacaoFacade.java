package facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;

import model.Restaurante;
import model.Usuario;
import model.Votacao;
import service.UsuarioService;
import service.VotacaoService;

@ApplicationScoped
@Path("/votacao")
@Produces({ "application/json" })
public class VotacaoFacade {
	
	private List<Votacao> listaVotacao = new ArrayList<Votacao>();

	@Inject
	private Usuario usuarioLogado;

	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private VotacaoService votacaoService;
	
	
	@GET
	@Path("/")
	public List<Usuario> listarTodos() {
		
		return votacaoService.listarTodos();
	}
	
	@GET
	@Path("/listarTodosRestaurantes")
	public List<Restaurante> listarTodosRestaurantes() {
		
		return votacaoService.listarTodosRestaurantes();
	}
	
	@GET
	@Path("/listarVotacao")
	public List<Votacao> listarVotacao() {

		listaVotacao.sort((Votacao o1, Votacao o2) -> o2.getQtd() - o1.getQtd());
		
		return listaVotacao;
	}
	
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/votar")
	public JSONObject votar(Restaurante restaurante){
		Usuario usuario = new Usuario();
		usuario = usuarioLogado;
		boolean existe = false;
		 JSONObject msg = new JSONObject();
		
		
		for(Votacao v : listaVotacao){
			
			if(v.getUsuario().getIdUsuario() == usuario.getIdUsuario()){
				msg.put("msg", "Você já votou !");
				return msg;
			}
			
		}
		
		if(!listaVotacao.isEmpty()){
			for(int i=0; i < listaVotacao.size(); i++){
				
				if(listaVotacao.get(i).getQtd() < 1 ){
					usuario.setJaVotou(true);
					listaVotacao.add(new Votacao(usuario,restaurante,1));
					msg.put("msg", "Voto computado com sucessso !");
					break;
				
					}if(listaVotacao.get(i).getRestaurante().getIdRestaurante() == restaurante.getIdRestaurante()){
						listaVotacao.get(i).setQtd(listaVotacao.get(i).getQtd() +1);
						listaVotacao.get(i).getUsuario().setJaVotou(true);
						existe = true;
						msg.put("msg", "Voto computado com sucessso !");
						break;
					}
				}
			
					 if(!existe){
						usuario.setJaVotou(true);
						listaVotacao.add(new Votacao(usuario,restaurante,1));
						msg.put("msg", "Voto computado com sucessso !");
					}
			
		}else if((usuario != null) && (restaurante != null)){
			usuario.setJaVotou(true);
			listaVotacao.add(new Votacao(usuario,restaurante,1));
			msg.put("msg", "Voto computado com sucessso !");
		}else{
			msg.put("msg", "Ocorreu um erro! ");
		}
		
		
		return msg;
		
	}
	@POST
	@Path("/logar")
	public Usuario logar(Usuario usuario){
		
		usuarioLogado = usuarioService.addUsuario(usuario);
		
		System.out.println(usuarioService.getUsuario().getNome());
		
		return usuarioLogado;
		
	}

}
