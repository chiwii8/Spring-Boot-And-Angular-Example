package app.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;

@Entity
public class UserAccount implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    public UserAccount(){
        authorities = new ArrayList<>();
        this.isActive = false;
    }


    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.authorities = AuthorityUtils.createAuthorityList(Authority.USER_KEY);
        this.isActive = false;
    }

    public UserAccount(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(GrantedAuthority authority){
        authorities.add(authority);
    }



    public static UserAccountBuilder builder(){
        return new UserAccountBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * This class is a builder class for UserAccount to let us create more easy the UserDetails example.
     */
    public static final class UserAccountBuilder{

        private String username;
        private String password;
        private final List<GrantedAuthority> authorities;

        public UserAccountBuilder(){
            authorities = new ArrayList<>();
        }

        public UserAccountBuilder username(String username){
            this.username = username;
            return this;
        }

        public UserAccountBuilder password(String password){
            this.password = password;
            return this;
        }

        public UserAccountBuilder password(UnaryOperator<String> encode){
            if(this.password!=null){
                this.password= encode.apply(this.password);
            }
            return this;
        }

        public UserAccountBuilder role(String role){
            GrantedAuthority authority = new Authority(role);
            this.authorities.add(authority);
            return this;
        }

        public UserAccountBuilder roles(String ... roles){
            for(String role: roles){
                GrantedAuthority authority = new Authority(role);
                this.authorities.add(authority);
            }
            return this;
        }

        public UserAccount build(){
            String pass = password;
            return new UserAccount(username,pass,authorities);
        }

    }
}
