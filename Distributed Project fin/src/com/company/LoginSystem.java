package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSystem {


	static Map<String, String> authorization = new ConcurrentHashMap<>();

	public static boolean Login(ServerThread client) {

		BufferedReader input = client.cin;
		PrintStream output = client.cout;
		String UserName, Password;

		String signUpOrIn;

		boolean loggedIn = false;
		boolean registerdTime = false;

		try {
			do {
				if (!registerdTime){
					output.println("Signup press S , login press L");
				}else{
					output.println("please press L to login");
				}

				signUpOrIn = input.readLine();



				if (signUpOrIn.equals("l")) {
					output.println("Enter User Name");
					UserName = input.readLine();

					output.println("Enter Password");
					Password = input.readLine();
					if (Password.contentEquals(authorization.get(UserName))) {
						loggedIn = true;
						output.println("Logged in!");
					} else {
						output.println("User name or Password is incorrect!");
					}
				}


				else if (signUpOrIn.equals("s")) {
					output.println("Enter User Name");
					UserName = input.readLine();




					if (authorization.containsKey(UserName)) {
						output.println("user name already exists in the system");

					} else {
						output.println("Enter Password");
						Password = input.readLine();
						client.setUserName(UserName);


						authorization.put(UserName, Password);

						output.println("you are Successfully registered!");
						loggedIn = false;
						registerdTime = true;
					}
				}
			} while (!loggedIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loggedIn;

	}
	// end of login method

}
// End of Register class
