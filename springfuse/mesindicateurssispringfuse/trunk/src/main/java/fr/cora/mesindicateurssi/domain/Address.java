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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;
import fr.cora.mesindicateurssi.validation.JpaUnique;

@Entity
@Table(name = "ADDRESS")
@JpaUnique
public class Address implements Persistable<Integer>, Copyable<Address> {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(Address.class);

    // Raw attributes
    private Integer id; // pk
    private String streetName;
    private String city; // not null
    private Integer version;

    // ---------------------------
    // Constructors
    // ---------------------------

    public Address() {
    }

    public Address(Integer primaryKey) {
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

    // -- [streetName] ------------------------

    @Size(max = 255)
    @Column(name = "STREET_NAME")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    // -- [city] ------------------------

    @NotEmpty
    @Size(max = 255)
    @Column(name = "CITY", nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // -- [version] ------------------------

    @Column(name = "VERSION", precision = 10)
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Address && hashCode() == other.hashCode());
    }

    private PersistableHashBuilder persistableHashBuilder = new PersistableHashBuilder();

    @Override
    public int hashCode() {
        return persistableHashBuilder.hash(this);
    }

    /**
     * Construct a readable string representation for this {@link Address} instance.
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this) //
                .add("id", getId()) //
                .add("streetName", getStreetName()) //
                .add("city", getCity()) //
                .add("version", getVersion()) //
                .toString();
    }

    /**
     * Return a copy of the current object
     */
    @Override
    public Address copy() {
        Address address = new Address();
        copyTo(address);
        return address;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Address address) {
        address.setId(getId());
        address.setStreetName(getStreetName());
        address.setCity(getCity());
        address.setVersion(getVersion());
    }
}