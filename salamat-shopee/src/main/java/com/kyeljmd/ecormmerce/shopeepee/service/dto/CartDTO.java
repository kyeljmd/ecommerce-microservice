package com.kyeljmd.ecormmerce.shopeepee.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.kyeljmd.ecormmerce.shopeepee.domain.Cart} entity.
 */
public class CartDTO implements Serializable {
    
    private Long id;

    private Integer quantity;

    private String owner;

    private Long productId;

    private Double totalPrice;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CartDTO)) {
            return false;
        }

        return id != null && id.equals(((CartDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CartDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", owner='" + getOwner() + "'" +
            ", productId=" + getProductId() +
            "}";
    }
}
