public class User {

    private String amount;
    private String type;
    private String desc;

    public User(String amount,String type,String desc) {
        this.amount=amount;
        this.type=type;
        this.desc=desc;
    }

    public String getAmount() {
        return this.amount;
    }
    public String getType() {
        return this.type;
    }
    public String getDesc() {
        return this.desc;
    }
}
