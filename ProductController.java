package com.packt.webstore.controller;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.*;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.packt.webstore.domain.Product;
import java.io.File;
import java.util.List;
import javax.validation.Valid;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("market")
@Controller
public class ProductController {
    
@RequestMapping("/products")
public String list(Model model) {
model.addAttribute("products",productService.getAllProducts());
return "products";
}


@Autowired
private ProductService productService;

@RequestMapping("/update/stock")
public String updateStock(Model model) {
    productService.updateAllStock();
    return "redirect:/products";
}

@RequestMapping("/products/filter/{params}")
public String getProductsByFilter(@MatrixVariable(pathVar="params")
    Map<String,List<String>> filterParams, Model model) {
    model.addAttribute("products", productService.getProductsByFilter(filterParams));
    return "products";
}

@RequestMapping("/product")
public String getProductById(@RequestParam("id") String
    productId, Model model) {
    model.addAttribute("product",productService.getProductById(productId));
    return "product";
}
        

@RequestMapping(value = "/products/add", method = RequestMethod.GET)
public String getAddNewProductForm(Model model) {
Product newProduct = new Product();
model.addAttribute("newProduct", newProduct);
return "addProduct";
}

@RequestMapping(value = "/products/add", method =  RequestMethod.POST)
public String processAddNewProductForm(@ModelAttribute("newProduct")
   @Valid Product newProduct, BindingResult result, HttpServletRequest request) {

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
        throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

    MultipartFile productImage = newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage!=null && !productImage.isEmpty()) {
        try {
        productImage.transferTo(new File(rootDirectory+"resources\\images"+ newProduct.getProductId() + ".png"));
        } catch (Exception e) {
        throw new RuntimeException("Product Image saving failed", e);
        }
        
   
}
        
if(result.hasErrors()) { return "addProduct"; }

productService.addProduct(newProduct);
return "redirect:/market/products";
}
        
@InitBinder
public void initialiseBinder(WebDataBinder binder) {
binder.setAllowedFields("productId",
"name",
"unitPrice",
"description",
"manufacturer",
"category",
"unitsInStock",
"condition",
"productImage",
"language");
}

@RequestMapping("/products/invalidPromoCode")
public String invalidPromoCode() {
return "invalidPromoCode";
}





}