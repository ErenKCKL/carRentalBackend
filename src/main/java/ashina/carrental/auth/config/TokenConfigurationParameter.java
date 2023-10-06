package ashina.carrental.auth.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PrivateKey;
import java.security.PublicKey;


@Configuration
@Getter
@Slf4j
public class TokenConfigurationParameter {


    private final String issuer;

    private final Integer accessTokenExpireMinute;

    private final Integer refreshTokenExpireDay;

    private final PrivateKey privateKey;

    private final PublicKey publicKey;

    public TokenConfigurationParameter(){

    }


}
