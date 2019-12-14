package com.wcg.dataobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDO {
    private Integer cargoId;

    private String cargoName;

    private String cargoDescription;

    private Integer weight;

    private BigDecimal purchasingCost;

    private BigDecimal vipPrice;

    private BigDecimal retailPrice;

    private String cargoImgAdd;


}