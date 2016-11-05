package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import control.CtrUsuario;
import model.Usuario;

public class DaoUsuario extends DaoGenerico{
    
	public static Usuario getUsuarioByID(int id)
	{
		DaoGenerico daogenerico = new DaoGenerico();
		Object usuario =  daogenerico.carregarUm(id, "id_usuario", Usuario.class);
		return (Usuario)usuario;
		
	}
	
	public static Usuario getUsuarioByEmail(String email)
	{
		DaoGenerico daogenerico = new DaoGenerico();
		Object usuario =  daogenerico.carregarUm(email, "tx_email", Usuario.class);
		return (Usuario)usuario;
	}
	
	public static List  getAllUsuarios()
	{
		HibernateConfiguracao hibernateConfiguracao = new HibernateConfiguracao();
        Session session = hibernateConfiguracao.openSession();
		Query query = session.createQuery("from Usuario as us where us.imobiliaria.id_imobiliaria = " + CtrUsuario.getSessionUsuario().getImobiliaria().getId_imobiliaria());
		List results = query.list();
		return results;

	}
	
}
