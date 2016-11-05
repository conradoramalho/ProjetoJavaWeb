package control;
import dao.DaoImobiliaria;
import model.Imobiliaria;
import org.hibernate.HibernateException;


public class CtrImobiliaria {
    DaoImobiliaria daoImobiliaria;
    
    public CtrImobiliaria()
    {
        daoImobiliaria = new DaoImobiliaria();
    }
    
    public int gravarImobiliaria (Imobiliaria imobiliaria)
    {
        try
        {
            daoImobiliaria.gravar(imobiliaria);
            return 1;
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return 2;
        }
    }
    
   /* public Object carregarImobiliaria(int idImobiliaria)
    {
        try
        {
            return daoImobiliaria.carregarUm(idImobiliaria, Imobiliaria.class);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
    
    public boolean alterarImobiliaria(Imobiliaria imobiliaria)
    {
        try
        {
            daoImobiliaria.alterar(imobiliaria);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
