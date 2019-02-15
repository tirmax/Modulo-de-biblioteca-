package Reporte;
import DAO.conexion;
import Modelo.ReportePrestamo;
import Modelo.ReporteRecurso;
import Negocio.ReporteBL;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class Reporte2 {

    private static ReporteBL reporteBL = new ReporteBL();

    public static void reporteuso(String rutaArchivo) {
        FileOutputStream file = null;
        try {
            //crear un libro
            HSSFWorkbook workbook = new HSSFWorkbook();
            //crear una hoja
            HSSFSheet sheet = workbook.createSheet();
            //establecer nombre
            workbook.setSheetName(0, "Prestamo");
            String[] headers = new String[]{
                "Id_Prestamo",
                "Id_Recurso",
                "Cod_Estudiante",
                "Fecha_Prestamo",
                "Fecha_Devolucion",
                "Estado",
                "Id_usuario_Entrada",
                "Id_usuario_Salida",
                "Apellido",
                "DiasPrestacion"
            };
            List datos = reporteBL.consultarusos(conexion.obtenerConexion());
            //crear estilos
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            headerStyle.setFont(font);

            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());            
            HSSFRow headerRow = sheet.createRow(0);
            //crear encabezados
            for (int i = 0; i < headers.length; ++i) {
                String header = headers[i];
                HSSFCell cell = headerRow.createCell(i);
                cell.setCellStyle(headerStyle);
                cell.setCellValue(header);
            }
            //registrar datos
            if (datos != null) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                for (int i = 0; i < datos.size(); ++i) {
                    HSSFRow dataRow = sheet.createRow(i + 1);

                    ReportePrestamo d = (ReportePrestamo) datos.get(i);
                    dataRow.createCell(0).setCellValue(d.getIdPrestamo());
                    dataRow.createCell(1).setCellValue(d.getIdrecurso());
                    dataRow.createCell(2).setCellValue(d.getCodigoestudiante());
                    dataRow.createCell(3).setCellValue(format.format(d.getFechaprestamo()));
                    dataRow.createCell(4).setCellValue(format.format(d.getFechaDevolucion()));
                    dataRow.createCell(5).setCellValue(d.getEstado());
                    dataRow.createCell(6).setCellValue(d.getId_usuario_entrada());
                    dataRow.createCell(7).setCellValue(d.getId_usuario_salida());
                    dataRow.createCell(8).setCellValue(d.getApellido());
                    dataRow.createCell(9).setCellValue(d.getDiasPrestacion());
                }
            }

            file = new FileOutputStream(rutaArchivo);
            workbook.write(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reporte2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reporte2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Reporte2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }    
}
