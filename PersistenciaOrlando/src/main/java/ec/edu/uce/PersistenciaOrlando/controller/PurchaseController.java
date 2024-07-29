package ec.edu.uce.PersistenciaOrlando.controller;

import ec.edu.uce.PersistenciaOrlando.model.Purchase;
import ec.edu.uce.PersistenciaOrlando.model.Product;
import ec.edu.uce.PersistenciaOrlando.service.PurchaseService;
import ec.edu.uce.PersistenciaOrlando.service.ProductService;
import ec.edu.uce.PersistenciaOrlando.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Purchase>> getOrders() {
        List<Purchase> purchases = purchaseService.findAll();
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getOrderById(@PathVariable Long id) {
        Purchase purchase = purchaseService.findById(id);
        if (purchase != null) {
            return ResponseEntity.ok(purchase);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Purchase> createOrder(@Validated @RequestBody Purchase purchase) {
        if (purchase == null || purchase.getUserId() == null || purchase.getProductName() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        if (userService.findById(purchase.getUserId()) == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Product product = productService.findByName(purchase.getProductName());
        if (product == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Purchase newPurchase = new Purchase();
        newPurchase.setUserId(purchase.getUserId());
        newPurchase.setProductName(purchase.getProductName());

        Purchase savedPurchase = purchaseService.save(newPurchase);

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(savedPurchase);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPurchase);
    }

}
