package dev.alexengrig.sample.customer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @SequenceGenerator(name = "customer_id_seq")
    @GeneratedValue(generator = "customer_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

}
