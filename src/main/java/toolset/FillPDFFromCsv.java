package toolset;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FillPDFFromCsv {

    public static void main(String[] args) throws IOException {
        String pdfFilePath = "/Users/davteje/Desktop/certPonentes.pdf";
        String fieldName = "name";
        String csvFilePath = "/Users/davteje/Desktop/ponentes.csv";
        String savePath = "/Users/davteje/Desktop/certs/EraSpeakerCertificate";

        fill(pdfFilePath, fieldName, csvFilePath, savePath);
    }

    private static void fill(String pdfPath, String pdfField, String csvPath, String savePath) throws IOException {
        List<String> values = getValuesFromCsv(csvPath);

        int fileNo = 0;
        for (String value : values) {
            PDDocument pdfDocument = PDDocument.load(new File(pdfPath));
            PDAcroForm acroForm = getAcroForm(pdfDocument);

            setField(acroForm, pdfField, value);
            saveFile(pdfDocument, savePath, fileNo++);
        }

        System.out.println("Finished processing files");
    }

    private static PDAcroForm getAcroForm(PDDocument pdfDocument) {
        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        return docCatalog.getAcroForm();
    }

    private static List<String> getValuesFromCsv(String csvPath) throws IOException {
        List<String> values = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvPath), Charset.forName("ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0)
                    values.add(fields[0].trim());
            }
        }

        return values;
    }

    private static void setField(PDAcroForm acroForm, String pdfField, String value) throws IOException {
        PDField field = acroForm.getField(pdfField);
        field.setValue(value);
        acroForm.flatten();
    }

    private static void saveFile(PDDocument pdfDocument, String savePath, int value) throws IOException {
        String filePath = savePath + "_" + value + ".pdf";

        pdfDocument.save(new File(filePath));
        pdfDocument.close();

        System.out.println(filePath);
    }
}
