package istad.co.darambbankingapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Account owner;

    @ManyToOne
    @JoinColumn(name = "transfer_receiver_id")
    private Account transferReceiver; //user when transactionType is transfer

    private String paymentReceiver; //pay on water, electric, or school payment(get id)

    private BigDecimal amount;

    @Column(columnDefinition = "TEXT")
    private String remark;

    @Column(nullable = false,length = 30)
    private String transactionType; // transfer and payment

    private Boolean status; // pending, completed, failed

    private Boolean isPayment;

    private LocalDateTime transactionAt;

}
