/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/web/controller/restController.e.vm.java
 */
package fr.cora.mesindicateurssi.web.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static com.google.common.collect.Lists.newArrayList;

import java.io.PrintWriter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.cora.mesindicateurssi.web.util.AutoCompleteResult;
import fr.cora.mesindicateurssi.repository.support.SearchParameters;
import fr.cora.mesindicateurssi.domain.Legacy;
import fr.cora.mesindicateurssi.repository.LegacyRepository;

@Controller
@RequestMapping("domain/rest/legacy/")
public class LegacyRestController {
    @Autowired
    public FormattingConversionService formattingConversionService;

    @Autowired
    private LegacyRepository legacyRepository;

    @RequestMapping(value = "/", method = POST)
    @ResponseBody
    public Legacy create(@Valid Legacy legacy) {
        legacyRepository.save(legacy);
        return legacy.copy();
    }

    @RequestMapping(value = "/", method = POST, headers = "content-type:application/json")
    @ResponseBody
    public Legacy jsonCreate(@Valid @RequestBody Legacy legacy) {
        legacyRepository.save(legacy);
        return legacy.copy();
    }

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public List<Legacy> list(Legacy legacy, SearchParameters searchParameters) {
        Page<Legacy> page = legacyRepository.findWithExample(legacy, searchParameters.toPageRequest());
        List<Legacy> ret = newArrayList();
        for (Legacy _legacy : page.getContent()) {
            ret.add(_legacy.copy());
        }
        return ret;
    }

    @RequestMapping(value = "/{pk}", method = GET)
    @ResponseBody
    public Legacy get(@PathVariable("pk") Legacy legacy) {
        return legacy.copy();
    }

    @RequestMapping(value = "/{pk}", method = PUT)
    @ResponseBody
    public Legacy update(@PathVariable("pk") Legacy legacyToUpdate, @Valid Legacy legacy) {
        legacy.copyTo(legacyToUpdate);
        legacyRepository.save(legacyToUpdate);
        return legacyToUpdate.copy();
    }

    @RequestMapping(value = "/{pk}", method = DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("pk") Legacy legacy) {
        legacyRepository.delete(legacy);
        return true;
    }

    @RequestMapping("/autocomplete")
    @ResponseBody
    public List<AutoCompleteResult> autocomplete(@RequestParam(value = "term", required = false) String searchPattern,
            SearchParameters search) {
        if (searchPattern != null && !searchPattern.isEmpty()) {
            search.setSearchPattern(searchPattern);
        }

        List<AutoCompleteResult> ret = newArrayList();
        for (Legacy legacy : legacyRepository.find(search.getSearchPattern())) {
            String objectPk = legacy.getId().toString();
            String objectLabel = formattingConversionService.convert(legacy, String.class);
            ret.add(new AutoCompleteResult(objectPk, objectLabel));
        }
        return ret;
    }

    @ExceptionHandler()
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public void exception(Exception e, PrintWriter out) {
        out.write(e.getMessage());
    }
}