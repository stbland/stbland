/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/main/java/project/repository/Repository.e.vm.java
 */
package fr.cora.mesindicateurssi.repository;

import fr.cora.mesindicateurssi.domain.Account;
import fr.cora.mesindicateurssi.repository.support.CustomRepository;

/**
 * Advanced CRUD Repository for {@link Account}.
 */
public interface AccountRepository extends CustomRepository<Account, String> {

    /**
     * Lookup a account by username.
     */
    Account getByUsername(String username);

    /**
     * Lookup a account by email.
     */
    Account getByEmail(String email);
}