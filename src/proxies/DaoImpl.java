package proxies;

public class DaoImpl implements Dao<Person>,IterableInterface{

	@Override
	public void save(Person t) {
		System.out.println("Person saved.");
	}

	@Override
	public void delete(Person t) {
		System.out.println("Person deleted.");
	}

	@Override
	public void iterate() {
		System.out.println("Iterating...");
	}
	
}
