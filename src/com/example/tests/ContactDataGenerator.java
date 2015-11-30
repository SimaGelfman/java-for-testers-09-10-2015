package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.example.tests.GroupsDataGenerator.generateRandomString;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			System.out.println("Please, specify parametrs: <amount of test data> <file> <format>");
		return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		List<ContactData> contacts = generateRandomContacts(amount);
		if(file.exists()){
			System.out.println("File exists, please delete it manually");
			return;
		}
		if("csv".equals(format)){
			saveContactsToCvsFile(contacts, file);
		}else if("xml".equals(format)){
			saveContactsToXmlFile(contacts, file);
		}else{
			System.out.println("Unknow format: " + format);
		}

	}
	
	

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}



	private static void saveContactsToCvsFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for(ContactData contact: contacts){
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getFirstAdress()
			+ "," + contact.getMobilePhoneNumber() + "," + contact.getWorkPhoneNumber() + "," + contact.getFirstEmail()
			+ "," + contact.getSecondEmail() + "," + contact.getGroupName() + "," + contact.getBirthDay() + ","
			+ contact.getBirthMonth() + "," + contact.getBirthYear() + "," + contact.getSecondAdress() + "," 
			+ contact.getHomeNumber() + "," + "!" + "\n");
		}
		writer.close();		
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		Random rnd = new Random();
		String[] months = {"-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
								.withFirstName(generateRandomString())
								.withLastName(generateRandomString())
								.withFirstAdress(generateRandomString())
								.withFirstEmail("mail" + rnd.nextInt() + "@" + "gmail.com")
								.withSecondEmail("mail" + rnd.nextInt() + "@" + "yahoo.com")
								.withHomePhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withMobilePhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withWorkPhoneNumber(Integer.toString(rnd.nextInt(900000000) +100000000))
								.withBirthDay(Integer.toString(rnd.nextInt(31) +1))
								.withBirthMonth(months[rnd.nextInt(months.length)])
								.withBirthYear(Integer.toString(rnd.nextInt(95) +1920))
								.withSecondAdress(generateRandomString())
								.withHomeNumber(Integer.toString(rnd.nextInt(50)));
			list.add(contact);			
		}
		return list;
	}

}
