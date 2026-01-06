package com.isa.platform.u20221b127.inventory.interfaces.rest;

import com.isa.platform.u20221b127.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u20221b127.inventory.domain.services.ProductCommandService;
import com.isa.platform.u20221b127.inventory.domain.services.ProductQueryService;
import com.isa.platform.u20221b127.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.u20221b127.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.isa.platform.u20221b127.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import com.isa.platform.u20221b127.monitoring.domain.model.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.u20221b127.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u20221b127.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u20221b127.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u20221b127.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.u20221b127.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Products Controller
 * <p>
 *     This class is responsible for handling HTTP requests related to products.
 *     It provides endpoints for creating products, getting products by ID, creating snapshots and getting snapshots by product ID.
 * </p>
 * @author Salvador Salinas
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Products Endpoints")
public class ProductsController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;
    private final SnapshotCommandService snapshotCommandService;
    private final SnapshotQueryService snapshotQueryService;

    public ProductsController(ProductCommandService productCommandService, ProductQueryService productQueryService, SnapshotCommandService snapshotCommandService, SnapshotQueryService snapshotQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
        this.snapshotCommandService = snapshotCommandService;
        this.snapshotQueryService = snapshotQueryService;
    }

    /**
     * Create a new product in the inventory
     * @param resource The product resource
     * @return The created product
     * @throws Exception If the product cannot be created
     */
    @Operation(summary = "Create a new product", description = "Create a new product in the inventory")
    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody CreateProductResource resource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(resource);
        try {
            var product = productCommandService.handle(createProductCommand);
            if (product.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(productResource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
        }
    }

    /**
     * Get a product by its ID
     * @param id The product ID
     * @return The product
     * @throws Exception If the product cannot be found
     */
    @Operation(summary = "Get a product", description = "Get a product by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        var getProductByIdQuery = new GetProductByIdQuery(id);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body("Product not found");
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.status(HttpStatus.OK).body(productResource);
    }

    /**
     * Create a snapshot of a product
     * @param productId The product ID
     * @param resource The snapshot resource
     * @return The created snapshot
     * @throws Exception If the snapshot cannot be created
     */
    @Operation(summary = "Create a snapshot", description = "Create a snapshot of a product")
    @PostMapping("/{productId}/snapshots")
    public ResponseEntity<?> createSnapshot(@PathVariable Long productId, @RequestBody CreateSnapshotResource resource) {
        var createSnapshotCommand = CreateSnapshotCommandFromResourceAssembler.toCommandFromResource(resource);
        try {
            var snapshot = snapshotCommandService.handle(createSnapshotCommand, productId);
            if (snapshot.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.TEXT_PLAIN).body("Snapshot already exists");
            }
            var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(snapshotResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
        }
    }

    /**
     * Get snapshots by product ID
     * @param productId The product ID
     * @return The snapshots
     * @throws Exception If the snapshots cannot be found
     */
    @Operation(summary = "Get snapshot of a product", description = "Get snapshots by product ID")
    @GetMapping("/{productId}/snapshots")
    public ResponseEntity<?> getSnapshotsByProductId(@PathVariable Long productId) {
        var getSnapshotsByProductIdQuery = new GetSnapshotsByProductIdQuery(productId);
        try {
            var snapshots = snapshotQueryService.handle(getSnapshotsByProductIdQuery);
            var snapshotResources = snapshots.stream()
                    .map(SnapshotResourceFromEntityAssembler::toResourceFromEntity)
                    .toList();
            return ResponseEntity.status(HttpStatus.OK).body(snapshotResources);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN).body(e.getMessage());
        }
    }

}
