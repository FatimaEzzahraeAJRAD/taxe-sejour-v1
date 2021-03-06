/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxesejourv1.dao;

import com.sir.taxesejourv1.bean.Categorie;
import com.sir.taxesejourv1.bean.TauxTaxeSejour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jawadoo
 */
@Repository
public interface TauxTaxeSejourDao extends JpaRepository<TauxTaxeSejour,Long>{
    public TauxTaxeSejour findByCategorieLibelle(String libelle);
}
