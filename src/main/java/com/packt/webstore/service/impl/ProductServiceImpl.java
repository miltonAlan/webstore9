package com.packt.webstore.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

@Autowired
private ProductRepository productRepository;

@Override
public void updateAllStock() {
    List<Product> allProducts = productRepository.getAllProducts();
    for(Product product : allProducts) {
     if(product.getUnitsInStock()<500)
        productRepository.updateStock (product.getProductId(), product.getUnitsInStock()+1000);
}
}


@Override
public List<Product> getAllProducts() {
return productRepository.getAllProducts();
}


public List<Product> getProductsByFilter(Map<String, List<String>> filterParams)
    { return productRepository.getProductsByFilter(filterParams);
}


@Override
public Product getProductById(String productID) {
return productRepository.getProductById(productID);
}

@Override
public void addProduct(Product product) {
productRepository.addProduct(product);
}

}