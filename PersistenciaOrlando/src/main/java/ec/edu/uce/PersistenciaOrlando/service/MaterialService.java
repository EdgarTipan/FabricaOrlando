package ec.edu.uce.PersistenciaOrlando.service;

import ec.edu.uce.PersistenciaOrlando.model.Material;
import ec.edu.uce.PersistenciaOrlando.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material findById(Long id) {
        return materialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Material not found with id: " + id));
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public void delete(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new EntityNotFoundException("Material not found with id: " + id);
        }
        materialRepository.deleteById(id);
    }
}
