package jussics.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="userregister")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  fullname;
    @Column(unique = true)
    private String  username;
    private String  email;
    private String  role;
    private String  password;
    private String  confirmPassword;
    //private Long  contract;
    private String token;
}
