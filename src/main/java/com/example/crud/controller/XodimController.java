package com.example.crud.controller;

import com.example.crud.entity.Xodim;
import com.example.crud.repository.XodimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class XodimController {
    @Autowired
    XodimRepository xodimRepository;

    @RequestMapping(value = "/qoshish",method = RequestMethod.POST)
    public String XodimQoshish(@RequestBody Xodim xodim){
        Optional<Xodim> byTel = xodimRepository.findByTel(xodim.getTel());
        if (byTel.isPresent()){
            return "Bunday xodim mavjud";
        }
        xodimRepository.save(xodim);
        return "saqlandi";
    }

    @RequestMapping(value = "/oqish",method = RequestMethod.GET)
    public List<Xodim> XodimOqish(){
        List<Xodim> all = xodimRepository.findAll();
        return all;
    }
    @RequestMapping(value = "/ochirish/{id}",method = RequestMethod.DELETE)
    public String XodimOchirish(@PathVariable Integer id) {
        Optional<Xodim> byId = xodimRepository.findById(id);
        if (byId.isPresent()) {
            xodimRepository.deleteById(id);
            return "ochirildi";
        }
        return "bunday id: li xodim yoq";
    }
    @RequestMapping(value = "/tahrirlash/{id}",method = RequestMethod.PUT)
    public String XodimTahrirlash(@PathVariable Integer id,@RequestBody Xodim xodim){
        Optional<Xodim> byId = xodimRepository.findById(id);
        if (byId.isPresent()){
            Xodim xodim1 = byId.get();
            xodim1.setIsmi(xodim.getIsmi());
            xodim1.setFamilya(xodim.getFamilya());
            xodim1.setTel(xodim.getTel());
            xodimRepository.save(xodim1);
            return id+" id li Xodim malumotlari tahrirlandi !!!";
        }
        return id+ " id li Xodim mavjud emas!!!";
    }
    @RequestMapping(value = "/bittalaboqish/{id}",method = RequestMethod.GET)
    public Xodim XodimBittalabOqish(@PathVariable Integer id){
        Optional<Xodim> byId = xodimRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;


    }
}