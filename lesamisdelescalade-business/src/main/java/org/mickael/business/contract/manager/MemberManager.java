package org.mickael.business.contract.manager;

import org.mickael.model.bean.Member;
import org.mickael.model.exceptions.MemberBlockedException;

import java.util.List;

public interface MemberManager {
    void createMember(Member member);
    Member findMember(Integer id);
    void updateMember(Member member);
    void deleteMember(Integer id);
    List<Member> findAllMember ();
    Member findMemberByProperty(String propertyName, Object propertyValue) throws MemberBlockedException;
    void changeAccountStatus(Integer id, boolean enabled);
    Boolean isPseudoExist(String pseudo);
    List<Member> findAllMemberByProperty(String propertyName, Object propertyValue);
}
