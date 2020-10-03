package tacos.dao;

import org.springframework.data.repository.CrudRepository;
import tacos.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
