package domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "tb_account")
@Data
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    @Column(nullable = false, scale = 13, precision = 2)
    private BigDecimal balance;

    @Column(name = "special_limit", nullable = false, scale = 2, precision = 13)
    private BigDecimal limit;


}
