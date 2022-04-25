package com.crud.springcrud.controller;


import com.crud.springcrud.services.InvoiceServices;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceServices invoiceServices;

    @Autowired
    private HttpServletResponse response;

    @PostMapping("/invoice")
    public void generateInvoice(@RequestParam("film_id") Integer film_id, @RequestParam("user_id") Integer user_id, @RequestParam("studio_id")Integer studio_id, @RequestParam("qty")Integer qty, @RequestParam("schedule_id")Integer schedule_id) throws Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment; filename=\"invoice.pdf\"");
        JasperPrint jasperPrint = invoiceServices.generateInvoice(film_id, user_id, studio_id, qty, schedule_id);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());


    }

}
