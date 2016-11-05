package control;
import dao.DaoCliente;
import dao.DaoUsuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import model.Cliente;
import model.Empreendimento;
import model.Usuario;

import control.CtrUsuario;

import org.hibernate.HibernateException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "CtrCliente")
@ViewScoped
public class CtrCliente {
	
	private Cliente cliente = new Cliente();
	
	private DataModel listaClientes;
	
    DaoCliente daoCliente;

    
    public CtrCliente()
    {
        daoCliente = new DaoCliente();

    }
    
    public String prepararAlterarCliente(){
    	setCliente((Cliente)(listaClientes.getRowData()));
    	return "alterar_cliente";
    }

    public String gravarCliente ()
    {
        
        try
        {
        	Usuario usuario_cadastro = CtrUsuario.getSessionUsuario();
        	cliente.setUsuario(usuario_cadastro);
        	daoCliente.gravar(cliente);
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
    
    public Integer getCountCostumer()
	{
		return daoCliente.getAllClientes().size();
	}
    
    public DataModel carregarClientes ()
    {
        try
        {
        	List<Cliente> listClientes = daoCliente.getAllClientes();
        	listaClientes = new ListDataModel(listClientes);
			return listaClientes;
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
  /*  public Cliente carregarCliente (int id_cliente)
    {
        try
        {
            return (Cliente) daoCliente.carregarUm(id_cliente, Cliente.class);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
    
     public void alterarCliente ()
    {
        try
        {
            daoCliente.alterar(cliente);
           
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        
        }
    }
    
    public Cliente getCliente()
    {
    	return cliente;
    }
    
    public void setCliente(Cliente cliente)
    {
    	this.cliente = cliente;
    }
    
   
    public void onRowSelect(SelectEvent event) {
    	cliente = (Cliente)event.getObject();
    	CtrImovel.selecionarCliente(cliente);
       }
    public void setAtualizarProprietario(SelectEvent event) {
    //	Cliente cliente = (Cliente)event.getObject();
    	CtrImovel.setAlterarcliente(cliente);
       }
  
}
