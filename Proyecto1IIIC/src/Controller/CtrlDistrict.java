/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import java.util.List;
import javax.swing.JComboBox;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class CtrlDistrict {

    // Load district names into a JComboBox based on the selected county
    public void loadDistrictsForCounty(JComboBox<String> comboBox, String countyName) {

        DistrictDAO districtDAO = new DistrictDAO();
        List<District> districts = districtDAO.getDistrictsForCounty(countyName);

        comboBox.removeAllItems();
        // Populate the JComboBox with district names
        for (District district : districts) {
            comboBox.addItem(district.getName());
        }
    }

    public String generateCombinedReport(String district, List<SamplingSite> samplingSites, List<WaterSpring> waterSprings) {
        StringBuilder report = new StringBuilder();

        // Título del informe
        report.append("Informe de Sitios de Muestreo y Nacientes en el Distrito de ").append(district).append("\n\n");

        // Sección de Sitios de Muestreo
        report.append("Sitios de Muestreo:\n");
        for (SamplingSite samplingSite : samplingSites) {
            report.append("Nombre del Sitio de Muestreo: ").append(samplingSite.getName()).append("\n");
            report.append("Provincia ID: ").append(samplingSite.getProvinceId()).append("\n");
            report.append("Cantón ID: ").append(samplingSite.getCountyId()).append("\n");
            report.append("Distrito ID: ").append(samplingSite.getDistrictId()).append("\n");
            report.append("Entidad ID: ").append(samplingSite.getEntityId()).append("\n");
            report.append("\n");
        }

        // Sección de Nacientes
        report.append("Nacientes:\n");
        for (WaterSpring waterSpring : waterSprings) {
            report.append("Nombre de la Naciente: ").append(waterSpring.getName()).append("\n");
            report.append("Dirección: ").append(waterSpring.getAddress()).append("\n");
            report.append("Latitud: ").append(waterSpring.getLatitude()).append("\n");
            report.append("Longitud: ").append(waterSpring.getLongitude()).append("\n");
            report.append("Provincia ID: ").append(waterSpring.getProvinceId()).append("\n");
            report.append("Cantón ID: ").append(waterSpring.getCountyId()).append("\n");
            report.append("Distrito ID: ").append(waterSpring.getDistrictId()).append("\n");
            report.append("Entidad ID: ").append(waterSpring.getEntityId()).append("\n");
            report.append("\n");
        }

        return report.toString();
    }
    // Generate a combined report as a string for a specific district
    public void generateReportToPDF(List<SamplingSite> samplingSites, List<WaterSpring> waterSprings) {
        Document document = new Document();

        try {

            // Create a PDF file at the desired location
            String filePath = "C:\\Users\\jairo\\Music\\Reportes/Informe de Sitios de Muestreo y Nacientes.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

           // Open the document to start writing
            document.open();

            
            // Add title to the PDF
            Paragraph title = new Paragraph("Informe de Sitios de Muestreo y Nacientes");
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

          // Add information for Sampling Sites
            for (SamplingSite site : samplingSites) {
                document.add(new Paragraph("Sitios de Muestreo:"));
                document.add(new Paragraph("Nombre: " + site.getName()));
                document.add(new Paragraph("ID: " + site.getId()));
                document.add(new Paragraph("Provincia ID: " + site.getProvinceId()));
                document.add(new Paragraph("Cantón ID: " + site.getCountyId()));
                document.add(new Paragraph("Distrito ID: " + site.getDistrictId()));
                document.add(new Paragraph("Entitdad ID: " + site.getEntityId()));
                document.add(new Paragraph("\n"));

            }

           // Add information for Water Springs
            for (WaterSpring spring : waterSprings) {
                document.add(new Paragraph("Nacientes de Agua:"));
                document.add(new Paragraph("Nombre: " + spring.getName()));
                document.add(new Paragraph("ID: " + spring.getId()));
                document.add(new Paragraph("Dirección: " + spring.getAddress()));
                document.add(new Paragraph("Latitud: " + spring.getLatitude()));
                document.add(new Paragraph("Longitud: " + spring.getLongitude()));
                document.add(new Paragraph("Descripción: " + spring.getDescription()));
                document.add(new Paragraph("Provincia ID: " + spring.getProvinceId()));
                document.add(new Paragraph("Cantón ID: " + spring.getCountyId()));
                document.add(new Paragraph("Distrito ID: " + spring.getDistrictId()));
                document.add(new Paragraph("Entidad ID: " + spring.getEntityId()));
                document.add(new Paragraph("\n"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close the document in a finally block to ensure it is closed even in case of an exception
            if (document != null && document.isOpen()) {
                document.close();
            }
        }
    }

}
