package com.innter.ms.people.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_people")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 702931822740926243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fi_id")
    private Long id;

    @NotNull
    @Column(name = "fc_name")
    private String name;

    @NotNull
    @Column(name = "fc_last_name")
    private String lastName;

    @NotNull
    @Column(name = "fc_surname")
    private String surname;

    @NotNull
    @Column(name = "fc_gender")
    private String gender;

    @NotNull
    @Column(name = "fd_birthdate")
    private LocalDate birthDate;

    @NotBlank
    @Email
    @Column(name = "fc_email")
    private String email;

    @NotNull
    @Size(min=10, max=13)
    @Column(name = "fc_cellphone")
    private String cellphone;

    @NotNull
    @Column(name = "fc_phone")
    private String phone;

    @ToString.Exclude
    @OneToOne(mappedBy = "person" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AddressEntity address;

}