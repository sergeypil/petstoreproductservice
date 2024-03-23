package com.chtrembl.petstore.product.repository;

import com.chtrembl.petstore.product.entity.Product;
import com.chtrembl.petstore.product.entity.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStatusIn(List<StatusEnum> statuses);
}
