package com.example.demo.ProductController;

import com.example.demo.production.Product;
import com.example.demo.production.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.LinkOption;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
       // Product newProduct = pr
       // return ResponseEntity.ok(n);
        return null;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return null;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return  ResponseEntity.ok(product);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(path ="/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId")
                                                 Long productId, @RequestBody Product product){
        return productService.updateProduct(productId,product);
    }
    @DeleteMapping(value = "/products/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.delecteProduct(productId);
        return "Product Deleted Succesfull" + productId + " ";
    }
}
