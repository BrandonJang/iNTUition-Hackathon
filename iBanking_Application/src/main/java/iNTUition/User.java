package iNTUition;

class User {
    int user_id;
    double user_account_balance;

    public User(int user_id, double user_account_balance) {
        this.user_id = user_id;
        this.user_account_balance = user_account_balance;
    }

    public String toString() {
        return "User ID: " + user_id + ", Balance: $" + String.format("%.2f",user_account_balance);
    }
}