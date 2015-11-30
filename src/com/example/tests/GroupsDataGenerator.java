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

public class GroupsDataGenerator {

	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			System.out.println("Please, specify parametrs: <amount of test data> <file> <format>");
		return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		List<GroupData> groups = generateRandomGroups(amount);
		if(file.exists()){
			System.out.println("File exists, Please remove it manually: " + file);
			return;
		}
		if("csv".equals(format)){
			saveGroupsToCsvFile(groups, file);
		}else if("xml".equals(format)){
			saveGroupsToXmlFile(groups, file);
		}else{
			System.out.println("Unknow format: " + format);
			return;
		}

	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
		XStream xstream =  new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}
	
	public static List<GroupData> loadGroupsFromXmlFile(File file) {
		XStream xstream =  new XStream();
		xstream.alias("group", GroupData.class);
		return (List<GroupData>)xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer =  new FileWriter(file);
		for (GroupData group : groups) { 
			writer.write(group.getGroupName() + "," + group.getHeader() + "," + group.getFooter() + "," + "!" + "\n");
		}
		writer.close();
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List <GroupData>  list = new ArrayList<GroupData>();
		for (int i = 0; i < amount; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString())					
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(group);
		}		
		return list;
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
	
	public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
		String line = bufferedreader.readLine();
		while(line != null){
			String[] parts = line.split(",");
			GroupData group = new GroupData()
					.withName(parts[0])
					.withHeader(parts[1])
					.withFooter(parts[2]);
			list.add(group);
			line = bufferedreader.readLine();		
		}
		bufferedreader.close();
		return list;
	}

	

}
