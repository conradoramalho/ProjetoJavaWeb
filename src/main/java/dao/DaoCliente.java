package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import control.CtrUsuario;

public class DaoCliente extends DaoGenerico{
	
	public static List  getAllClientes()
	{
		HibernateConfiguracao hibernateConfiguracao = new HibernateConfiguracao();
        Session session = hibernateConfiguracao.openSession();
		Query query = session.createQuery("from Cliente as cli where cli.usuario.imobiliaria.id_imobiliaria = " + CtrUsuario.getSessionUsuario().getImobiliaria().getId_imobiliaria());
		List results = query.list();
		return results;

	}
    
}
