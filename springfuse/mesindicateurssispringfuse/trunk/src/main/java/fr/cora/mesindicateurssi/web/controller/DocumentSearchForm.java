/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/web/controller/SearchForm.e.vm.java
 */
package fr.cora.mesindicateurssi.web.controller;

import static com.google.common.collect.Lists.newArrayList;

import java.io.Serializable;
import java.util.List;
import fr.cora.mesindicateurssi.domain.Document;
import fr.cora.mesindicateurssi.repository.support.NullRestriction;
import fr.cora.mesindicateurssi.repository.support.SearchForm;

/**
 * SearchForm for {@link DocumentService}
 */
public class DocumentSearchForm extends SearchForm<Document> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Document document = new Document();

    /**
     * The root document for search by example.
     * Used from the view.
     */
    @Override
    public Document getForm() {
        return document;
    }

    public Document getDocument() {
        return getForm();
    }

    private NullRestriction accountNullRestriction = new NullRestriction("account");

    public NullRestriction getAccountNullRestriction() {
        return accountNullRestriction;
    }

    @Override
    public List<NullRestriction> getNullRestrictions() {
        List<NullRestriction> result = newArrayList();
        result.add(accountNullRestriction);
        return result;
    }
}