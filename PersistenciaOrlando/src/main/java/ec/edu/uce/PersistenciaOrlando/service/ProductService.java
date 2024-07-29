package ec.edu.uce.PersistenciaOrlando.service;

import ec.edu.uce.PersistenciaOrlando.model.Product;
import ec.edu.uce.PersistenciaOrlando.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    public Iterable<Product> findByMaterialId(Long materialId) {
        return productRepository.findByMaterialId(materialId);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
