package proxies;

public interface Dao<T> {
	void save(T t);
	void delete(T t);
}
