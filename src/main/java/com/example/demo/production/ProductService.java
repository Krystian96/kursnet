package com.example.demo.production;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productRepository.save(product);
        return ResponseEntity.ok(newProduct);
    }
    public ResponseEntity<List<Product>> fetchAllProducts(){
        return ResponseEntity.ok(productRepository.findAll());
    }
    public ResponseEntity<Optional<Product>> fetchProductById(Long id)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Product> updateProduct(Long id, Product updatedProduct) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Product ExistingProduct = productRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(
                String.valueOf(id)));
        ExistingProduct.setName(updatedProduct.getName());
        ExistingProduct.setPrice(updatedProduct.getPrice());
        ExistingProduct.setQuantity(updatedProduct.getQuantity());
        Product saveEntity = productRepository.save(ExistingProduct);
        return ResponseEntity.ok(saveEntity);
    }
    public ResponseEntity<String> delecteProduct(Long id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product dellete sucesfull");

    }

    public Product getProductById(Long id) {
        return null;
    }
}



