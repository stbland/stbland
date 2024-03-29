/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/main/java/project/domain/Entity.e.vm.java
 */
package fr.cora.mesindicateurssi.domain;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlTransient;
import fr.cora.mesindicateurssi.domain.PersistableHashBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Persistable;
import fr.cora.mesindicateurssi.validation.JpaUnique;

@Entity
@Table(name = "CATEGORIES")
@JpaUnique
public class Category implements Persistable<Integer>, Copyable<Category> {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(Category.class);

    // Raw attributes
    private Integer id; // pk
    private String name;

    // ---------------------------
    // Constructors
    // ---------------------------

    public Category() {
    }

    public Category(Integer primaryKey) {
        setId(primaryKey);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isNew() {
        return getId() == null;
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [id] ------------------------

    @Column(name = "ID", precision = 10)
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // -- [name] ------------------------

    @Size(min = 2, max = 128)
    @Column(name = "NAME", length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Category && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(this);
    }

    /**
     * Construct a readable string representation for this {@link Category} instance.
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("name", getName()) //
                .toString();
    }

    /**
     * Return a copy of the current object
     */
    @Override
    public Category copy() {
        Category category = new Category();
        copyTo(category);
        return category;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Category category) {
        category.setId(getId());
        category.setName(getName());
    }
}