package iNTUition;
import java.util.HashMap;

class UpdateUsers {
	public static HashMap<Integer, User> account_map = new HashMap<>();
	public static String addNewUser(HashMap<Integer, User> account_map, int user_id, double user_account_balance) {
        User newUser = new User(user_id, user_account_balance);
        if (account_map.containsKey(user_id)) {
            //commented out below code, should we remove the previous user?
        	//account_map.remove(user_id);
            System.out.println("User already exists.");
            return "User already exists.";
            }
        else {
        	account_map.put(user_id, newUser);
            System.out.println("New user added.");
            System.out.println(newUser.toString());
            return "New user added.";
            }
    }

    public static String removeUser(HashMap<Integer, User> account_map, int user_id) {
        if (account_map.containsKey(user_id)) {
            account_map.remove(user_id);
            return "User removed.";
        } else {
            return "User not found.";
        }
    }
    
    public static String query_balance(HashMap<Integer, User> account_map, int user_id) {
    	if (account_map.containsKey(user_id)) {
            System.out.printf("User %d has $%.2f.\n",user_id,account_map.get(user_id).user_account_balance);
            return String.format("User %d has $%.2f.\n",user_id,account_map.get(user_id).user_account_balance);
        } else {
            System.out.println("User not found.");
            return "User not found.";
        }
    }
}