

package dao;

import java.util.LinkedList;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class TimeTableModelsHibernateDAO implements ITimeTableModelsDAO{
    private final Configuration cfg;
    SessionFactory sessionFactory;
    
    public TimeTableModelsHibernateDAO() {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }
    

    @Override
    public <T> void addObject(T object) {
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            session.save(object);
            
            session.getTransaction().commit();
            
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
    }

    @Override
    public <T> void addSomeObjects(Iterable<T> objects) {
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            for (T obj : objects){
                session.save(obj);
            }
            
            session.getTransaction().commit();
            
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public <T> T getObject(Class<T> clazz, Long id) {
        Session session = null;
        T obj = null;
        
        try{
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            obj = (T)session.get(clazz, id);
            
            session.getTransaction().commit();
            
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }    
        return obj;
    }

    @Override
    public <T> Iterable<T> getAllObjects(Class<T> clazz) {
        Session session = null;
        LinkedList<T> list = new LinkedList<>();
        
        try{
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            Criteria criteria = session.createCriteria(clazz);
            
            list.addAll(criteria.list());
            
            session.getTransaction().commit();
            
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return list;              
    }

    @Override
    public <T> void deleteObject(Class<T> clazz, Long id) {
        Session session = null;
        
        try{
            session = sessionFactory.getCurrentSession();
           
            session.beginTransaction();
           
            T obj = (T)session.get(clazz, id);
            session.delete(obj);
            
            session.getTransaction().commit();
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        
    }

    @Override
    public <T> void updateObject(T object) {
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();

            session.saveOrUpdate(object);
            
            session.getTransaction().commit();
            
        }catch(RuntimeException e){
            try{
                    session.getTransaction().rollback();
            }catch(RuntimeException rbe){
            }
            throw e;
        }
        finally{
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
    
}
