package com.chtrembl.petstore.product.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @NotNull
    private String name;

    @NotNull
    private String photoURL;

    @ManyToMany(cascade = {CascadeType.ALL })
    @JoinTable(
        name = "producttag",
        joinColumns = { @JoinColumn(name = "product_id") },
        inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private List<Tag> tags;

    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;
}