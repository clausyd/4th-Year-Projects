import java.io.*;
import java.util.Scanner;

public class Solver 
{ 	
	public static void main(String args[]) throws FileNotFoundException 
	{	//created a boolean variable so i could exit the system later by setting it to true.
		boolean exit = false;
		//String stored_passwords;
		String salt1;
		
		//Used the Buffer reader to read in the file off passwords.
		BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream("ed_passwd")));

		

		
		try {
			//Here i used a while loop to read each line one by on, i set it not equal to null, so when it is null it will break the loop and set the boolean to false.
			while ((salt1 = d.readLine()) != null && exit ==false)  {
			// Here i am getting the salt which is the first two numbers but is Java we always start at o and go as far as number two.
			String salt = salt1.substring(0,2);
			//Here i just start after the second number and read the rest.
			String stored_password =  salt1.substring(2);

			// step through all words in the dictionary		
			try
			{
				BufferedReader dict_br = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary")));
				String word;
				String word_encrypted;
				
				boolean found = false;
				//Read the dictionary one by one and pass it to the JCrypt class.			
				while ((word = dict_br.readLine()) != null && found == false)   
				{	
					word_encrypted = JCrypt.crypt(salt, word);
					
					// Print the content on the console
					if (word_encrypted.equals(salt + stored_password))
					{	
						found = true;
						System.out.println(word + " found!");
					}
				}
				dict_br.close();
				}
				catch (Exception e)
				{
					System.err.println("Error: " + e.getMessage());
				}
			}
			//Here i close the BufferReader.
			d.close();
			//Exit the program too easy.
			exit = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}