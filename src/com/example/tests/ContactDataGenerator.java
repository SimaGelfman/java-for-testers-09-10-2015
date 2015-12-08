package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

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
	
	

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream =  new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
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
		
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> contacts = new ArrayList<ContactData>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = bufferedReader.readLine();
		String parts[];
		while(line != null){
			parts = line.split(",");
			ContactData contact = new ContactData()
					.withFirstName(parts[0])
					.withLastName(parts[1])
					.withFirstAdress(parts[2])
					.withHomePhoneNumber(parts[3])
					.withMobilePhoneNumber(parts[4])
					.withWorkPhoneNumber(parts[5])
					.withFirstAdress(parts[6])
					.withSecondEmail(parts[7])
					.withGroupName(parts[8])
					.withBirthDay(parts[9])
					.withBirthMonth(parts[10])
					.withBirthYear(parts[11])
					.withSecondAdress(parts[12])
					.withHomeNumber(parts[13]);
			contacts.add(contact);
			line = bufferedReader.readLine();
		}
		return contacts;
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
								.withGroupName(null)
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
