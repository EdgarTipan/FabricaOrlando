package ec.edu.uce.PersistenciaOrlando.repository;

import ec.edu.uce.PersistenciaOrlando.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findByMaterialId(Long materialId);
    Product findByName(String name);
}
