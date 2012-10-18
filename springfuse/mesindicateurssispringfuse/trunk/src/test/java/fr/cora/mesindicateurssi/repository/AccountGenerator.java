/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/test/java/repository/ModelGenerator.e.vm.java
 */
package fr.cora.mesindicateurssi.repository;

import java.util.Date;
import org.springframework.stereotype.Service;
import fr.cora.mesindicateurssi.domain.Account;
import fr.cora.mesindicateurssi.domain.enums.Civility;
import fr.cora.mesindicateurssi.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class AccountGenerator {

    /**
     * Returns a new Account instance filled with random values.
     */
    public Account getAccount() {
        Account account = new Account();

        // simple attributes follows
        account.setUsername(ValueGenerator.getUniqueString(255));
        account.setPassword("a");
        account.setEmail(ValueGenerator.getUniqueEmail());
        account.setIsEnabled(true);
        account.setCivility(Civility.MR);
        account.setFirstName("a");
        account.setLastName("a");
        account.setBirthDate(new Date());
        return account;
    }

}