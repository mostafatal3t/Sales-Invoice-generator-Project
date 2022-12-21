/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.model;

import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pody
 */
public class FileOperations {
    
    
    ArrayList<InvoiceHeader>readFile(){
    
        
        
        return null;
    } 
    
    @SuppressWarnings("empty-statement")
    public  void  writeFile(ArrayList<InvoiceHeader> data ){
        InvoiceHeader i =new InvoiceHeader();
        Date da=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
       List<String[]>list=new ArrayList<String[]>();
       String [] header={"InvoiceNum","InvoiceDate","CustomerName"};
                    list.add(header);
                    
        InvoiceHeader in = new InvoiceHeader();
        String [] d ={"","",""};
        for (InvoiceHeader item : data) {
        in=item;
        //d[0]=String.valueOf(data1.invoiceNum);
        d[0]=String.valueOf(in.invoiceNum);
        d[1]= String .valueOf(sdf.format(da));
        d[2]=in.customerName;
        list.add(d);
        }
       
        int count =0;
        
        try {
            FileOutputStream fileOutputStream =new FileOutputStream("C:\\Users\\Pody\\Documents\\NetBeansProjects\\sales invoice generator\\invoceHeader.csv");         
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            CSVWriter  c=new CSVWriter(outputStreamWriter);
            c.writeAll(list);
            c.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            addInvoiceLines(in.getInvoiceNum(),in.getInvoiceLines());
            
        } catch (FileNotFoundException ex) {
            System.out.println("Flie Not Found 1 ");
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
    }
    
    
    public void addInvoiceLines( int invoiceNumber , ArrayList<InvoiceLine> data ){
        
       List<String[]>list=new ArrayList<String[]>();
       String [] header={"invoiceNum","itemName","itemPrice" , "count"};
                    list.add(header);
        String [] ar = {"","","",""};
        InvoiceLine i1=new InvoiceLine();
        
        for( InvoiceLine  i :data){
            i1=i;
        ar[0]=String.valueOf(invoiceNumber);
        ar[1]=i1.getItemName();
        ar[2]=String.valueOf(i1.getItemPrice());
        ar[3]=String.valueOf(i1.getCount());
        list.add(ar);
        }
   
        //}
        try {
            FileOutputStream fileOutputStream =new FileOutputStream("C:\\Users\\Pody\\Documents\\NetBeansProjects\\sales invoice generator\\invoceLine.csv");         
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            CSVWriter  c=new CSVWriter(outputStreamWriter);
            c.writeAll(list);
            c.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Flie Not Found ");
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
    }

    
    }

