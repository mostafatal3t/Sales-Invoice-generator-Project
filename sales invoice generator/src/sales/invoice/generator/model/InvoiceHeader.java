/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.model;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Pody
 */
public class InvoiceHeader {
    int invoiceNum ;
    Date invoiceDate;
    String customerName;
    ArrayList<InvoiceLine> invoiceLines;
    
    public int getInvoiceNum() {
        return invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }
   
    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
    
    
    
    
}
