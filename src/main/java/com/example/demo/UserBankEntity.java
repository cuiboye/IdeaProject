package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Component
@Table(name = "banknumber", schema = "money", catalog = "")
public class UserBankEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bankcardid")
    private int bankcardid;
    @Basic
    @Column(name = "bankName")
    private String bankName;
    @Basic
    @Column(name = "bankCardNumber")
    private String bankCardNumber;
    @Basic
    @Column(name = "ownerName")
    private String ownerName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBankEntity that = (UserBankEntity) o;
        return bankcardid == that.bankcardid && Objects.equals(bankName, that.bankName) && Objects.equals(bankCardNumber, that.bankCardNumber) && Objects.equals(ownerName, that.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankcardid, bankName, bankCardNumber, ownerName);
    }
}
