import java.time.LocalDate;

public  class ExpiringProduct extends Product{
    private LocalDate expirationDate;

    public ExpiringProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        // Assumption: If the expiration date is today, the product is not considered expired.

        LocalDate today = LocalDate.now();

        return expirationDate.isBefore(today);


    }
}