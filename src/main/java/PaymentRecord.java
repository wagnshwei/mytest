public class PaymentRecord {

    private long customer_id;
    private long project_id;
    private int repayment_period;
    private double receivable_principal;
    private double receivable_interest;
    private double receivable_total_amount;
    private double receivable_surplus_principal;
    private String receivable_repayment_date;
    private String if_repayment;

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public int getRepayment_period() {
        return repayment_period;
    }

    public void setRepayment_period(int repayment_period) {
        this.repayment_period = repayment_period;
    }

    public double getReceivable_principal() {
        return receivable_principal;
    }

    public void setReceivable_principal(double receivable_principal) {
        this.receivable_principal = receivable_principal;
    }

    public double getReceivable_interest() {
        return receivable_interest;
    }

    public void setReceivable_interest(double receivable_interest) {
        this.receivable_interest = receivable_interest;
    }

    public double getReceivable_total_amount() {
        return receivable_total_amount;
    }

    public void setReceivable_total_amount(double receivable_total_amount) {
        this.receivable_total_amount = receivable_total_amount;
    }

    public double getReceivable_surplus_principal() {
        return receivable_surplus_principal;
    }

    public void setReceivable_surplus_principal(double receivable_surplus_principal) {
        this.receivable_surplus_principal = receivable_surplus_principal;
    }

    public String getReceivable_repayment_date() {
        return receivable_repayment_date;
    }

    public void setReceivable_repayment_date(String receivable_repayment_date) {
        this.receivable_repayment_date = receivable_repayment_date;
    }

    public String getIf_repayment() {
        return if_repayment;
    }

    public void setIf_repayment(String if_repayment) {
        this.if_repayment = if_repayment;
    }

    @Override
    public String toString() {
        return "PaymentRecord [repayment_period=" + repayment_period + ", receivable_principal=" + receivable_principal
                + ", receivable_interest=" + receivable_interest + ", receivable_total_amount="
                + receivable_total_amount + ", receivable_surplus_principal=" + receivable_surplus_principal
                + ", receivable_repayment_date=" + receivable_repayment_date + ", if_repayment=" + if_repayment + "]";
    }
}
