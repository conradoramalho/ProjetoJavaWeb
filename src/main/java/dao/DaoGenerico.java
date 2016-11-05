package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Usuario;

public class DaoGenerico {
    
    protected HibernateConfiguracao hibernateConfiguracao;
    
    public DaoGenerico () 
    {
        hibernateConfiguracao = new HibernateConfiguracao();
    }
    
    public void gravar(Object obj) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(obj);
        
        transaction.commit();
        
        session.close();
    }
    
    public void alterar(Object obj) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Object novobj = (Object)session.merge(obj); 
        Transaction transaction = session.beginTransaction();
        
        session.update(novobj);
       
        transaction.commit();
        session.clear();
        session.close();
    }
    
    public void excluir(Object obj) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(obj);
        
        transaction.commit();
        
        session.close();
    }
    
    public List carregarTudoOrdenado(Class clas, String ordem) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Criteria criteria = session.createCriteria(clas);
        
        criteria.addOrder(Order.asc(ordem));

        List lista = criteria.list();
        
        session.close();
        
        return lista;
    }
    
    public Object carregarUm(int id, String  pk_entidade, Class<?> clas) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(clas);
        criteria.add(Restrictions.eq(pk_entidade, id));
        criteria.setMaxResults(1);

        
        Object obj = criteria.uniqueResult();
        
        transaction.commit();
        
        session.close();
        
        return obj;
    }
    
    public Object carregarUm(String value , String  field, Class<?> clas) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(clas);
        criteria.add(Restrictions.eq(field, value));
        criteria.setMaxResults(1);
        
        Object obj = criteria.uniqueResult();
        
        transaction.commit();
        
        session.close();
        
        return obj;
    }
    
    public Usuario verificaLogin(String tx_email,String tx_senha, Class<?> clas) throws HibernateException 
    {
        Session session = hibernateConfiguracao.openSession();
        Transaction transaction = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(clas);
        criteria.add(Restrictions.eq("tx_email", tx_email));
        criteria.add(Restrictions.eq("tx_senha", tx_senha));
        criteria.add(Restrictions.eq("fl_ativo", Boolean.TRUE));
        
        Object obj = criteria.uniqueResult();
        
        transaction.commit();
        
        session.close();
        
        return (Usuario)obj;
    }
}
