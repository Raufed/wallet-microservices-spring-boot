package by.raufpayzov.entity;

import by.raufpayzov.enums.CurrencyEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Currency;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Piggy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated
    @Column(name = "currency")
    private CurrencyEnum currency;

    @Column(name = "balance")
    private double balance;

}
