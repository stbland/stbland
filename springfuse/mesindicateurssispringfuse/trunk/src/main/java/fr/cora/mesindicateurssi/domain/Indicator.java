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

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Persistable;
import fr.cora.mesindicateurssi.domain.Category;
import fr.cora.mesindicateurssi.domain.Tag;
import fr.cora.mesindicateurssi.validation.JpaUnique;

@Entity
@Table(name = "INDICATORS")
@JpaUnique
public class Indicator implements Persistable<Integer>, Copyable<Indicator> {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(Indicator.class);

    // Raw attributes
    private Integer id; // pk
    private String name;
    private String description;

    // Technical attributes for query by example
    private Integer categoryId; // not null

    // Many to one
    private Category category; // not null (categoryId)

    // Many to many
    private List<Tag> tags = new ArrayList<Tag>();

    // ---------------------------
    // Constructors
    // ---------------------------

    public Indicator() {
    }

    public Indicator(Integer primaryKey) {
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

    // -- [description] ------------------------

    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // -- [categoryId] ------------------------

    @Column(name = "CATEGORY_ID", nullable = false, precision = 10, insertable = false, updatable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    private void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // --------------------------------------------------------------------
    // Many to One support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Indicator.categoryId ==> Category.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @NotNull
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Category getCategory() {
        return category;
    }

    /**
     * Set the category without adding this Indicator instance on the passed category
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by {@link Category}
     */
    public void setCategory(Category category) {
        this.category = category;

        // We set the foreign key property so it can be used by Hibernate search by Example facility.
        if (category != null) {
            setCategoryId(category.getId());
        } else {
            setCategoryId(null);
        }
    }

    // --------------------------------------------------------------------
    // Many to Many
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: indicator ==> tags
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Returns the tags list.
     */
    @JoinTable(name = "INDICATORS_TAGS", joinColumns = @JoinColumn(name = "INDICATOR_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    @ManyToMany(cascade = PERSIST)
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * Set the tags list.
     * <p>
     * It is recommended to use the helper method {@link #addTag(Tag)} / {@link #removeTag(Tag)}
     * if you want to preserve referential integrity at the object level.
     *
     * @param tags the list of Tag
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Helper method to add the passed {@link Tag} to the tags list.
     */
    public boolean addTag(Tag tag) {
        return getTags().add(tag);
    }

    /**
     * Helper method to remove the passed {@link Tag} from the tags list.
     */
    public boolean removeTag(Tag tag) {
        return getTags().remove(tag);
    }

    /**
     * Helper method to determine if the passed {@link Tag} is present in the tags list.
     */
    public boolean containsTag(Tag tag) {
        return getTags() != null && getTags().contains(tag);
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Indicator && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(this);
    }

    /**
     * Construct a readable string representation for this {@link Indicator} instance.
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("name", getName()) //
                .add("description", getDescription()) //
                .add("categoryId", getCategoryId()) //
                .toString();
    }

    /**
     * Return a copy of the current object
     */
    @Override
    public Indicator copy() {
        Indicator indicator = new Indicator();
        copyTo(indicator);
        return indicator;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Indicator indicator) {
        indicator.setId(getId());
        indicator.setName(getName());
        indicator.setDescription(getDescription());
        //indicator.setCategoryId(getCategoryId());
        if (getCategory() != null) {
            indicator.setCategory(new Category(getCategory().getId()));
        }
    }
}