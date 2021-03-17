package com.medesta.model.binding;

import com.medesta.model.enums.ProductCategory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductBindingModel {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expireDate;
    private String category;

    public ProductBindingModel() {
    }

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3, message = "The product name must be minimum 3 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "This field cannot be empty")
    @Size(min = 5, message = "Description must be minimum 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "This field cannot be empty")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "The date can not be in the past or present")
    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @NotNull(message = "Please select from categories")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
