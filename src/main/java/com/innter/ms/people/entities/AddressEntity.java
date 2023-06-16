package com.innter.ms.people.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tb_addresses")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fi_id")
    private Long id;

    @Column(name = "fc_street")
    private String street;

    @NotNull
    @Column(name = "fi_external_number")
    private int externalNumber;

    @Column(name = "fi_internal_number")
    private int internalNumber;

    @Column(name = "fc_colony")
    private String colony;

    @Column(name = "fc_municipality")
    private String municipality;

    @Column(name = "fc_city")
    private String city;

    @NotNull
    @Column(name = "fi_post_code")
    private int postCode;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fi_person_id", referencedColumnName = "fi_id")
    private PersonEntity person;
}