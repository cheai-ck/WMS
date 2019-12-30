package com.wcg.dataobject;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDO implements Serializable {
    private Integer supplierId;

    private String supplierName;

    private String supplierPerson;

    private String supplierTel;

    private String supplierEmail;

    private String supplierAddress;

    private Date supplierCreatedate;


}