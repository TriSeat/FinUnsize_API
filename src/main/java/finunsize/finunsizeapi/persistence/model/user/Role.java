package finunsize.finunsizeapi.persistence.model.user;

public enum Role {

    MANAGER("GERENTE"),
    CASHIER("CAIXA");

    private String role;

     Role(String role) {
         this.role = role;
     }

     public String getRole() {
         return this.role;
     }

}
