package com.wcg.dataobject;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDO implements Serializable {
    private Integer cargoId;

    private String cargoName;

    private String cargoDescription;

    private Integer weight;

    private BigDecimal purchasingCost;

    private BigDecimal vipPrice;

    private BigDecimal retailPrice;

    private String cargoImgAdd;


}