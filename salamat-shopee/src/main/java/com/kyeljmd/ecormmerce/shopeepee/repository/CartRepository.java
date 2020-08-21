package com.kyeljmd.ecormmerce.shopeepee.repository;

import com.kyeljmd.ecormmerce.shopeepee.domain.Cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Cart entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Page<Cart> findAllByOwner(String owner, Pageable pageable);

    Cart findByOwnerAndProductId(String owner, Long productId);
}
