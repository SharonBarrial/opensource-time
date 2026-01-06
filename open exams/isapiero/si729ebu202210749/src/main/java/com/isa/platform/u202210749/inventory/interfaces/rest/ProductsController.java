package com.isa.platform.u202210749.inventory.interfaces.rest;

import com.isa.platform.u202210749.inventory.domain.model.queries.GetProductByIdQuery;
import com.isa.platform.u202210749.inventory.domain.services.ProductCommandService;
import com.isa.platform.u202210749.inventory.domain.services.ProductQueryService;
import com.isa.platform.u202210749.inventory.interfaces.rest.resources.CreateProductResource;
import com.isa.platform.u202210749.inventory.interfaces.rest.resources.ProductResource;
import com.isa.platform.u202210749.inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import com.isa.platform.u202210749.inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="api/v1/products",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Product Management Endpoints")
public class ProductsController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductsController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId){
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductResource createProductResource){
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(createProductResource);
        Long productId;
        try {
            productId = productCommandService.handle(createProductCommand);
        } catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.getMessage());
        }
        if (productId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()){ return ResponseEntity.badRequest().build(); }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

}
