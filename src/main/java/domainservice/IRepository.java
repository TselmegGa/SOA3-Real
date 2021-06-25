package domainservice;

public interface IRepository<Object> {
    Iterable<Object> getAll();
    Object get(int id);
    Object add(Object o);
    void save(Object o);
    void delete(Object o);
}
