package com.kyeljmd.ecormmerce.shopeepee.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.kyeljmd.ecormmerce.shopeepee.domain.Product} entity.
 */
public class ProductDTO implements Serializable {
    
    private Long id;

    private String name;

    private String details;

    private String sku;

    private String category;

    private Double price;

    private Integer stocks;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", details='" + getDetails() + "'" +
            ", sku='" + getSku() + "'" +
            ", category='" + getCategory() + "'" +
            ", price=" + getPrice() +
            ", stocks=" + getStocks() +
            "}";
    }
}
