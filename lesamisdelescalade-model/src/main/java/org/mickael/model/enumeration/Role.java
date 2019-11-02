package org.mickael.model.enumeration;

public enum Role {

    ADMIN("Administrator"), MEMBER("Member"), USER("User");

    private String param;

    private Role(String param){
        this.param = param;
    }

    public String getParam(){
        return this.param;
    }
}
