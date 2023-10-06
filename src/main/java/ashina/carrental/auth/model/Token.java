package ashina.carrental.auth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    private String accessToken;
    private Long accessTokenExpiresAt;
    private String refreshToken;

    private static final String TOKEN_PREFIX = "Bearer ";

    public static boolean isBearerToken(String authorizationHeader) {
        return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(TOKEN_PREFIX);
    }

    public static String getJwt(String authorizationHeader) {
        return authorizationHeader.replace(TOKEN_PREFIX, "");
    }

}
