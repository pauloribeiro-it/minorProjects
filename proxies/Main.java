package proxies;

public class Main {
	public static void main(String[] args) {
		Dao<Person> dao = new DaoImpl();
		Dao<Person> proxy = (Dao<Person>)ProxyDao.createProxy(dao);
		proxy.delete(new Person());
		IterableInterface i = (IterableInterface)ProxyDao.createProxy(dao);
		i.iterate();
//		dao.save(new Person());
		
	}
}
