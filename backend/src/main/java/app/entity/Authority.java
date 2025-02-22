package app.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Implementation of the Interface GrantedAuthority that let us create our Authorities
 */
public class Authority implements GrantedAuthority {

    public static final String USER_KEY = "USER";
    public static final String ADMIN_KEY = "ADMIN";


    private String nameAuthority;

    public Authority(String nameAuthority) {
        this.nameAuthority = nameAuthority;
    }

    public void setNameAuthority(String nameAuthority){
        this.nameAuthority = nameAuthority;
    }

    @Override
    public String getAuthority() {
        return nameAuthority;
    }
}