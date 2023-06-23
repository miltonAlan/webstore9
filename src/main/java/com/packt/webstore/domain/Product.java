package com.packt.webstore.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.*;

@XmlRootElement
public class Product implements Serializable {

private static final long serialVersionUID =3678107792576131001L;



@Pattern(regexp="P[1-9]+", message="{Pattern.Product.productId.validation}")
private String productId;

@Size(min=4, max=50, message=" {Size.Product.name.validation}")
private String name;

@Size(min=4, max=50, message=" {Size.Product.manufacturer.validation}")
private String manufacturer;


@Min(value=0, message="{Min.Product.unitPrice.validation}")@Digits(integer=8,fraction=2, message="{Digits.Product.unitPrice.validation}")@NotNull(message= "{NotNull.Product.unitPrice.validation}")
private BigDecimal unitPrice;


@Size(min=4, max=50, message=" {Size.Product.description.validation}")
private String description;

@Size(min=4, max=50, message=" {Size.Product.category.validation}")
private String category;

@Min(value=0, message="{Min.Product.unitsInStock.validation}")@Digits(integer=8,fraction=2, message="{Digits.Product.unitsInStock.validation}")@NotNull(message= "{NotNull.Product.unitsInStock.validation}")
private long unitsInStock;

@Min(value=0, message="{Min.Product.unitsInOrder.validation}")@Digits(integer=8,fraction=2, message="{Digits.Product.unitsInOrder.validation}")@NotNull(message= "{NotNull.Product.unitsInOrder.validation}")
private long unitsInOrder;
private boolean discontinued;

@NotNull(message= "{NotNull.Product.condition.validation}")
private String condition;

@JsonIgnore
private MultipartFile productImage;

public Product() {
super();
}
public Product(String productId, String name, BigDecimal unitPrice) {
    this.productId = productId;
    this.name = name;
    this.unitPrice = unitPrice;
}

// add setters and getters for all the fields here

public void setProductId(String ProductId){ this.productId = ProductId;}
public String getProductId(){ return productId;}

public void setName(String Name){ this.name = Name;}
public String getName(){ return name;}

public void setUnitPrice(BigDecimal UnitPrice){ this.unitPrice = UnitPrice; }
public BigDecimal getUnitPrice(){ return unitPrice; }

public void setDescription(String Description){ this.description = Description;}
public String getDescription(){ return description;}

public void setManufacturer(String Manufacturer){ this.manufacturer = Manufacturer;}
public String getManufacturer(){ return manufacturer;}

public void setCategory (String Category){ this.category = Category;}
public String getCategory(){ return category; }

public void setUnitsInStock (long UnitsInStock){ this.unitsInStock = UnitsInStock;}
public long getUnitsInStock (){return unitsInStock;}

public void setUnitsInOrder (long UnitsInOrder){this.unitsInOrder = UnitsInOrder;}
public long getUnitsInOrder(){ return unitsInOrder; }

public void setDiscontinued (boolean Discontinued){ this.discontinued = Discontinued;}
public boolean getDiscontinued(){ return discontinued; }

public void setCondition (String Condition){ this.condition = Condition; }
public String getCondition(){ return condition;}

public void setProductImage (MultipartFile productImage){ this.productImage = productImage; }

@XmlTransient
public MultipartFile getProductImage() {return productImage;
    }

@Override
public boolean equals(Object obj) {
    if (this == obj)
    return true;
    if (obj == null)
    return false;
    if (getClass() != obj.getClass())
    return false;
    Product other = (Product) obj;
    if (productId == null) {
    if (other.productId != null)
    return false;
    } else if (!productId.equals(other.productId))
    return false;
    return true;
}


@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
    + ((productId == null) ? 0 :
    productId.hashCode());
    return result;
    }

    
}