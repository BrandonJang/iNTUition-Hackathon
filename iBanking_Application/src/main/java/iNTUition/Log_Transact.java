package iNTUition;
import java.util.HashMap;

class Log_Transact extends Transact {
    static HashMap<String, Double> transaction_map = new HashMap<>();

    public static void logTransaction(int sender_id, int receiver_id, double transfer_amount) {
        String transaction_key = sender_id + " -> " + receiver_id;
        if (transfer_amount == 0) {
            System.out.println("Transaction failed.");
            transaction_map.put(transaction_key, 0.0);
        } else {
            System.out.println("Transaction successful. Transfer amount: $" + String.format("%.2f",transfer_amount));
            transaction_map.put(transaction_key, transfer_amount);
        }
    }
}