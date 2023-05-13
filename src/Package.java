import java.time.LocalDate;

public class Package {

    private String trackingNumber;
    private Address senderAddress;
    private Address recipientAddress;
    private LocalDate estimatedDeliveryDate;

    public Package(int trackingNumber, Address senderAddress, Address recipientAddress, int y, int m, int d) {
        this.trackingNumber = "AS00" + trackingNumber;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = LocalDate.of(y, m, d);
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    @Override
    public String toString() {
        return "Tracking number: " + trackingNumber +
                "\n--- Direccion del remitente ---" + senderAddress +
                "\n--- Direccion del destinatario ---" + recipientAddress +
                "\n--- Fecha de Envio ---" + "\nAnio: " + estimatedDeliveryDate.getYear() + "\nMes: " + estimatedDeliveryDate.getMonth() + "\nDia: " + estimatedDeliveryDate.getDayOfMonth() + "\n\n";
    }
}
