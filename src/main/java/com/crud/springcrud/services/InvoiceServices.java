package com.crud.springcrud.services;

import com.crud.springcrud.entites.Transaksi;
import com.crud.springcrud.exception.ResourceNotFoundException;
import net.sf.jasperreports.engine.JasperPrint;

public interface InvoiceServices {
    JasperPrint generateInvoice(Integer film_id, Integer user_id, Integer studio_id, Integer qty,Integer schedule_id) throws ResourceNotFoundException, Exception;
}
