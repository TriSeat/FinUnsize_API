package finunsize.finunsizeapi.integration.auth.token;

import finunsize.finunsizeapi.persistence.repository.user.LocalUserRepository;
import finunsize.finunsizeapi.persistence.repository.user.PlanUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TokenChain extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final  PlanUserRepository planUserRepository;
    private final LocalUserRepository localUserRepository;

    @Autowired
    public TokenChain (TokenService tokenService, PlanUserRepository planUserRepository, LocalUserRepository localUserRepository) {
        this.tokenService = tokenService;
        this.planUserRepository = planUserRepository;
        this.localUserRepository = localUserRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.saveToken(request);

        String username = tokenService.confirmToken(token);
        UserDetails user = findUser(username);

        if (user != null) {
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String saveToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private UserDetails findUser(String username) {
        UserDetails user = localUserRepository.findByNome(username);
        if (user == null) {
            user = planUserRepository.findByNome(username);
        }
        return user;
    }
}
