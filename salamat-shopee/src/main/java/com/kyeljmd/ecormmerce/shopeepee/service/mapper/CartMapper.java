package com.kyeljmd.ecormmerce.shopeepee.service.mapper;


import com.kyeljmd.ecormmerce.shopeepee.domain.*;
import com.kyeljmd.ecormmerce.shopeepee.service.dto.CartDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartMapper extends EntityMapper<CartDTO, Cart> {

    @Mapping(source = "product.id", target = "productId")
    CartDTO toDto(Cart cart);

    @Mapping(source = "productId", target = "product")
    Cart toEntity(CartDTO cartDTO);

    default Cart fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cart cart = new Cart();
        cart.setId(id);
        return cart;
    }
}
