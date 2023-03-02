package iNTUition;

import java.util.HashMap;

class Transact {
	
    public static String transfer(HashMap<Integer, User> account_map, int sender_id, int receiver_id, double transfer_amount) {
        User sender = account_map.get(sender_id);
        User receiver = account_map.get(receiver_id);
        if (sender == null || receiver == null) {
            System.out.println("Transaction failed: invalid sender or receiver ID.");
            return "Transaction failed: invalid sender or receiver ID.";
            //Log_Transact.logTransaction(sender_id, receiver_id, 0);
            
        }
        if (sender.user_account_balance < transfer_amount) {
            System.out.println("Transaction failed: insufficient funds.");
            return "Transaction failed: insufficient funds.";
            //Log_Transact.logTransaction(sender_id, receiver_id, 0);
            
        }
        sender.user_account_balance -= transfer_amount;
        receiver.user_account_balance += transfer_amount;
        System.out.println("Transaction successful.");
        System.out.println(sender.toString());
        System.out.println(receiver.toString());
        return String.format("Transaction successful\n %s \n %s", sender.toString(), receiver.toString());
        //Log_Transact.logTransaction(sender_id, receiver_id, transfer_amount);
    }
    
    public static String user_top_up(HashMap<Integer, User> account_map, int user_id, double top_up_amount) {
    	if (account_map.containsKey(user_id)) {
    		account_map.get(user_id).user_account_balance += top_up_amount;
            System.out.printf("Top up successful, User %d has $%.2f.\n",user_id,account_map.get(user_id).user_account_balance);
            return String.format("Top up successful, User %d has $%.2f.\n",user_id,account_map.get(user_id).user_account_balance);
        } else {
            System.out.println("User not found.");
            return "User not found.";
        }
    }
}
