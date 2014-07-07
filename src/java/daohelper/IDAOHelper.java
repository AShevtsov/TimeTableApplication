

package daohelper;

import java.util.Map;

public interface IDAOHelper {
    <T> Iterable<T> getTable(Class<T> clazz, Long id);
    <T> T addElement(Class<T> clazz, Map<String, String[]> valuesOfFields);
    <T> void deleteElement(Class<T> clazz, Long id);
    <T> void update(Class<T> clazz, Long id, Map<String, String[]> valuesOfFields);
}
