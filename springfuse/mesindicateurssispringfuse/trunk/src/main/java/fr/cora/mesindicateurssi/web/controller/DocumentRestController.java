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
import fr.cora.mesindicateurssi.domain.Document;
import fr.cora.mesindicateurssi.repository.DocumentRepository;

@Controller
@RequestMapping("domain/rest/document/")
public class DocumentRestController {
    @Autowired
    public FormattingConversionService formattingConversionService;

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/", method = POST)
    @ResponseBody
    public Document create(@Valid Document document) {
        documentRepository.save(document);
        return document.copy();
    }

    @RequestMapping(value = "/", method = POST, headers = "content-type:application/json")
    @ResponseBody
    public Document jsonCreate(@Valid @RequestBody Document document) {
        documentRepository.save(document);
        return document.copy();
    }

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public List<Document> list(Document document, SearchParameters searchParameters) {
        Page<Document> page = documentRepository.findWithExample(document, searchParameters.toPageRequest());
        List<Document> ret = newArrayList();
        for (Document _document : page.getContent()) {
            ret.add(_document.copy());
        }
        return ret;
    }

    @RequestMapping(value = "/{pk}", method = GET)
    @ResponseBody
    public Document get(@PathVariable("pk") Document document) {
        return document.copy();
    }

    @RequestMapping(value = "/{pk}", method = PUT)
    @ResponseBody
    public Document update(@PathVariable("pk") Document documentToUpdate, @Valid Document document) {
        document.copyTo(documentToUpdate);
        documentRepository.save(documentToUpdate);
        return documentToUpdate.copy();
    }

    @RequestMapping(value = "/{pk}", method = DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("pk") Document document) {
        documentRepository.delete(document);
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
        for (Document document : documentRepository.find(search.getSearchPattern())) {
            String objectPk = document.getId().toString();
            String objectLabel = formattingConversionService.convert(document, String.class);
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