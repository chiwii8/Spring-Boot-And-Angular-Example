package app.service;

import app.entity.UserAccount;
import app.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserDetailsServiceCustom(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccount> findAll(){
        return this.userAccountRepository.findAll();
    }

    public UserAccount save(UserAccount userAccount){
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = this.userAccountRepository.findByUsername(username);

        if(userAccount.isPresent()){
            UserAccount userAccount1 = userAccount.get();
            userAccount1.setActive(true);
            this.userAccountRepository.save(userAccount1);
            return userAccount1;
        }
        throw new UsernameNotFoundException("The username is not found");
    }


}