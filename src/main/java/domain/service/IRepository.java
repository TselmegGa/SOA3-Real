package domain.service;

public interface IRepository<T> {
    Iterable<T> getAll();
    Object get(int id);
    Object add(T o);
    void save(T o);
    void delete(T o);
}
