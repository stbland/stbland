/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/formatter/Formatter.e.vm.java
 */
package fr.cora.mesindicateurssi.formatter.more;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.text.ParseException;
import java.util.Locale;

import fr.cora.mesindicateurssi.domain.more.MoreTypesDemo;
import fr.cora.mesindicateurssi.repository.more.MoreTypesDemoRepository;
import fr.cora.mesindicateurssi.formatter.support.DiscoverableFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Formatter} for {@link MoreTypesDemo} that is picked by automatically by {@link CustomFormattingConversionServiceFactory}
 *
 * @see Formatter
 * @see CustomFormattingConversionServiceFactory
 */
@Component
public class MoreTypesDemoFormatter implements DiscoverableFormatter<MoreTypesDemo> {

    @Autowired
    private MoreTypesDemoRepository moreTypesDemoRepository;

    @Override
    public Class<MoreTypesDemo> getTarget() {
        return MoreTypesDemo.class;
    }

    @Override
    public String print(MoreTypesDemo moreTypesDemo, Locale locale) {
        if (moreTypesDemo == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // make a nice display string here...

        if (moreTypesDemo.getNumberInt() != null) {
            sb.append(moreTypesDemo.getNumberInt()).append(" ");
        }

        if (moreTypesDemo.getNumberLong() != null) {
            sb.append(moreTypesDemo.getNumberLong()).append(" ");
        }

        if (moreTypesDemo.getNumberDouble() != null) {
            sb.append(moreTypesDemo.getNumberDouble()).append(" ");
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else if (moreTypesDemo.isNew()) {
            return moreTypesDemo.getId().toString();
        } else {
            return moreTypesDemo.toString();
        }
    }

    @Override
    public MoreTypesDemo parse(String text, Locale locale) throws ParseException {
        if (isBlank(text)) {
            return new MoreTypesDemo();
        }
        MoreTypesDemo moreTypesDemo = moreTypesDemoRepository.findOne(new Integer(text));
        return moreTypesDemo != null ? moreTypesDemo : new MoreTypesDemo();
    }
}
