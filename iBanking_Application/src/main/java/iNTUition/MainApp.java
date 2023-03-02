package iNTUition;
import java.util.HashMap;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        HashMap<Integer, User> account_map = new HashMap<>();
        
        User user1 = new User(1001, 5000.0);
        User user2 = new User(1002, 10000.0);
        account_map.put(user1.user_id, user1);
        account_map.put(user2.user_id, user2);
        Scanner sc = new Scanner(System.in);
		int choice = 0;

		System.out.println("(1) Create a User's Account");
		System.out.println("(2) Delete a User's Account");
		System.out.println("(3) User Top Up");
		System.out.println("(4) Query Balance");
		System.out.println("(5) Transfer");
		System.out.println("(6) Exit");

		do {
			System.out.println("Enter the number of your choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Test adding a new user
		        System.out.println("Create User ID:");
		        int account_id = sc.nextInt();
		        double account_balance = 0;
		        UpdateUsers.addNewUser(account_map, account_id, account_balance);
				break;
			case 2:
				// Test removing an existing user
		        System.out.println("Account to remove:");
		        int remove_id = sc.nextInt();
		        UpdateUsers.removeUser(account_map, remove_id);
				break;
			case 3:
				// Test top up of user balance
		        System.out.println("User ID to Top Up: ");
		        int top_up_id = sc.nextInt();
		        System.out.println("Amount to Top Up: ");
		        double top_up_amount = sc.nextDouble();
		        Transact.user_top_up(account_map, top_up_id, top_up_amount);
				break;
			case 4:
				// Test query balance of user
		        System.out.println("User ID to Query: ");
		        int user_id = sc.nextInt();
		        UpdateUsers.query_balance(account_map, user_id);
				break;
			case 5:
				// Test transferring between users
		        System.out.println("Transferer ID: ");
		        int transferrer_id = sc.nextInt();
		        System.out.println("Recipient ID: ");
		        int recipient_id = sc.nextInt();
		        System.out.println("Amount to Pay: ");
		        double amount = sc.nextDouble();
		        Transact.transfer(account_map, transferrer_id, recipient_id, amount);
				break;
			}
		} while (choice != 6);
        sc.close();
        

        

//        // Test removing a non-existent user
//        System.out.println("Test 3");
//        UpdateUsers.removeUser(account_map, 1004);

        

        
        
        
              
	  }

	}
