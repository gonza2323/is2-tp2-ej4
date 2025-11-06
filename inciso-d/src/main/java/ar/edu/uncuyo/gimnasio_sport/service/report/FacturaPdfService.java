package ar.edu.uncuyo.gimnasio_sport.service.report;

import ar.edu.uncuyo.gimnasio_sport.dto.SocioResumenDto;
import ar.edu.uncuyo.gimnasio_sport.entity.Factura;
import ar.edu.uncuyo.gimnasio_sport.entity.Socio;
import ar.edu.uncuyo.gimnasio_sport.error.BusinessException;
import ar.edu.uncuyo.gimnasio_sport.mapper.FacturaMapper;
import ar.edu.uncuyo.gimnasio_sport.mapper.FacturaMapperImpl;
import ar.edu.uncuyo.gimnasio_sport.mapper.SocioMapper;
import ar.edu.uncuyo.gimnasio_sport.repository.CuotaMensualRepository;
import ar.edu.uncuyo.gimnasio_sport.repository.FacturaRepository;
import ar.edu.uncuyo.gimnasio_sport.repository.SocioRepository;
import ar.edu.uncuyo.gimnasio_sport.service.FacturaService;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import ar.edu.uncuyo.gimnasio_sport.dto.FacturaDto;
import ar.edu.uncuyo.gimnasio_sport.dto.DetalleFacturaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.itextpdf.text.BaseColor;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;

@Slf4j
@Service
@RequiredArgsConstructor

public class FacturaPdfService {

    private final FacturaService facturaService;
    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;


    public byte[] generarFacturaPdf(Long idFactura) {
        FacturaDto factura = facturaService.buscarFacturaDto(idFactura);
        Socio socio = socioRepository.findById(
                factura.getDetalles().get(0).getCuota().getSocioId()
        ).orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, out);
            document.open();

            // LOGO Y ENCABEZADO
            Paragraph nombreGimnasio = new Paragraph("GIMNASIO SPORT", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            nombreGimnasio.setAlignment(Element.ALIGN_LEFT);
            document.add(nombreGimnasio);

            document.add(new Paragraph("CUIT: 30-12345678-9"));
            document.add(new Paragraph("Dirección: Av. Siempre Viva 123, Mendoza"));
            document.add(new Paragraph("Tel: +54 261 555-5555"));
            document.add(Chunk.NEWLINE);

            // DATOS DEL SOCIO
            SocioResumenDto socioDto = socioMapper.toSummaryDto(socio);


            PdfPTable clienteTable = new PdfPTable(2);
            clienteTable.setWidthPercentage(100);
            clienteTable.addCell(getCell("Factura Nº: " + factura.getNumeroFactura(), PdfPCell.ALIGN_LEFT, true));
            clienteTable.addCell(getCell("Fecha: " + factura.getFechaFactura(), PdfPCell.ALIGN_RIGHT, false));
            clienteTable.addCell(getCell("Cliente: " + socio.getNombre() + " " + socio.getApellido(), PdfPCell.ALIGN_LEFT, false));
            clienteTable.addCell(getCell("DNI: " + socioDto.getNumeroDocumento(), PdfPCell.ALIGN_RIGHT, false));
            clienteTable.addCell(getCell("Email: " + socio.getUsuario().getNombreUsuario(), PdfPCell.ALIGN_LEFT, false));
            clienteTable.addCell(getCell("Forma de pago: " + factura.getFormaDePago().getTipoDePago(), PdfPCell.ALIGN_RIGHT, false));
            document.add(clienteTable);

            document.add(Chunk.NEWLINE);

            // TABLA DETALLE
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{3, 1, 2, 2});

            tabla.addCell(getHeaderCell("Descripción"));
            tabla.addCell(getHeaderCell("Cant."));
            tabla.addCell(getHeaderCell("Precio Unit."));
            tabla.addCell(getHeaderCell("Total"));

            for (DetalleFacturaDto d : factura.getDetalles()) {
                var cuota = d.getCuota();
                tabla.addCell("Cuota mensual " + cuota.getMes());
                tabla.addCell("1");
                tabla.addCell("$" + String.format("%.2f", cuota.getMonto()));

            }

            document.add(tabla);

            document.add(Chunk.NEWLINE);

            // TOTAL FINAL
            Paragraph total = new Paragraph("Total a pagar: $" + String.format("%.2f", factura.getTotalPagado()),
                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("¡Gracias por entrenar con nosotros!", new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC)));
            document.close();

            return out.toByteArray();

        } catch (Exception e) {
            log.error("Error generando factura PDF", e);
            throw new RuntimeException("Error generando PDF", e);
        }
    }

    private PdfPCell getCell(String text, int alignment, boolean bold) {
        Font font = bold ? new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)
                : new Font(Font.FontFamily.HELVETICA, 10);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    private PdfPCell getHeaderCell(String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
        cell.setBackgroundColor(new BaseColor(230, 230, 230));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }
}
