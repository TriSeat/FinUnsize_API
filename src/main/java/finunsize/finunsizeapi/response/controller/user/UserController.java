package finunsize.finunsizeapi.response.controller.user;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserLogin;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserResponse;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserSign;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserUpdate;
import finunsize.finunsizeapi.business.service.user.plan.UserService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.integration.auth.token.TokenService;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
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
@RequestMapping("user")
public class PlanUserController {

    private final AuthenticationManager authenticationManager;
    private final UserService planUserService;
    private final TokenService tokenService;
    private final UserSession userSession;

    @Autowired
    public PlanUserController(AuthenticationManager authenticationManager, UserService planUserService, TokenService tokenService, UserSession userSession) {
        this.authenticationManager = authenticationManager;
        this.planUserService = planUserService;
        this.tokenService = tokenService;
        this.userSession = userSession;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid PlanUserLogin planUserDTO) {
        var credentials = new UsernamePasswordAuthenticationToken(planUserDTO.nome(), planUserDTO.password());
        var auth = this.authenticationManager.authenticate(credentials);
        String token = tokenService.tokenGeneration((UserDetails) auth.getPrincipal());

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("signup")
    public ResponseEntity sign(@RequestBody @Valid PlanUserSign planUserSignDTO) {
        planUserService.signUp(planUserSignDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @GetMapping("credentials")
    public ResponseEntity<PlanUserResponse> list() throws ContextNullException {
        String login = userSession.getCurrentLogin();
        var user = planUserService.findUser(login);
        return ResponseEntity.ok(user);
    }


    @PutMapping("update/{cnpj}")
    public ResponseEntity updatePlanUser(@PathVariable String cnpj,@RequestBody @Valid PlanUserUpdate planUserUpdate) {
        UserModel updatedUser = planUserService.updateUser(cnpj, planUserUpdate);
        return ResponseEntity.ok("Usuário Atualizado");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id) {
        planUserService.deleteUser(n);
        return ResponseEntity.ok("Usuário da empresa " + cnpj + " excluído com sucesso");
    }
}
