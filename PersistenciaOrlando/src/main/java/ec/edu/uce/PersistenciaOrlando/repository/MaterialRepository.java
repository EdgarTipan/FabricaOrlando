package ec.edu.uce.PersistenciaOrlando.repository;

import ec.edu.uce.PersistenciaOrlando.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
