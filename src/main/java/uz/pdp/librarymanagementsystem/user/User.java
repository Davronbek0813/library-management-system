package uz.pdp.librarymanagementsystem.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.librarymanagementsystem.role.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String role= Role.USER.name();
}
