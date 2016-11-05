package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import control.CtrUsuario;

public class DaoEmpreendimento extends DaoGenerico{
	
	public static List getAllEmpreendimentos()
	{
		HibernateConfiguracao hibernateConfiguracao = new HibernateConfiguracao();
        Session session = hibernateConfiguracao.openSession();
		Query query = session.createQuery("from Empreendimento as emp where emp.imobiliaria.id_imobiliaria = " + CtrUsuario.getSessionUsuario().getImobiliaria().getId_imobiliaria());
		List results = query.list();
		return results;

	}
    
}
