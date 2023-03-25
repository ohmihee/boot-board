package com.mihee.board.domain.vo;

public enum UserRole {
    SUPER("SUPER"),
    PUBLIC("PUBLIC")
    ;

    private String userRole;

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public static UserRole findUserRole(String userRole) {
        for(UserRole role: UserRole.values()) {
            if(role.equals(userRole)) {
                return role;
            }
        }
        throw new RuntimeException();
    }
}
