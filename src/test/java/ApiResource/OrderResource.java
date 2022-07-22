package ApiResource;

public enum OrderResource {

    getOrderApi("/v2/payments/");

    private String orderResource;

    OrderResource(String resource)
    {
        this.orderResource=resource;
    }

    public String getResource()
    {
        return orderResource;
    }
}
