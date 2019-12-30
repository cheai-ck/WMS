package com.wcg.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDO implements Serializable {
    private Integer id;

    private String cName;

    private String cAddress;

    private String cTelephone;
}
