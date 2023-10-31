package finunsize.finunsizeapi.response.controller.user;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.main.UserLogin;
import finunsize.finunsizeapi.business.dto.user.main.UserResponse;
import finunsize.finunsizeapi.business.dto.user.main.UserSign;
import finunsize.finunsizeapi.business.dto.user.main.UserUpdate;
import finunsize.finunsizeapi.business.service.user.main.UserService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.integration.auth.token.TokenService;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;
    private final UserSession userSession;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserService userService, TokenService tokenService, UserSession userSession) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
        this.userSession = userSession;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid UserLogin planUserDTO) {
        var credentials = new UsernamePasswordAuthenticationToken(planUserDTO.login(), planUserDTO.password());
        var auth = this.authenticationManager.authenticate(credentials);
        String token = tokenService.tokenGeneration((UserModel) auth.getPrincipal());

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("signup")
    public ResponseEntity sign(@RequestBody @Valid UserSign planUserSignDTO) {
        userService.signUp(planUserSignDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @GetMapping("list")
    public ResponseEntity<List<UserResponse>> list() throws ContextNullException {
        var users = userService.listUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("credentials")
    public ResponseEntity<UserResponse> credentils() throws ContextNullException {
        var user = userService.findLogin();
        return ResponseEntity.ok(user);
    }

    @GetMapping("find/{username}")
    public  ResponseEntity<UserResponse> findUser(@PathVariable String username) throws ContextNullException {
        var user = userService.findUser(username);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity updatePlanUser(@PathVariable UUID id,@RequestBody @Valid UserUpdate planUserUpdate) {
        userService.updateUser(id, planUserUpdate);
        return ResponseEntity.ok("Usuário Atualizado");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuário da empresa " + id + " excluído com sucesso");
    }
}
