package com.spring.jasper_reports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jasper_reports.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody String jsonData) {
        byte[] pdfBytes = reportService.generateReport(jsonData);
        if (pdfBytes == null || pdfBytes.length == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        // Set headers for PDF response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("report.pdf").build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }

}
