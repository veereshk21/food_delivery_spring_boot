package com.foodproject.orders;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer>{

	List<Orders> findByUserUserId(Integer id);
	List<Orders> findByMenuMenuId(Integer id);
	@Query(value = "select sum(order_amount) from orders where user_user_id = ?", nativeQuery = true)
	Double fetchUserTotalAmount(Integer userId);
	@Query(value = "(select food_price from food where food_id = (select food_food_id from menu where menu_id =?))", nativeQuery = true)
	Double getFoodPrice(Integer menuId);
}
