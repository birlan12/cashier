package com.smk.cashier.service;

import com.smk.cashier.dao.BarangDao;
import com.smk.cashier.model.Barang;
import junit.framework.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BarangServiceTest {

    @Test
    @Order(2)
    void getBarangList() {
        List<Barang> barangList = BarangService.getInstance().getBarangList();
        assertEquals(barangList.size(),3);
    }
    @Test
    @Order(3)
    void findByName() {
        List<Barang> resultList = BarangService.getInstance().findByName("Laptop");
        assertEquals(resultList.size(), 2);
    }

    @Test
    @Order(1)
    void addBarang() {
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        BarangService.getInstance().addBarang(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("MO002");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(150000);
        BarangService.getInstance().addBarang(mouse);

        Barang laptopGaming = new Barang();
        laptopGaming.setKodeBarang("LP002");
        laptopGaming.setNamaBarang("Laptop Gaming");
        laptopGaming.setHargaBarang(20000000);
        BarangService.getInstance().addBarang(laptopGaming);


    }

    @Test
    @Order(4)
    void saveBarangToDatabase() {
        BarangDao barangDao = new BarangDao();
        Barang laptop = new Barang();
        laptop.setKodeBarang("LP001");
        laptop.setNamaBarang("Laptop");
        laptop.setHargaBarang(5000000);
        laptop.setDateCreated(new Date());
        laptop.setLastModified((new Date()));
        barangDao.save(laptop);

        Barang mouse = new Barang();
        mouse.setKodeBarang("MO002");
        mouse.setNamaBarang("Mouse");
        mouse.setHargaBarang(150000);
        mouse.setDateCreated(new Date());
        mouse.setLastModified((new Date()));
        barangDao.save(mouse);


        Barang laptopGaming = new Barang();
        laptopGaming.setKodeBarang("LP002");
        laptopGaming.setNamaBarang("Laptop Gaming");
        laptopGaming.setHargaBarang(20000000);
        laptopGaming.setDateCreated(new Date());
        laptopGaming.setLastModified((new Date()));
        barangDao.save(laptopGaming);

    }
}