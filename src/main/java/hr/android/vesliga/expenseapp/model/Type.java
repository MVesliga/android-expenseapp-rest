package hr.android.vesliga.expenseapp.model;

public class Type {
    private String typeName;
    private Double amount;

    public Type(String typeName, Double amount) {
        this.typeName = typeName;
        this.amount = amount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
