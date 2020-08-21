package com.kyeljmd.ecommerce.uaa.repository;

import com.kyeljmd.ecommerce.uaa.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
