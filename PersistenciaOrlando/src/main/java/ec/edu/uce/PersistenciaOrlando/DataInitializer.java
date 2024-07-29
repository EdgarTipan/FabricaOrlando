package ec.edu.uce.PersistenciaOrlando;

import ec.edu.uce.PersistenciaOrlando.model.Material;
import ec.edu.uce.PersistenciaOrlando.model.Product;
import ec.edu.uce.PersistenciaOrlando.model.User;
import ec.edu.uce.PersistenciaOrlando.service.MaterialService;
import ec.edu.uce.PersistenciaOrlando.service.ProductService;
import ec.edu.uce.PersistenciaOrlando.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductService productoService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        // Agregar admin
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole("ADMIN");

        userService.save(admin);

        // Agregar materiales iniciales aca
        Material madera = new Material();
        madera.setName("Madera");

        Material metal = new Material();
        metal.setName("Metal");

        Material cristal = new Material();
        cristal.setName("Cristal");

        Material diamante = new Material();
        diamante.setName("Diamante");

        materialService.save(madera);
        materialService.save(metal);
        materialService.save(cristal);
        materialService.save(diamante);

        // Agregar productos iniciales aca

        //---------- Maderas ----------
        Product sillaMadera = new Product();
        sillaMadera.setName("Silla de madera");
        sillaMadera.setMaterialId(madera.getId());

        Product mesaMadera = new Product();
        mesaMadera.setName("Mesa de madera");
        mesaMadera.setMaterialId(madera.getId());

        Product estanteMadera = new Product();
        estanteMadera.setName("Estante de madera");
        estanteMadera.setMaterialId(madera.getId());

        Product pinocho = new Product();
        pinocho.setName("Marioneta de madera");
        pinocho.setMaterialId(madera.getId());

        productoService.save(sillaMadera);
        productoService.save(mesaMadera);
        productoService.save(estanteMadera);
        productoService.save(pinocho);

        //---------- Metales ----------

        Product vigasMetalicas = new Product();
        vigasMetalicas.setName("Vigas metalicas");
        vigasMetalicas.setMaterialId(metal.getId());

        Product tubosMetalicos = new Product();
        tubosMetalicos.setName("Tubos metalicos");
        tubosMetalicos.setMaterialId(metal.getId());

        Product envaseMetalico = new Product();
        envaseMetalico.setName("Envase Metalico");
        envaseMetalico.setMaterialId(metal.getId());

        productoService.save(vigasMetalicas);
        productoService.save(tubosMetalicos);
        productoService.save(envaseMetalico);

        //---------- Cristales ----------

        Product envaseCristal = new Product();
        envaseCristal.setName("Envase de cristal");
        envaseCristal.setMaterialId(cristal.getId());

        Product decoracionCristal = new Product();
        decoracionCristal.setName("Decoracion de cristal");
        decoracionCristal.setMaterialId(cristal.getId());

        productoService.save(envaseCristal);
        productoService.save(decoracionCristal);

        //---------- Diamantes ----------

        Product espadaDiamante = new Product();
        espadaDiamante.setName("Espada de diamante");
        espadaDiamante.setMaterialId(diamante.getId());

        Product picoDiamante = new Product();
        picoDiamante.setName("Pico de diamante");
        picoDiamante.setMaterialId(diamante.getId());

        productoService.save(espadaDiamante);
        productoService.save(picoDiamante);
    }
}
