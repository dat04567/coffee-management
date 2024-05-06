/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mac
 */
public class PrintOrder {
    
   private Document document;
   public  static String URL_FILE = "report.pdf";
   private BaseFont bf;
   private  Font fontMin;
  

    public PrintOrder()  throws Exception{
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(URL_FILE));
        document.setPageSize(new Rectangle(210, 297));
        document.open();
        bf = BaseFont.createFont("font/Times New Roman.ttf", BaseFont.IDENTITY_H,  BaseFont.EMBEDDED);
        fontMin = new Font(bf, 6, Font.BOLD);
        
    }
    
    public  void createPrintOrder(HoaDon hoaDon, double tongTien) throws Exception
    {
           
            Font font = new Font(bf, 12, Font.BOLD);
            Paragraph paragraph = new Paragraph("HOÁ ĐƠN", font);
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            
                        // Add seller information
            Font fontNotBold = new Font(bf, 6);
           
            Paragraph employeParagraph = new Paragraph("Thu ngân : 1" , fontNotBold );
            employeParagraph.setSpacingBefore(6);
            document.add(employeParagraph);
            
            Paragraph dateParagraph = new Paragraph("Ngày: " + hoaDon.getNgayVao().toString(),  fontNotBold );
            document.add(dateParagraph);
             
            
            Paragraph soHoaDon = new Paragraph("Số hoá đơn: " + hoaDon.getMaHoaDon(), fontNotBold ); 
            document.add(soHoaDon);
 
          
            document.add(new Paragraph("Thông tin người mua ", fontNotBold));
            document.add(new Paragraph("Tên: " + hoaDon.getKhachHang().getTenKhachHang(), fontNotBold));
            


            // Add table
            PdfPTable table = new PdfPTable(3); // 3 columns
            table.setSpacingBefore(6);
            table.setWidthPercentage(100); 
            
            
            ArrayList<ChiTietHoaDon> chiTietHoaDons = hoaDon.getChiTietHoaDons();
            int size = chiTietHoaDons.size();
            
            if(size == 1)
            {
                addChiTietHoaDon(table, Rectangle.TOP | Rectangle.BOTTOM, chiTietHoaDons.get(0));
            } else  if ( size == size - 1 )
            {
                
                addChiTietHoaDon(table,  Rectangle.TOP | Rectangle.BOTTOM, chiTietHoaDons.get(size - 1));
            } else 
            {
                addChiTietHoaDon(table, Rectangle.TOP , chiTietHoaDons.get(0));
                 for (int i = 1; i <  size  - 1 ; i++) {
                    addChiTietHoaDon(table, Rectangle.NO_BORDER, chiTietHoaDons.get(i));
                }
                 addChiTietHoaDon(table,  Rectangle.BOTTOM , chiTietHoaDons.get(size - 1));
            
            }
            
                       

            

            document.add(table);
            // Create a table with two columns
            
            table = new PdfPTable(2);
            table.setSpacingBefore(4);
            table.setWidthPercentage(100); // Set table width to 100% of the page

            
            
            // Add "TỔNG TIỀN"
            PdfPCell cell = new PdfPCell(new Phrase("TỔNG TIỀN ", fontMin));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(tongTien), fontMin));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            // Add "GIÁ TIỀN"
            cell = new PdfPCell(new Phrase("GIÁ TIỀN "  , fontMin));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(tongTien), fontMin));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);

            // Add the table to the document
            document.add(table);

            
            document.close();
            
        
    }
    
    public  void addChiTietHoaDon(PdfPTable table, int position, ChiTietHoaDon chiTietHoaDon)
    {
        
        PdfPCell cell = new PdfPCell(new Phrase(chiTietHoaDon.getThucUong().getTenNuoc(), fontMin));
        cell.setBorder(position);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(chiTietHoaDon.getSoLuong()), fontMin));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(position);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(FormatVND.getFormat(chiTietHoaDon.getGiaTien()), fontMin));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(position);
        table.addCell(cell);
    }
    
    
    public  void showPdf() throws Exception
    {
        if (Desktop.isDesktopSupported()) {
            File myFile = new File(URL_FILE);
            Desktop.getDesktop().open(myFile);
       
        }
    }
    
    
      
    
}
