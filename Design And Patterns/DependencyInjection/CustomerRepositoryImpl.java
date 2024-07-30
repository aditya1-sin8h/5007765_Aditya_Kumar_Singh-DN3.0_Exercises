package DependencyInjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(int id) {
        return new Customer(id, "John Doe");
    }
}
