package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.jboss.logging.Logger;
import org.primefaces.context.RequestContext;

import dao.DaoUsuario;
import dao.SessionContext;
import model.Imobiliaria;
import model.Imovel;
import model.Usuario;

@ManagedBean(name = "CtrUsuario")
@ViewScoped
public class CtrUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	DaoUsuario context;
	private static Logger logger = Logger.getLogger(Usuario.class);
	
	private DataModel listaUsuarios;
	private Usuario usuario;	
	private Imobiliaria imobiliaria;
	
	public CtrUsuario() 
	{
		context = new DaoUsuario();
		usuario = new Usuario();
		imobiliaria = new Imobiliaria();
	}

	public String prepararAlterarUsuario(){
		usuario = (Usuario)listaUsuarios.getRowData();
    	return "alterar_usuario.xhtml?faces-redirect=true";
    }

	public String gravarUsuario() 
	{			
	
		RequestContext webcontext = RequestContext.getCurrentInstance();
		try 
		{	
			
			if(DaoUsuario.getUsuarioByEmail(usuario.getTx_email()) == null)
			{
				ArrayList<Usuario> usuarios = new ArrayList();
				usuario.setImobiliaria(imobiliaria);
				usuarios.add(usuario);	
				imobiliaria.setUsuarios(usuarios);
				context.gravar(imobiliaria);		
				webcontext.execute("PF('succesful-modal').show(); return false");
				return null;
			}
			else
			{				
				webcontext.execute("PF('fail-modal').show(); return false");
				return null;
				
			}
			
			
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public String gravarUsuarioSoaProject() 
	{
		try 
		{	
			RequestContext webcontext = RequestContext.getCurrentInstance();
			
			if(DaoUsuario.getUsuarioByEmail(usuario.getTx_email()) == null)
			{
				usuario.setImobiliaria(CtrUsuario.getSessionUsuario().getImobiliaria());
				context.gravar(usuario);
				webcontext.execute("PF('succesful-modal').show(); return false");
				return null;
			}
			else
			{
				webcontext.execute("PF('fail-modal').show(); return false");
				return null;
				
			}
			
			
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return "";
		}
	}

	public Integer getCountUser()
	{
		return context.getAllUsuarios().size();
	}

	public DataModel carregarUsuarios() 
	{
		try 
		{
			List<Usuario> listUsuarios = context.getAllUsuarios();
			listaUsuarios = new ListDataModel(listUsuarios);
			return listaUsuarios;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	public void alterarUsuario() 
	{
		try 
		{
			context.alterar(usuario);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public String verificarLogin() 
	{
		try 
		{
			 logger.info("Tentando logar com usuário " + usuario.getTx_email());

			if(StringUtils.isNotEmpty(usuario.getTx_email()) && StringUtils.isNotEmpty(usuario.getTx_senha()))		
			{
				usuario = context.verificaLogin(usuario.getTx_email(), usuario.getTx_senha(), Usuario.class);
				if (usuario == null) 
				{
					usuario = new Usuario();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login/Senha não cadastrado!", null));				
					return null;
				} 
				else 
				{
					logger.info("Login efetuado com sucesso");
		            SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
					return "main";
				}
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Preencha os campos corretamente!", null));	
				return null;
			}
			

		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	
	public static Usuario getSessionUsuario()
	{
		return SessionContext.getInstance().getUsuarioLogado();
	}

	public String LogoutUsuario() {
		
		SessionContext.getInstance().encerrarSessao();
		return "index";
	}
	
	public Usuario getUsuario() 
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario) 
	{
		this.usuario = usuario;
	}

	public Imobiliaria getImobiliaria() {
		return imobiliaria;
	}

	public void setImobiliaria(Imobiliaria imobiliaria) {
		this.imobiliaria = imobiliaria;
	}

}
