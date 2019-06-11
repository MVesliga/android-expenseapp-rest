package hr.android.vesliga.expenseapp.model;

public class Balance {
    private int month;
    private Double sum;


    public Balance(int month, Double sum) {
        this.month = month;
        this.sum = sum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
