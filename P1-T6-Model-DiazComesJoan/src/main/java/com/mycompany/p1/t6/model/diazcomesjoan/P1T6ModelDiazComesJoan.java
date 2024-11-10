/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p1.t6.model.diazcomesjoan;

import java.util.Objects;

/**
 *
 * @author micro
 */
public class P1T6ModelDiazComesJoan {

    private Integer equipNum;
    private String equipName;

    public P1T6ModelDiazComesJoan(Integer equipNum, String equipName) {
        this.setEquipNum(equipNum);
        this.setEquipName(equipName);
    }

    public Integer getEquipNum() {
        return equipNum;
    }

    /* Numero dels equips no modificable */
    private void setEquipNum(Integer equipNum) {
        if (equipNum==null || equipNum<=0 || equipNum>999999) {
            throw new RuntimeException("El Numero de l'equip es obligatori de l'1 al 999999");
        }
        this.equipNum = equipNum;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        if (equipName==null || equipName.length()==0 || equipName.length()>40) {
            throw new RuntimeException("Nom de l'equip obligatori y amb un maxim de 40 caracters");
        }
        this.equipName = equipName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.equipNum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final P1T6ModelDiazComesJoan other = (P1T6ModelDiazComesJoan) obj;
        return Objects.equals(this.equipNum, other.equipNum);
    }


    @Override
    public String toString() {
        return "Producte{" + "Equip=" + equipNum + ", Nom=" + equipName + '}';
    }
}
