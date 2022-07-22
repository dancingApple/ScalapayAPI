package dataFiles;

public class GetOrder {
    private String token;
    private String created;
    private String status;
    private String captureStatus;
    private TotalAmount totalAmount;
    private OrderDetails orderDetails;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaptureStatus() {
        return captureStatus;
    }

    public void setCaptureStatus(String captureStatus) {
        this.captureStatus = captureStatus;
    }

    public TotalAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(TotalAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
