package com.softuni.ebank.controllers;

import com.softuni.ebank.bindingModels.BankAccountBindingModel;
import com.softuni.ebank.services.BankAccountService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccount(Model model,
                                    @ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel,
                                    Principal principal){
        bankAccountBindingModel.setUsername(principal.getName());

        model.addAttribute("view", "accounts/create-account");
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

        return "fragments/layout";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccountConfirm(Model model,
                                    @ModelAttribute("bankAccountBindingModel")BankAccountBindingModel bankAccountBindingModel){

        if(!this.bankAccountService.createAccount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/create-account");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            return "fragments/layout";
        }

        return "redirect:/home";
    }

    @GetMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deposit(Model model,
                          @PathVariable("id") Long id){
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);

        model.addAttribute("view", "accounts/deposit");
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

        return "fragments/layout";
    }

    @PostMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String depositConfirm(Model model,
                          @PathVariable("id") Long id,
                          @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel){
        if(!this.bankAccountService.depositAmount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/deposit");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

            return "fragments/layout";
        }

        return "redirect:/home";
    }


    @GetMapping("/withdraw/{id}")
    @PreAuthorize("isAuthenticated()")
    public String withdraw(Model model,
                          @PathVariable("id") Long id){
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);

        model.addAttribute("view", "accounts/withdraw");
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

        return "fragments/layout";
    }

    @PostMapping("/withdraw/{id}")
    @PreAuthorize("isAuthenticated()")
    public String withdrawConfirm(Model model,
                                 @PathVariable("id") Long id,
                                 @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel){
        if(!this.bankAccountService.withdrawAmount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/withdraw");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

            return "fragments/layout";
        }

        return "redirect:/home";
    }

    @GetMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transfer(Model model, @PathVariable("id") Long id){
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);

        model.addAttribute("view", "accounts/transfer");
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("bankAccounts", this.bankAccountService.getAllById(id));

        return "fragments/layout";
    }


    @PostMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transferConfirm(Model model,
                                  @PathVariable("id") Long id,
                                  @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel){
        if(!this.bankAccountService.transferAmount(bankAccountBindingModel)){
            model.addAttribute("view", "accounts/transfer");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            model.addAttribute("bankAccounts", this.bankAccountService.getAllById(id));

//            return "fragments/layout";
        }

        return "redirect:/home";

    }
}
