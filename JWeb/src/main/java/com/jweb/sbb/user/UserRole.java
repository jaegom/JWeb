package com.jweb.sbb.user;

import lombok.Getter;

/**
 * 스프링 시큐리티는 인증 뿐만 아니라 권한도 관리한다. 따라서 인증후에 사용자에게 부여할 권한이 필요하다. 
 * 다음과 같이 ADMIN, USER 2개의 권한을 갖는 UserRole을 신규로 작성하자.
 */


@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}
