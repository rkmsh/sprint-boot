package com.spring.jasper_reports.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.json.data.JsonDataSource;

@Service
public class ReportService {

    public byte[] generateReport(String jsonData) {

        try {
            // Load JRXML file and compile it
            InputStream reportStream = getClass().getResourceAsStream("/reports/sample_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Prepare JSON datasource
            JsonDataSource dataSource = new JsonDataSource(new ByteArrayInputStream(jsonData.getBytes()), "data");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

            // Export to PDF
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            return pdfBytes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating report: " + e.getMessage());
        }
    }
}
