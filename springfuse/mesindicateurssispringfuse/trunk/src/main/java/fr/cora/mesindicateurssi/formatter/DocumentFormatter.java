/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/formatter/Formatter.e.vm.java
 */
package fr.cora.mesindicateurssi.formatter;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.ParseException;
import java.util.Locale;

import fr.cora.mesindicateurssi.domain.Document;
import fr.cora.mesindicateurssi.repository.DocumentRepository;
import fr.cora.mesindicateurssi.formatter.support.DiscoverableFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Formatter} for {@link Document} that is picked by automatically by {@link CustomFormattingConversionServiceFactory}
 *
 * @see Formatter
 * @see CustomFormattingConversionServiceFactory
 */
@Component
public class DocumentFormatter implements DiscoverableFormatter<Document> {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Class<Document> getTarget() {
        return Document.class;
    }

    @Override
    public String print(Document document, Locale locale) {
        if (document == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // make a nice display string here...

        if (document.getDocumentContentType() != null) {
            sb.append(document.getDocumentContentType()).append(" ");
        }

        if (document.getDocumentFileName() != null) {
            sb.append(document.getDocumentFileName()).append(" ");
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else if (document.isNew()) {
            return document.getId();
        } else {
            return document.toString();
        }
    }

    @Override
    public Document parse(String text, Locale locale) throws ParseException {
        if (isBlank(text)) {
            return new Document();
        }
        Document document = documentRepository.findOne(text);
        return document != null ? document : new Document();
    }
}
