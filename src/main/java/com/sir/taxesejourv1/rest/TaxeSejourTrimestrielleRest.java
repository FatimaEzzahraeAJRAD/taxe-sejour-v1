/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.taxesejourv1.rest;

import com.sir.taxesejourv1.bean.TaxeSejourTrimestrielle;
import com.sir.taxesejourv1.rest.converter.TaxeSejourTrimestrielleConverter;
import com.sir.taxesejourv1.rest.proxy.LocalProxy;
import com.sir.taxesejourv1.rest.vo.TaxeSejourTrimestrielleVo;
import com.sir.taxesejourv1.service.TaxeSejourTrimestrielleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jawadoo
 */
@RestController()
@RequestMapping({"/taxe-sejour-v1/taxeSejours"})
public class TaxeSejourTrimestrielleRest {

    @Autowired
    private LocalProxy localProxy;
    @Autowired
    private TaxeSejourTrimestrielleService taxeSejourTrimestrielleService;
    @Autowired
    private TaxeSejourTrimestrielleConverter taxeSejourTrimestrielleConverter;

    @GetMapping("/numeroTrimester,annee/{numeroTrimester,annee}")
    public TaxeSejourTrimestrielle findTaxeTrimestrielleByNumeroTrimesterAndAnnee(@PathVariable int numeroTrimestre, @PathVariable int annee) {
        return taxeSejourTrimestrielleService.findTaxeTrimestrielleByNumeroTrimesterAndAnnee(numeroTrimestre, annee);
    }

    @PostMapping("/")
    public int creertaxe(@RequestBody TaxeSejourTrimestrielleVo taxesejourTrimestrielleVo) {
        System.out.println("taxe sejour "+taxesejourTrimestrielleVo);
        System.out.println("ref local "+taxesejourTrimestrielleVo.getReferenceLocal());
        TaxeSejourTrimestrielle taxeSejourTrimestrielle = taxeSejourTrimestrielleConverter.toItem(taxesejourTrimestrielleVo);
        int res = taxeSejourTrimestrielleService.creertaxe(taxeSejourTrimestrielle, taxesejourTrimestrielleVo.getReferenceLocal());
        return res;
    }

//   @PostMapping("/")
//    public int creertaxe(TaxeSejourTrimestrielle taxesejourTrimestrielle, String referenceLocal) {
//        return taxeSejourTrimestrielleService.creertaxe(taxesejourTrimestrielle, referenceLocal);
//    }
    public TaxeSejourTrimestrielleConverter getTaxeSejourTrimestrielleConverter() {
        return taxeSejourTrimestrielleConverter;
    }

    public void setTaxeSejourTrimestrielleConverter(TaxeSejourTrimestrielleConverter taxeSejourTrimestrielleConverter) {
        this.taxeSejourTrimestrielleConverter = taxeSejourTrimestrielleConverter;
    }

    public LocalProxy getLocalProxy() {
        return localProxy;
    }

    public void setLocalProxy(LocalProxy localProxy) {
        this.localProxy = localProxy;
    }

    public TaxeSejourTrimestrielleService getTaxeSejourTrimestrielleService() {
        return taxeSejourTrimestrielleService;
    }

    public void setTaxeSejourTrimestrielleService(TaxeSejourTrimestrielleService taxeSejourTrimestrielleService) {
        this.taxeSejourTrimestrielleService = taxeSejourTrimestrielleService;
    }

}
