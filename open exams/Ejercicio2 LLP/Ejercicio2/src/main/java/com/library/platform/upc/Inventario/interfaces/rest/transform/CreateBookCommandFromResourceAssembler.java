package com.library.platform.upc.Inventario.interfaces.rest.transform;

import com.library.platform.upc.Inventario.domain.model.commands.CreateBookCommand;
import com.library.platform.upc.Inventario.interfaces.rest.resources.CreateBookResource;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateBookCommandFromResourceAssembler {

    public CreateBookCommand toCommand(CreateBookResource resource) {
        List<Long> genreIds = resource.genreIds().stream()
                .map(Long::valueOf) // Convertir cada ID de género de String a Long
                .collect(Collectors.toList());
        return new CreateBookCommand(
                resource.isbn(),
                resource.title(),
                resource.author(),
                resource.publishedDate(),
                resource.status(),
                genreIds
        );
    }
}