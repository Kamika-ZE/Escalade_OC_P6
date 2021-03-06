package org.mickael.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mickael.business.contract.manager.EnumManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Member;
import org.mickael.model.enumeration.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Inject
    private MemberManager memberManager;

    @Inject
    private EnumManager enumManager;


    @GetMapping("/showMemberList")
    public String showMemberList(@SessionAttribute(value = "memberInSessionId" , required = false) Integer memberInSessionId, Model model){
        logger.debug("AdminController showMemberList");
        Member memberInBddAdmin = memberManager.findMember(memberInSessionId);
        if (!memberInBddAdmin.getRole().equals(Role.ADMIN.getParam())){
            logger.debug("role : " + memberInBddAdmin.getRole());
            return "redirect:/showHome";
        }
        List<Member> memberList = new ArrayList<>();
        if (memberInBddAdmin.getRole().equals(Role.ADMIN.getParam())){
            memberList = memberManager.findAllMember();
        }
        model.addAttribute("memberList", memberList);
        return "memberListPage";
    }


    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId" , required = false) Integer memberInSessionId, Model model){
        logger.debug("AdminController deleteMember");
        Member memberInBddAdmin = memberManager.findMember(memberInSessionId);
        if (!memberInBddAdmin.getRole().equals(Role.ADMIN.getParam())){
            logger.debug("Bad role or no Id");
            return "redirect:/showHome";
        }
        memberManager.deleteMember(id);

        return "redirect:/memberListPage";
    }


    @GetMapping("/editMemberAdmin/{id}")
    public String showMemberUpdateForm(@PathVariable("id") Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){

        Member memberInBddAdmin = memberManager.findMember(memberInSessionId);
        if (!memberInBddAdmin.getRole().equals(Role.ADMIN.getParam())){
            logger.debug("Bad role or no Id");
            return "redirect:/showHome";
        }

        Member memberToUpdate = memberManager.findMember(id);
        model.addAttribute("roleList", enumManager.getEnumRoleStringValues());
        model.addAttribute("memberToUpdate", memberToUpdate);
        return "updateMemberFormAdmin";
    }

    @PostMapping("/editMemberAdmin/updateMemberAdminProcess/{id}")
    public String updateMember(@Valid Member member, @PathVariable("id") Integer id, Model model, @SessionAttribute(value = "memberInSessionId" , required = false) Integer memberInSessionId,
                               BindingResult bindingResult){
        logger.debug("AdminController updateMemberAdminProcess");
        Member memberInBddAdmin = memberManager.findMember(memberInSessionId);
        if (!memberInBddAdmin.getRole().equals(Role.ADMIN.getParam())){
            logger.debug("Bad role or no Id");
            return "redirect:/showHome";
        }
        if (bindingResult.hasErrors()){
            System.out.println("erreur binding");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            String str = "Une erreur est survenue. Vérifiez les champs.";
            model.addAttribute("memberToUpdate", member);
            model.addAttribute("errorMessage", str);
            return "updateMemberForm";
        } else {
            Member memberInBdd = memberManager.findMember(id);
            member.setGender(memberInBdd.getGender());
            member.setFirstName(memberInBdd.getFirstName());
            member.setLastName(memberInBdd.getLastName());
            member.setPseudo(memberInBdd.getPseudo());
            member.setEmail(memberInBdd.getEmail());
            member.setPassword(memberInBdd.getPassword());

            memberManager.updateMember(member);

            model.addAttribute("memberInSessionId", memberInSessionId);
            return "redirect:/showMemberList";
        }
    }
}
