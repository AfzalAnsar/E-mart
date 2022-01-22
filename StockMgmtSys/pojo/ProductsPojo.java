
package StockMgmtSys.pojo;


public class ProductsPojo {

    @Override
    public String toString() {
        return "ProductsPojo{" + "productId=" + productId + ", productName=" + productName + ", productCompany=" + productCompany + ", productPrice=" + productPrice + ", ourPrice=" + ourPrice + ", quntity=" + quntity + ", tax=" + tax + ", total=" + total + '}';
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    private String productId;
    private String productName;
    private String productCompany;
    private double productPrice;
    private double ourPrice;
    private int quntity;
    private double tax;
    private double total;
    
}
