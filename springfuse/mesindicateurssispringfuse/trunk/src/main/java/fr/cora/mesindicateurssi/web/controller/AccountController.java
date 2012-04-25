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

import fr.cora.mesindicateurssi.domain.Account;
import fr.cora.mesindicateurssi.repository.AccountRepository;
import fr.cora.mesindicateurssi.repository.RoleRepository;

@Controller
@RequestMapping("/domain/account/")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Performs the list action.
     */
    @RequestMapping( { "", "list" })
    public String list(@ModelAttribute AccountSearchForm accountSearchForm, Model model) {
        Page<Account> page = accountRepository.find(accountSearchForm);
        model.addAttribute("accountsCount", page.getTotalElements());
        model.addAttribute("accounts", page.getContent());
        return "domain/account/list";
    }

    /**
     * Serves the create form.
     */
    @RequestMapping(value = "create", method = GET)
    public String create(@ModelAttribute Account account, Model model) {
        bindListForSelectInputFields(model);
        return "domain/account/create";
    }

    /**
     * Performs the create action and redirect to the show view.
     */
    @RequestMapping(value = "create", method = { POST, PUT })
    public String create(@Valid @ModelAttribute Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return create(account, model);
        }

        accountRepository.save(account);
        return "redirect:/domain/account/show/" + account.getId();
    }

    /**
     * Serves search by example form, search by pattern form and search by named query form.
     */
    @RequestMapping(value = "*", method = GET)
    public void catchAll(@ModelAttribute AccountSearchForm accountSearchForm, Model model) {
        bindListForSelectInputFields(model);
    }

    /**
     * Binds to the passed model the possible values for select input fields.
     */
    private void bindListForSelectInputFields(Model model) {
        model.addAttribute("roles", roleRepository.find());
    }
}