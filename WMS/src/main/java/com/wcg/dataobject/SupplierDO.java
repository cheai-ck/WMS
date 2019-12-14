package com.wcg.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDO {
    private Integer supplierId;

    private String supplierName;

    private String supplierPerson;

    private String supplierTel;

    private String supplierEmail;

    private String supplierAddress;

    private Date supplierCreatedate;


}