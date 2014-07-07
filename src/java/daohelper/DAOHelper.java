

package daohelper;

import java.util.Map;
import models.*;
import dao.ITimeTableModelsDAO;
import dao.TimeTableModelsHibernateDAO;

public class DAOHelper implements IDAOHelper{
    ITimeTableModelsDAO dao;
    
    public DAOHelper() {
        dao = new TimeTableModelsHibernateDAO();
    }

    @Override
    public <T> Iterable<T> getTable(Class<T> clazz, Long id) {
        if (id == 0){
            return getAllModels(clazz);
        }
        return null;
    }

    @Override
    public <T> T addElement(Class<T> clazz, Map<String, String[]> valuesOfFields) {
        
        if (clazz == Faculty.class){
            return (T)addFaculty(valuesOfFields, null);
        }
        throw new RuntimeException("Incorrect class");
    }
    
    private <T> Iterable<T> getAllModels(Class<T> clazz){
        return dao.getAllObjects(clazz);
    }

    @Override
    public <T> void deleteElement(Class<T> clazz, Long id) {
        dao.deleteObject(clazz, id);
    }
    
    public Faculty addFaculty(Map<String, String[]> valuesOfFields, Long id){
        Faculty f = new Faculty();
        f.setName(valuesOfFields.get("name")[0]);
        if (id == null || id <= 0){
            dao.addObject(f);
        }
        else{
            f.setId(id);
            dao.updateObject(f);
        }
        
        return f;
    }

    @Override
    public <T> void update(Class<T> clazz, Long id, Map<String, String[]> valuesOfFields) {
        if (dao.getObject(clazz, id) == null){
            throw new RuntimeException("Object not found");
        }
        
        if (clazz == Faculty.class){
            addFaculty(valuesOfFields, id);
            return;
        }
        throw new RuntimeException("Incorrect class!");
    }
  
}
