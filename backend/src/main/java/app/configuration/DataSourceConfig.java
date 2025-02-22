package app.configuration;


import app.entity.Authority;
import app.entity.UserAccount;
import app.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final Environment env;

    @Autowired
    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url(env.getRequiredProperty("spring.datasource.url"));
        dataSourceBuilder.username(env.getRequiredProperty("spring.datasource.username"));
        dataSourceBuilder.password(env.getRequiredProperty("spring.datasource.password"));
        dataSourceBuilder.driverClassName(env.getRequiredProperty("spring.datasource.driverClassName"));

        return  dataSourceBuilder.build();
    }


    @Bean
    public CommandLineRunner commandLineRunner(UserAccountRepository userAccountRepository){
        return args -> {
            UserAccount userAccount1 = new UserAccount("Pepito","papaya", AuthorityUtils.createAuthorityList(Authority.USER_KEY));
            UserAccount userAccount2 = new UserAccount("Pedro","pepino",AuthorityUtils.createAuthorityList(Authority.USER_KEY));

            userAccountRepository.save(userAccount1);
            userAccountRepository.save(userAccount2);

            System.out.println("Datos Añadidos.");
        };
    }


}