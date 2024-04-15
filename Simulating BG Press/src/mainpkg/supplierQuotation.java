package mainpkg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class supplierQuotation {

    private final List<Quotation> quotationList;

    public supplierQuotation() {
        this.quotationList = new ArrayList<>();
    }

    public void addQuotation(String quotationNumber, String description, int quantity, double unitPrice, double total) {
        Quotation newQuotation = new Quotation(quotationNumber, description, quantity, unitPrice, total);
        quotationList.add(newQuotation);
    }

    public List<Quotation> getQuotations() {
        return quotationList;
    }

    public void saveQuotationListToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Quotation quotation : quotationList) {
                writer.write(quotation.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving quotation data to file: " + e.getMessage());
        }
    }
}
