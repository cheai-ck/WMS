package com.wcg.dataobject;

import lombok.*;

import java.math.BigDecimal;

@Data
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