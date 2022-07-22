package ApiResource;

public enum OrderResource {

    AddPlaceAPI("/v2/payments/");

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
