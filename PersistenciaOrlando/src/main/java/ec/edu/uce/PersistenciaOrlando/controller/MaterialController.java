package ec.edu.uce.PersistenciaOrlando.controller;

import ec.edu.uce.PersistenciaOrlando.model.Material;
import ec.edu.uce.PersistenciaOrlando.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/crear")
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material savedMaterial = materialService.save(material);
        return ResponseEntity.ok(savedMaterial);
    }

    @GetMapping
    public ResponseEntity<Iterable<Material>> getAllMaterials() {
        Iterable<Material> materials = materialService.findAll();
        return ResponseEntity.ok(materials);
    }
}
