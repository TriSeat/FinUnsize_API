package finunsize.finunsizeapi.persistence.model.user;

public enum Role {

    ADMIN_PLAN("Admin"),
    CASHIER("caixa"),
    MANAGER("gerente");

    private String role;

     Role(String role) {
         this.role = role;
     }

     public String getRole() {
         return this.role;
     }

}
