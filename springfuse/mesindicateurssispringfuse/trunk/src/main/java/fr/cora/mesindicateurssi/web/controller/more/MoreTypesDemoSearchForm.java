/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/web/controller/SearchForm.e.vm.java
 */
package fr.cora.mesindicateurssi.web.controller.more;

import static com.google.common.collect.Lists.newArrayList;

import static fr.cora.mesindicateurssi.domain.more.MoreTypesDemo_.*;
import java.io.Serializable;
import java.util.List;
import fr.cora.mesindicateurssi.domain.more.MoreTypesDemo;
import fr.cora.mesindicateurssi.repository.support.NullRestriction;
import fr.cora.mesindicateurssi.repository.support.Range;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeBigDecimal;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeBigInteger;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeDate;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeDouble;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeFloat;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeInteger;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeLocalDate;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeLocalDateTime;
import fr.cora.mesindicateurssi.repository.support.Ranges.RangeLong;
import fr.cora.mesindicateurssi.repository.support.SearchForm;

/**
 * SearchForm for {@link MoreTypesDemoService}
 */
public class MoreTypesDemoSearchForm extends SearchForm<MoreTypesDemo> implements Serializable {
    private static final long serialVersionUID = 1L;

    private MoreTypesDemo moreTypesDemo = new MoreTypesDemo();
    private RangeInteger<MoreTypesDemo> numberIntRange = new RangeInteger<MoreTypesDemo>(numberInt);
    private RangeLong<MoreTypesDemo> numberLongRange = new RangeLong<MoreTypesDemo>(numberLong);
    private RangeDouble<MoreTypesDemo> numberDoubleRange = new RangeDouble<MoreTypesDemo>(numberDouble);
    private RangeFloat<MoreTypesDemo> numberFloatRange = new RangeFloat<MoreTypesDemo>(numberFloat);
    private RangeBigInteger<MoreTypesDemo> numberBigIntegerRange = new RangeBigInteger<MoreTypesDemo>(numberBigInteger);
    private RangeBigDecimal<MoreTypesDemo> numberBigDecimalRange = new RangeBigDecimal<MoreTypesDemo>(numberBigDecimal);
    private RangeDate<MoreTypesDemo> dateJavaTemporalDateRange = new RangeDate<MoreTypesDemo>(dateJavaTemporalDate);
    private RangeDate<MoreTypesDemo> dateJavaTemporalTimestampRange = new RangeDate<MoreTypesDemo>(
            dateJavaTemporalTimestamp);
    private RangeLocalDate<MoreTypesDemo> dateJodaRange = new RangeLocalDate<MoreTypesDemo>(dateJoda);
    private RangeLocalDateTime<MoreTypesDemo> dateTimeJodaRange = new RangeLocalDateTime<MoreTypesDemo>(dateTimeJoda);

    /**
     * The root moreTypesDemo for search by example.
     * Used from the view.
     */
    @Override
    public MoreTypesDemo getForm() {
        return moreTypesDemo;
    }

    public MoreTypesDemo getMoreTypesDemo() {
        return getForm();
    }

    // Ranges, used from the view.

    public RangeInteger<MoreTypesDemo> getNumberIntRange() {
        return numberIntRange;
    }

    public RangeLong<MoreTypesDemo> getNumberLongRange() {
        return numberLongRange;
    }

    public RangeDouble<MoreTypesDemo> getNumberDoubleRange() {
        return numberDoubleRange;
    }

    public RangeFloat<MoreTypesDemo> getNumberFloatRange() {
        return numberFloatRange;
    }

    public RangeBigInteger<MoreTypesDemo> getNumberBigIntegerRange() {
        return numberBigIntegerRange;
    }

    public RangeBigDecimal<MoreTypesDemo> getNumberBigDecimalRange() {
        return numberBigDecimalRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalDateRange() {
        return dateJavaTemporalDateRange;
    }

    public RangeDate<MoreTypesDemo> getDateJavaTemporalTimestampRange() {
        return dateJavaTemporalTimestampRange;
    }

    public RangeLocalDate<MoreTypesDemo> getDateJodaRange() {
        return dateJodaRange;
    }

    public RangeLocalDateTime<MoreTypesDemo> getDateTimeJodaRange() {
        return dateTimeJodaRange;
    }

    @Override
    public List<Range<MoreTypesDemo, ?>> getRanges() {
        List<Range<MoreTypesDemo, ?>> result = newArrayList();
        result.add(getNumberIntRange());
        result.add(getNumberLongRange());
        result.add(getNumberDoubleRange());
        result.add(getNumberFloatRange());
        result.add(getNumberBigIntegerRange());
        result.add(getNumberBigDecimalRange());
        result.add(getDateJavaTemporalDateRange());
        result.add(getDateJavaTemporalTimestampRange());
        result.add(getDateJodaRange());
        result.add(getDateTimeJodaRange());
        return result;
    }

    @Override
    public List<NullRestriction> getNullRestrictions() {
        List<NullRestriction> result = newArrayList();
        return result;
    }
}