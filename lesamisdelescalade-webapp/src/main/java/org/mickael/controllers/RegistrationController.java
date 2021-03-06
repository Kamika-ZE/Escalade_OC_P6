package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.Member;
import org.mickael.model.enumeration.Role;
import org.mickael.model.exceptions.MemberBlockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private MemberManager memberManager;


    @GetMapping("/doRegister")
    public String viewRegistration(@SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        if (memberInSessionId != null){
            return "redirect:/home";
        }
        model.addAttribute("member", new Member());

        return "registration";
    }

    @PostMapping("/registrationProcess")
    public String saveNewMember(@Valid Member newMember, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId) throws MemberBlockedException {
        Member existingMember = memberManager.findMemberByProperty("email", newMember.getEmail());

        if (existingMember != null){
            String str = "Erreur, veuillez recommencer.";
            model.addAttribute("errorMessage", str);
            return "registration";
        } else {
            if (bindingResult.hasErrors()) {
                return "registration";
            }
            //encoder
            String hashPassword = passwordManager.hashPassword(newMember.getPassword());
            newMember.setPassword(hashPassword);
            newMember.setRole(Role.USER.getParam());
            newMember.setEnabled(true);
            memberManager.createMember(newMember);

            model.addAttribute("message", "Member register successfully.");
            model.addAttribute("member", newMember);

            return "redirect:/showHome";
        }
    }

}
