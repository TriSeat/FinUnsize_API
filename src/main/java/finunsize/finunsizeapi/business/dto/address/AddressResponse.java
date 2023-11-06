package finunsize.finunsizeapi.business.dto.address;

import java.util.UUID;

public record AddressResponse (
        UUID id_logradouro,
        int cep,
        String rua,
        String numero,
        String complemento,
        String referencia,
        String cidade
) {}

