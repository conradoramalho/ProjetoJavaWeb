package control;

import model.Cliente;
import model.Empreendimento;
import model.EmpreendimentoDetalhe;
import model.Imobiliaria;
import model.Imovel;
import model.Usuario;
import dao.DaoEmpreendimento;
import dao.DaoEmpreendimentoDetalhe;
import dao.DaoUsuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "CtrEmpreendimento")
@ViewScoped
public class CtrEmpreendimento {
    
	private Empreendimento empreendimento = new Empreendimento();
	private EmpreendimentoDetalhe empreendimentoDetalhe = new EmpreendimentoDetalhe();
	private DataModel listaEmpreendimentos;
	
    DaoEmpreendimento daoEmpreendimento;
    DaoEmpreendimentoDetalhe daoDetalhe;
    
    public CtrEmpreendimento()
    {
        daoEmpreendimento = new DaoEmpreendimento();
        daoDetalhe = new DaoEmpreendimentoDetalhe();
    }
    

    
    
    

    public int gravarEmpreendimento()
    {
        
        try
        {
        	Usuario usuario_cadastro = CtrUsuario.getSessionUsuario();
        	Imobiliaria imobiliaria = usuario_cadastro.getImobiliaria();      	    	
        	empreendimento.setImobiliaria(imobiliaria);
        	empreendimentoDetalhe.setEmpreendimento(empreendimento);
        	empreendimento.setDetalhe(empreendimentoDetalhe);
        	
        	daoEmpreendimento.gravar(empreendimento);
        	daoDetalhe.gravar(empreendimentoDetalhe);
        	RequestContext webcontext = RequestContext.getCurrentInstance();
        	webcontext.execute("PF('succesful-modal').show(); return false"); 
			return 1;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return 2;
        }
    }
    
    
    
   /* public int gravarEmpreendimento (Empreendimento empreendimento)
    {
        
        EmpreendimentoDetalhe detalhe = empreendimento.getDetalhe();
        
        if(detalhe != null)
        {
            daoDetalhe.gravar(detalhe);
        }
        
        try
        {
            daoEmpreendimento.gravar(empreendimento);
            return 1;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return 2;
        }
    }*/
    
    public Integer getCountCondominium()
	{
		return daoEmpreendimento.getAllEmpreendimentos().size();
	}
    
   public DataModel carregarEmpreendimentos ()
    {
        try
        {
        	List<Empreendimento> listEmpreendimentos = daoEmpreendimento.getAllEmpreendimentos();
        	listaEmpreendimentos = new ListDataModel(listEmpreendimentos);
			return listaEmpreendimentos;
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }
       
 /*   public Empreendimento carregarEmpreendimento (int id_empreendimento)
    {
        try
        {
            return (Empreendimento) daoEmpreendimento.carregarUm(id_empreendimento, Empreendimento.class);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
    
       public void alterarEmpreendimento ()
    {
               
        try
        {
        	daoDetalhe.alterar(empreendimentoDetalhe);
            daoEmpreendimento.alterar(empreendimento);
            
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
           
        }
    }
    public Empreendimento getAlterarEmpreendimento()
    {
    	empreendimentoDetalhe = empreendimento.getDetalhe();
    	return empreendimento;
    }
    public void setAlterarEmpreendimento(Empreendimento empreendimento)
    {
    	this.empreendimentoDetalhe = empreendimento.getDetalhe();
    	this.empreendimento = empreendimento;
    }


	public Empreendimento getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}
	public EmpreendimentoDetalhe getEmpreendimentoDetalhe() {
		return empreendimentoDetalhe;
	}

	public void setEmpreendimentoDetalhe(EmpreendimentoDetalhe empreendimentoDetalhe) {
		this.empreendimentoDetalhe = empreendimentoDetalhe;
	}
    
}

