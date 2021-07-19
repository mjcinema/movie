package com.icia.mjcinema.domain;

import lombok.*;

@EqualsAndHashCode(of={"authority"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Authority {
    private String username;
    private String authority;

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
}
