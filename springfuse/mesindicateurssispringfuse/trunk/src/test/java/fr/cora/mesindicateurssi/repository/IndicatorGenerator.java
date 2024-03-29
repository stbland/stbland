/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-sd:src/test/java/repository/ModelGenerator.e.vm.java
 */
package fr.cora.mesindicateurssi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.cora.mesindicateurssi.domain.Category;
import fr.cora.mesindicateurssi.domain.Indicator;
import fr.cora.mesindicateurssi.repository.CategoryGenerator;
import fr.cora.mesindicateurssi.repository.CategoryRepository;
import fr.cora.mesindicateurssi.util.ValueGenerator;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class IndicatorGenerator {

    /**
     * Returns a new Indicator instance filled with random values.
     */
    public Indicator getIndicator() {
        Indicator indicator = new Indicator();

        // simple attributes follows
        indicator.setName("aa");
        indicator.setDescription("a");
        // mandatory relation
        Category category = categoryGenerator.getCategory();
        categoryRepository.save(category);
        indicator.setCategory(category);
        return indicator;
    }

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryGenerator categoryGenerator;
}