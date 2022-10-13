package com.myntra.cart.repository;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.myntra.cart.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

	@Query(value = "select i from Item i where i.cart.cartId = ?1")
	public Set<Item> findAllByCartId(Long cartId);

}
