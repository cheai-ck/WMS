package com.wcg.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDO {
    private Integer managementId;

    private String managementUser;

    private String managementPass;

    public Integer getManagementId() {
        return managementId;
    }

    public void setManagementId(Integer managementId) {
        this.managementId = managementId;
    }

    public String getManagementUser() {
        return managementUser;
    }

    public void setManagementUser(String managementUser) {
        this.managementUser = managementUser == null ? null : managementUser.trim();
    }

    public String getManagementPass() {
        return managementPass;
    }

    public void setManagementPass(String managementPass) {
        this.managementPass = managementPass == null ? null : managementPass.trim();
    }
}