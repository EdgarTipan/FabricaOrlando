package ec.edu.uce.PersistenciaOrlando.controller;

import ec.edu.uce.PersistenciaOrlando.model.Product;
import ec.edu.uce.PersistenciaOrlando.service.MaterialService;
import ec.edu.uce.PersistenciaOrlando.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialService materialService;

    @PostMapping("/crear")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (product == null || product.getName() == null || product.getMaterialId() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        if (materialService.findById(product.getMaterialId()) == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        Iterable<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/material/{materialId}")
    public ResponseEntity<Iterable<Product>> getProductsByMaterialId(@PathVariable Long materialId) {
        Iterable<Product> products = productService.findByMaterialId(materialId);
        return ResponseEntity.ok(products);
    }
}
