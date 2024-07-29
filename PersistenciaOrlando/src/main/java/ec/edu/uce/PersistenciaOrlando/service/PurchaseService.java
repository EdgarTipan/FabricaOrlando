package ec.edu.uce.PersistenciaOrlando.service;

import ec.edu.uce.PersistenciaOrlando.model.Purchase;
import ec.edu.uce.PersistenciaOrlando.repository.PurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Purchase not found with id: " + id));
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void delete(Long id) {
        if (!purchaseRepository.existsById(id)) {
            throw new EntityNotFoundException("Purchase not found with id: " + id);
        }
        purchaseRepository.deleteById(id);
    }

    public List<Purchase> findByUserId(Long userId) {
        return purchaseRepository.findByUserId(userId);
    }
}
