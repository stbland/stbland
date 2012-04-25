/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3-sd:src/main/java/web/controller/controller.e.vm.java
 */
package fr.cora.mesindicateurssi.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cora.mesindicateurssi.domain.Address;
import fr.cora.mesindicateurssi.repository.AddressRepository;

@Controller
@RequestMapping("/domain/address/")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * Performs the list action.
     */
    @RequestMapping( { "", "list" })
    public String list(@ModelAttribute AddressSearchForm addressSearchForm, Model model) {
        Page<Address> page = addressRepository.find(addressSearchForm);
        model.addAttribute("addressesCount", page.getTotalElements());
        model.addAttribute("addresses", page.getContent());
        return "domain/address/list";
    }

    /**
     * Serves the create form.
     */
    @RequestMapping(value = "create", method = GET)
    public String create(@ModelAttribute Address address) {
        return "domain/address/create";
    }

    /**
     * Performs the create action and redirect to the show view.
     */
    @RequestMapping(value = "create", method = { POST, PUT })
    public String create(@Valid @ModelAttribute Address address, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return create(address);
        }

        addressRepository.save(address);
        return "redirect:/domain/address/show/" + address.getId();
    }

    /**
     * Serves search by example form, search by pattern form and search by named query form.
     */
    @RequestMapping(value = "*", method = GET)
    public void catchAll(@ModelAttribute AddressSearchForm addressSearchForm) {
    }

}