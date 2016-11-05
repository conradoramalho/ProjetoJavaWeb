package control;
import dao.DaoImovel;
import dao.DaoImovelCaptacao;
import dao.DaoImovelDetalhe;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Cliente;
import model.Empreendimento;
import model.Imobiliaria;
import model.Imovel;
import model.ImovelCaptacao;
import model.ImovelDetalhe;
import model.Usuario;

import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;


@ManagedBean(name = "CtrImovel")
@ViewScoped
public class CtrImovel {
	
	private static Imovel imovel = new Imovel();
	private ImovelDetalhe imoveldetalhe = new ImovelDetalhe();
    private ImovelCaptacao imovelcaptacao = new ImovelCaptacao();
    private static Cliente clienteImovel = new Cliente();
	private DataModel listaImoveis;

    
    static DaoImovel daoImovel;
    DaoImovelCaptacao daoCaptacao;
    DaoImovelDetalhe daoDetalhe;
    
    public CtrImovel () {
       
        daoImovel = new DaoImovel();
        daoCaptacao = new DaoImovelCaptacao();
        daoDetalhe = new DaoImovelDetalhe();
        
    }
    
    public String prepararAlterarImovel(){
    	setImovel((Imovel)(listaImoveis.getRowData()));
    	return "alterar_imovel";
    }
    
 /*   public int gravarImovel (Imovel imovel)
    {
        ImovelCaptacao captacao = imovel.getCaptacao();
        
        if(captacao != null)
        {
            daoCaptacao.gravar(captacao);
        }
        
        ImovelDetalhe detalhe = imovel.getDetalhe();
        
        if(detalhe != null)
        {
            daoDetalhe.gravar(detalhe);
        }
        
        try
        {
            daoImovel.gravar(imovel);
            return 1;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return 2;
        }
    } */
    
    public String gravarImovel()
    {
    	 try
         {
         	Usuario usuario_cadastro = CtrUsuario.getSessionUsuario();
         	imovel.setCliente(clienteImovel);
         	imovel.setUsuario(usuario_cadastro);
         	imovel.setDetalhe(imoveldetalhe);
         	imovel.setCaptacao(imovelcaptacao);
         	
         	imoveldetalhe.setImovel(imovel);
         	imovelcaptacao.setImovel(imovel);
         	

         	daoImovel.gravar(imovel);
         	daoDetalhe.gravar(imoveldetalhe);
         	daoCaptacao.gravar(imovelcaptacao);
         	
         	RequestContext webcontext = RequestContext.getCurrentInstance();
        	webcontext.execute("PF('succesful-modal').show(); return false"); 			
        	return null;
         }
         catch (HibernateException e)
         {
             e.printStackTrace();
             return "";
         }
    }
    public static void selecionarCliente(Cliente cliente)
    {
       clienteImovel   = cliente;
    }
    
    public Integer getCountProperty()
	{
		return daoImovel.getAllImoveis().size();
	}
    
    public DataModel carregarImoveis ()
    {
        try
        {
        	List<Imovel> listImoveis = daoImovel.getAllImoveis();
        	listaImoveis = new ListDataModel(listImoveis);
			return listaImoveis;
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    /* Imovel carregarImovel (int id_imovel)
    {
        try
        {
            return (Imovel) daoImovel.carregarUm(id_imovel, Imovel.class);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
    
    public void alterarImovel ()
    {
    	try{
        
            imovel.setCliente(clienteImovel);
            daoCaptacao.alterar(imovelcaptacao);       
            daoDetalhe.alterar(imoveldetalhe);          
            daoImovel.alterar(imovel);
            
    	}
        catch (HibernateException e)
        {
            e.printStackTrace();
            
        }
    }
    public Imovel getImovel()
    {
    	return imovel;
    }
    public void setImovel(Imovel imovel)
    {
    	this.imovel = imovel;
    }

	public ImovelDetalhe getImoveldetalhe() {
		return imoveldetalhe;
	}

	public void setImoveldetalhe(ImovelDetalhe imoveldetalhe) {
		this.imoveldetalhe = imoveldetalhe;
	}

	public ImovelCaptacao getImovelcaptacao() {
		return imovelcaptacao;
	}

	public void setImovelcaptacao(ImovelCaptacao imovelcaptacao) {
		this.imovelcaptacao = imovelcaptacao;
	}
	
    public Imovel getImovelAlterar()
    {   clienteImovel = imovel.getCliente();
    	this.imovelcaptacao = imovel.getCaptacao();
    	this.imoveldetalhe = imovel.getDetalhe();
    	return imovel;
    }
    public void setImovelAlterar(Imovel imovel)
    { 	this.imovelcaptacao = imovel.getCaptacao();
    	this.imoveldetalhe = imovel.getDetalhe();
    	this.imovel = imovel;
    }
    public static void setAlterarcliente(Cliente cliente) {
    	clienteImovel = cliente;
    	imovel.setCliente(clienteImovel);
    	daoImovel.alterar(imovel);
    }
 
  

}
