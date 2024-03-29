/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/main/java/project/domain/Entity_.e.vm.java
 */
package fr.cora.mesindicateurssi.domain;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import fr.cora.mesindicateurssi.domain.enums.Civility;

@StaticMetamodel(Account.class)
public abstract class Account_ {

    // Raw attributes
    public static volatile SingularAttribute<Account, String> id;
    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, Boolean> isEnabled;
    public static volatile SingularAttribute<Account, Civility> civility;
    public static volatile SingularAttribute<Account, String> firstName;
    public static volatile SingularAttribute<Account, String> lastName;
    public static volatile SingularAttribute<Account, Date> birthDate;
    public static volatile SingularAttribute<Account, Integer> version;

    // Technical attributes for query by example
    public static volatile SingularAttribute<Account, Integer> addressId;

    // Many to one
    public static volatile SingularAttribute<Account, Address> homeAddress;

    // One to many
    public static volatile ListAttribute<Account, Book> books;
    public static volatile ListAttribute<Account, Document> documents;

    // Many to many
    public static volatile ListAttribute<Account, Role> roles;
}