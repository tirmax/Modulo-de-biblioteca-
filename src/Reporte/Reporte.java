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

public class Reporte {

    private static ReporteBL reporteBL = new ReporteBL();

    public static void reporteRecursos(String rutaArchivo) {
        FileOutputStream file = null;
        try {
            //crear un libro
            HSSFWorkbook workbook = new HSSFWorkbook();
            //crear una hoja
            HSSFSheet sheet = workbook.createSheet();
            //establecer nombre
            workbook.setSheetName(0, "Recursos");
            String[] headers = new String[]{
                "idrecurso",
                "Codigo",
                "Nombre",
                "Fecha",
                "Editorial",
                "Descripcion",
                "Autor",
                "Estado",
                "Ubicacion",
                "TipoRecurso",
                "Idusuario",
                "nombreUsuario"
            };

            List datos = reporteBL.consultarRecursos(conexion.obtenerConexion());

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

                    ReporteRecurso d = (ReporteRecurso) datos.get(i);

                    dataRow.createCell(0).setCellValue(d.getIdrecurso());
                    dataRow.createCell(1).setCellValue(d.getCodigo());
                    dataRow.createCell(2).setCellValue(d.getNombre());
                    dataRow.createCell(3).setCellValue(format.format(d.getFecha()));
                    dataRow.createCell(4).setCellValue(d.getEditorial());
                    dataRow.createCell(5).setCellValue(d.getDescripcion());
                    dataRow.createCell(6).setCellValue(d.getAutor());
                    dataRow.createCell(7).setCellValue(d.getEstado());
                    dataRow.createCell(8).setCellValue(d.getUbicacion());
                    dataRow.createCell(9).setCellValue(d.getTipoRecurso());
                    dataRow.createCell(10).setCellValue(d.getIdusuario());
                    dataRow.createCell(11).setCellValue(d.getNombreUsuario());
                }
            }

            file = new FileOutputStream(rutaArchivo);
            workbook.write(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
