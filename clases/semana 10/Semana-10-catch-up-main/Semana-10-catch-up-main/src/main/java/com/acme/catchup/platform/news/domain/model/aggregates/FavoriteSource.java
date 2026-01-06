/**
 * FavoriteSource aggregate.
 *
 * @summary
 * The FavoriteSource class is an aggregate root that represents a favorite news source.
 * It is responsible for handling the CreateFavoriteSourceCommand command.
 */
package com.acme.catchup.platform.news.domain.model.aggregates;

import com.acme.catchup.platform.news.domain.model.commands.CreateFavoriteSourceCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * FavoriteSource aggregate.
 *
 * <p>The FavoriteSource class is an aggregate root that represents a favorite news source.
 * It is responsible for handling the CreateFavoriteSourceCommand command.</p>
 */

@Entity
//Se hace uso para llenar automáticamente los campos createdAt y updatedAt
//También para las operaciones de persistencia de la entidad
@EntityListeners(AuditingEntityListener.class) // it is used to automatically populate the createdAt and updatedAt fields
public class FavoriteSource extends AbstractAggregateRoot<FavoriteSource> {
    /** The unique identifier of the favorite source. */
    @Id
    //Se genera automáticamente el valor del campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /** The API key for the news source. */
    @Column(nullable = false)
    @Getter
    private String newsApiKey;

    /** The identifier of the news source. */
    @Column(nullable = false)
    @Getter
    private String sourceId;

    /** The date and time when the favorite source was created. */
    @CreatedDate //Este campo se llenará automáticamente con la fecha y hora de creación, cuando se cree una nueva entidad
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    /** The date and time when the favorite source was last updated. */
    @LastModifiedDate //Este campo se llenará automáticamente con la fecha y hora de la última actualización, cuando se actualice una entidad
    @Column(nullable = false)
    private Date updatedAt;

    /**
     * Protected no-arg constructor for JPA.
     */
    protected FavoriteSource() {} //JPA requiere un constructor sin argumentos

    /**
     * Constructor.
     * It creates a new FavoriteSource instance.
     *
     * @param command the CreateFavoriteSourceCommand command containing the details of the favorite source
     */
    public FavoriteSource(CreateFavoriteSourceCommand command) {

        this.newsApiKey = command.newsApiKey();
        this.sourceId = command.sourceId();
    } //Se crea una nueva instancia de FavoriteSource con los datos del comando CreateFavoriteSourceCommand
}
