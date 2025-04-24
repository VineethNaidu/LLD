package org.example.lld.casestudies.parkinglot.model;

import java.util.Date;

public class Payment extends BaseModel {
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Bill bill;
    private String referenceId;
    private Date paymentTime;
}
