package com.crud.springcrud.services;


import com.crud.springcrud.entites.*;
import com.crud.springcrud.exception.ResourceNotFoundException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.*;


@Service
public class InvoiceServiceImpl implements InvoiceServices{

    private FilmServices filmServices;
    private UserServices userServices;

    private StudioServices studioServices;

    private ScheduleServices scheduleServices;


    public InvoiceServiceImpl(FilmServices filmServices, ScheduleServices scheduleServices,UserServices userServices, StudioServices studioServices) {
        this.filmServices = filmServices;
        this.userServices = userServices;
        this.studioServices = studioServices;
        this.scheduleServices = scheduleServices;
    }



    @Override
    public JasperPrint generateInvoice(Integer film_id, Integer user_id, Integer studio_id,Integer qty, Integer schedule_id) throws ResourceNotFoundException, Exception {

        Film filmBydId = filmServices.Get(film_id);
        Users userById= userServices.Get(user_id);
        Studio studioById = studioServices.Get(studio_id);
        Schedule scheduleById = scheduleServices.Get(schedule_id);
        List<Transaksi> transaksiList = new ArrayList<Transaksi>();



        System.out.println(scheduleById.getJam_mulai()+" ,, "+scheduleById.getTanggal_tayang());
        Transaksi transaksi = new Transaksi();
        transaksi.setId_transaksi(1);
        transaksi.setFilm(filmBydId.getNama_film());
        transaksi.setQty(qty);
        transaksi.setUser(userById.getFirstName()+userById.getLastName());
        transaksi.setStudio(studioById.getNama_studio());
        transaksi.setDate(scheduleById.getTanggal_tayang());
        transaksi.setJam(scheduleById.getJam_mulai());
        transaksi.setSeats(10);

        transaksiList.add(transaksi);

        InputStream fileReport = new ClassPathResource("reports/invoice.jasper").getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transaksiList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CollectionBeanParam", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, new JREmptyDataSource());
        return jasperPrint;





    }
}
