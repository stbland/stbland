/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/test/java/repository/ModelGenerator.e.vm.java
 */
package fr.cora.mesindicateurssi.repository;

import org.springframework.stereotype.Service;
import fr.cora.mesindicateurssi.domain.Role;
import fr.cora.mesindicateurssi.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class RoleGenerator {

    /**
     * Returns a new Role instance filled with random values.
     */
    public Role getRole() {
        Role role = new Role();

        // simple attributes follows
        role.setRoleName(ValueGenerator.getUniqueString(255));
        return role;
    }

}