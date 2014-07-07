

package dao;

public interface ITimeTableModelsDAO {
    <T> void addObject(T object);
    <T> void addSomeObjects(Iterable<T> objects);
    <T> T getObject(Class<T> clazz, Long id);
    <T> Iterable<T> getAllObjects(Class<T> clazz);
    <T> void deleteObject(Class<T> clazz, Long id);
    <T> void updateObject(T object);
}
