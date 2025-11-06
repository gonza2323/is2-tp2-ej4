package ar.edu.uncuyo.gimnasio_sport.controller;

import ar.edu.uncuyo.gimnasio_sport.dto.FacturaDto;
import ar.edu.uncuyo.gimnasio_sport.service.FacturaService;
import ar.edu.uncuyo.gimnasio_sport.service.report.FacturaPdfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;
    private final FacturaPdfService facturaPdfService;

    @GetMapping("/facturas/{id}")
    public String detalleFactura(Model model, @PathVariable Long id) {
        FacturaDto factura = facturaService.buscarFacturaDto(id);
        model.addAttribute("factura", factura);
        return "factura/detalle";
    }

    @GetMapping("/facturas")
    public String listarFacturas(Model model) {
        List<FacturaDto> facturas = facturaService.listarFacturasActivas();
        model.addAttribute("facturas", facturas);
        return "factura/list";
    }

    @GetMapping("/me/facturas")
    public String listarFacturasSocioActual(Model model) {
        List<FacturaDto> facturas = facturaService.listarFacturasActivasSocioActual();
        model.addAttribute("facturas", facturas);
        return "factura/list";
    }

    @GetMapping("/facturas/descargar/{id}")
    public ResponseEntity<byte[]> descargarFactura(@PathVariable Long id) {
        FacturaDto facturaDto = facturaService.buscarFacturaDto(id);
        byte[] pdfBytes = facturaPdfService.generarFacturaPdf(facturaDto.getId());
        ByteArrayInputStream bis = new ByteArrayInputStream(pdfBytes);
        log.info("Entrando a descargarFactura con id={}", id);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=factura_" + facturaDto.getNumeroFactura() + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(bis.readAllBytes());
    }



}
