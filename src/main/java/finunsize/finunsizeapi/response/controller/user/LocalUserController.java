package finunsize.finunsizeapi.response.controller.user;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserLogin;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserResponse;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserSign;
import finunsize.finunsizeapi.business.service.user.local.LocalUserService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.integration.auth.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("local")
public class LocalUserController {


    private final AuthenticationManager authenticationManager;
    private final LocalUserService localUserService;
    private final TokenService tokenService;
    private final UserSession userSession;

    @Autowired
    public LocalUserController(AuthenticationManager authenticationManager, LocalUserService localUserService, TokenService tokenService, UserSession userSession) {
        this.authenticationManager = authenticationManager;
        this.localUserService = localUserService;
        this.tokenService = tokenService;
        this.userSession = userSession;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid LocalUserLogin localUserLogin) {
        var credentials = new UsernamePasswordAuthenticationToken(localUserLogin.nome(), localUserLogin.password());
        var auth = this.authenticationManager.authenticate(credentials);
        var token = tokenService.tokenGeneration((UserDetails) auth.getPrincipal());

        return  ResponseEntity.ok().body(token);
    }

    @PostMapping("signup")
    public ResponseEntity sign(@RequestBody @Valid LocalUserSign localUserSign) throws ContextNullException {
        String cnpj = userSession.getSessionCnpj();
        localUserService.signup(localUserSign, cnpj);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @GetMapping("credentials")
    public ResponseEntity<LocalUserResponse> list() throws ContextNullException {
        UUID id = userSession.getUUID();
        var user = localUserService.findUser(id);
        return ResponseEntity.ok(user);
    }

}