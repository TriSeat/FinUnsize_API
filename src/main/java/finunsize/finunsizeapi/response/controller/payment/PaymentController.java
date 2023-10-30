package finunsize.finunsizeapi.response.controller.payment;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.integration.auth.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("sus/")
public class PaymentController {

    @Autowired
    UserSession userSession;

    @GetMapping("saas")
    public ResponseEntity asas() throws ContextNullException {

        String nome = userSession.getCurrentUsername();
        String cnpj = userSession.getSessionCnpj();
        UUID id = userSession.getUUID();

        return ResponseEntity.ok().body(nome + cnpj + id);
    }

}
