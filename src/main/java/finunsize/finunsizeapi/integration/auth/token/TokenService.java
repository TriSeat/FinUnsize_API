package finunsize.finunsizeapi.integration.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretPass;

    public String tokenGeneration(UserDetails userDetails) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretPass);
            String token = JWT.create()
                    .withIssuer("finunsizeapi")
                    .withSubject(userDetails.getUsername())
                    .withExpiresAt(createExpiration())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception) {
            throw new RuntimeException("Error in generation token", exception);
        }
    }

    public String confirmToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretPass);
            return  JWT.require(algorithm)
                    .withIssuer("finunsizeapi")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant createExpiration() {
        return Instant.now().plus(Duration.ofHours(3));
    }
}
