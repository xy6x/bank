package com.example.bankmang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Integer cus_id;
    private Integer accountNumber;
    private double balance;
    private  Boolean asActive;
}
