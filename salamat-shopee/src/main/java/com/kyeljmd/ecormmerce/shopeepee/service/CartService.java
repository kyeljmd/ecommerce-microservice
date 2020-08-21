package com.kyeljmd.ecormmerce.shopeepee.service;

import com.kyeljmd.ecormmerce.shopeepee.domain.Cart;
import com.kyeljmd.ecormmerce.shopeepee.domain.Product;
import com.kyeljmd.ecormmerce.shopeepee.repository.CartRepository;
import com.kyeljmd.ecormmerce.shopeepee.service.dto.CartDTO;
import com.kyeljmd.ecormmerce.shopeepee.service.mapper.CartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Cart}.
 */
@Service
@Transactional
public class CartService {

    private final Logger log = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    /**
     * Save a cart.
     *
     * @param cartDTO the entity to save.
     * @return the persisted entity.
     */
    public CartDTO save(CartDTO cartDTO, String owner) {
        log.debug("Request to save Cart : {}", cartDTO);

        Cart cart = cartRepository.findByOwnerAndProductId(owner, cartDTO.getProductId());

        if(cart != null){
            System.out.println("I EXIST");
            cart.setQuantity(cartDTO.getQuantity());
        }else{
            cart = cartMapper.toEntity(cartDTO);
        }
        cart.setOwner(owner);
        cart = cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    /**
     * Get all the carts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CartDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Carts");
        return cartRepository.findAll(pageable)
            .map(cartMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<CartDTO> findByOwnerId(String owner, Pageable pageable) {
        log.debug("Request to get all Carts");
        return cartRepository.findAllByOwner(owner, pageable).map(cart -> {
            Product product = cart.getProduct();
            CartDTO cartDTO = cartMapper.toDto(cart);
            if(cartDTO.getQuantity() == null){
                cartDTO.setTotalPrice(product.getPrice() * 1);

            }else {
                cartDTO.setTotalPrice(product.getPrice() * cartDTO.getQuantity());
            }
            return cartDTO;
        });
    }
    /**
     * Get one cart by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CartDTO> findOne(Long id) {
        log.debug("Request to get Cart : {}", id);
        return cartRepository.findById(id)
            .map(cartMapper::toDto);
    }

    /**
     * Delete the cart by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cart : {}", id);
        cartRepository.deleteById(id);
    }
}
