package com._1shhub.carecoders.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._1shhub.carecoders.dto.report.ReportDetailDTO;
import com._1shhub.carecoders.dto.report.ReportSummaryDTO;
import com._1shhub.carecoders.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportSummaryDTO> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ReportDetailDTO getReport(@PathVariable Long id) {
        return reportService.getReportById(id);
    }
}
