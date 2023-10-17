package com.example.itgexam.account.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TransactionConstants {

    public static final Integer TRANS_CODE_CREATED_SUCCESSFUL = 201;
    public static final Integer TRANS_CODE_BAD_REQUEST = 400;
    public static final Integer TRANS_CODE_NOT_FOUND = 401;
    public static final Integer TRANS_CODE_FOUND = 302;
    public static final Integer TRANS_CODE_DUPPLICATE = 409;

    public static final String TRANS_CUSTOMER_CREATED_SUCCESSFUL = "Customer account created";
    public static final String TRANS_EMAIL_BAD_REQUEST = "Email is required field";
    public static final String TRANS_CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String TRANS_CUSTOMER_FOUND = "Customer Account found";
    public static final String TRANS_CUSTOMER_DUPPLICATE_EMAIL = "Email already exist.";
}
