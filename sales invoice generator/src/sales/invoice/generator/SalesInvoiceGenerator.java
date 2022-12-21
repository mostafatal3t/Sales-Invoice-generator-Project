/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator;


import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import sales.invoice.generator.model.FileOperations;
import sales.invoice.generator.model.InvoiceHeader;
import sales.invoice.generator.model.InvoiceLine;

/**
 *
 * @author Pody
 */
public class SalesInvoiceGenerator {

    /**
     * @param args the command line arguments
     */
    public static void mostafaArrFunction(ArrayList<InvoiceHeader> data){
        int i=0;
        while(i<data.size()){
        
            System.out.println(data.get(i).getCustomerName() + "  " + data.get(i).getInvoiceNum() );
            i++;
        }
    
    }
    public static void main(String[] args) {
        int a=0;
        InvoiceLine invoiceLine=new InvoiceLine();
         FileOperations fo=new FileOperations();
          ArrayList<InvoiceLine> arrayList=new ArrayList<>();
         InvoiceHeader invoiceHeader=new InvoiceHeader();
        ArrayList<InvoiceHeader> arrInvoiceHeaders=new ArrayList<>();
        String validate1="y";
                Scanner sc=new Scanner(System.in);
          System.out.println("SalesInvoiceGenerator");
        System.out.println("please chose your option ? ");
        System.out.println("1 - To create new invoice header --?");
        System.out.println("2 - To read invoices --?");
        System.out.println("3 - To print out invoices --?");
        System.out.println("4 - To Exite  --? ");
        a=sc.nextInt();
        
        if(a==1){
            
            while(validate1.equals("Y") || validate1.equals("y")){
            System.out.println("Enter the InvoiceHeader");
                try{
                System.out.println("please enter the InvoiceNumber ? ");
                invoiceHeader.setInvoiceNum(sc.nextInt());
                System.out.println("please enter the CustomerName ? ");
                invoiceHeader.setCustomerName(sc.next());
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                }
                
                
                
                
                
               
             String c=  "y";
             
             
               while(c.equals("y") || c.equals("Y")){
                   // part of enter item name
                   try{
             System.out.println("Please enter item name --?");
                    invoiceLine.setItemName(sc.next());   
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
             System.out.println("Please enter item name --?");
                    invoiceLine.setItemName(sc.next());
                }
                   // end of part
                   // part of enter item price
                try{
             System.out.println("Please enter item price --?");
                    invoiceLine.setItemPrice(sc.nextDouble());  
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                   System.out.println("Please enter item price --?");
                    invoiceLine.setItemPrice(sc.nextDouble());
                }
             // end of part
             // part of enter item count
                try{
             System.out.println("Please enter count --?");
                    invoiceLine.setCount(sc.nextInt());  
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                   System.out.println("Please enter count --?");
                    invoiceLine.setCount(sc.nextInt()); 
                }
                
             // end of part     
                    arrayList.add(invoiceLine);
                    
                    System.out.println("Do you want to add another Line ? ( y / n )");
                     c=sc.next();
                    if(c.equals("n")||c.equals("N")){
                    invoiceHeader.setInvoiceLines(arrayList);
                        break;    
                    }else if(c.equals("y") || c.equals("Y")){
                        continue;
                    }else{
                        System.out.println("Please enter The correct Choice");
                        c=   sc.next();
                    }
                 
                }
               arrInvoiceHeaders.add(invoiceHeader);
                System.out.println("Do you want to Add Another InvoiceHeader --? (y/n)");
                validate1=sc.next();
            if(validate1.equals("y")||validate1.equals("Y")){
                continue;
            }else if(validate1.equals("n")||validate1.equals("N")){
            break;
            }
         }
             
             fo.writeFile(arrInvoiceHeaders);
                System.out.println(arrInvoiceHeaders);
                System.exit(0);
        }
        
   }
    
    
    
}
/*
int a = 0;
        InvoiceHeader invoiceHeader=new InvoiceHeader();
        FileOperations fo=new FileOperations();
        Scanner sc=new Scanner(System.in);
        System.out.println("SalesInvoiceGenerator");
        System.out.println("please chose your option ? ");
        System.out.println("1 - To create new invoice --?");
        System.out.println("2 - To read invoices --?");
        System.out.println("3 - To print out invoices --?");
        System.out.println("4 - To Exite  --?");

        FileOperations f=new FileOperations();
        ArrayList<InvoiceHeader> arrInvoiceHeaders=new ArrayList<>();
   
              Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                String myDate=sdf.format(d);
                ArrayList<InvoiceLine> arrayList=new ArrayList<>();
        while(a!=4){
         a=sc.nextInt();
        switch (a){
            case 1:
                try{
                System.out.println("please enter the InvoiceNumber ? ");
                invoiceHeader.setInvoiceNum(sc.nextInt());
                System.out.println("please enter the CustomerName ? ");
                invoiceHeader.setCustomerName(sc.next());
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                }
                
                
                
                
                
               InvoiceLine invoiceLine=new InvoiceLine();
             String c=  "y";
               while(c.equals("y") || c.equals("Y")){
                   // part of enter item name
                   try{
             System.out.println("Please enter item name --?");
                    invoiceLine.setItemName(sc.next());   
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
             System.out.println("Please enter item name --?");
                    invoiceLine.setItemName(sc.next());
                }
                   // end of part
                   // part of enter item price
                try{
             System.out.println("Please enter item price --?");
                    invoiceLine.setItemPrice(sc.nextDouble());  
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                   System.out.println("Please enter item price --?");
                    invoiceLine.setItemPrice(sc.nextDouble());
                }
             // end of part
             // part of enter item count
                try{
             System.out.println("Please enter count --?");
                    invoiceLine.setCount(sc.nextInt());  
                }catch(InputMismatchException ex  ){
                System.out.println("please enter data on correct format");
                   System.out.println("Please enter count --?");
                    invoiceLine.setCount(sc.nextInt()); 
                }
                
             // end of part     
                    arrayList.add(invoiceLine);
                    System.out.println("Do you want to add another Line ? ( y / n )");
                     c=sc.next();
                    if(c.equals("n")||c.equals("N")){
                        invoiceHeader.setInvoiceLines(arrayList);
                        arrInvoiceHeaders.add(invoiceHeader);
                        fo.writeFile(arrInvoiceHeaders);
                        System.exit(0);    
                    }else if(c.equals("y") || c.equals("Y")){
                        continue;
                    }else{
                        System.out.println("Please enter The correct Choice");
                        c=   sc.next();
                    }
                 
                }
                
                break;
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                System.exit(0);
                break;
        default:
            System.out.println("Please enter the correct choice --?");
        }
        }
    }
     public static void addInvoiceHeaderToFile(InvoiceHeader invoiceHeader, String date){
            String [] d={};
     d[0]=String.valueOf(invoiceHeader.getInvoiceNum());
     d[1]=date;
     d[3]=invoiceHeader.getCustomerName();
     
    }
    

*/