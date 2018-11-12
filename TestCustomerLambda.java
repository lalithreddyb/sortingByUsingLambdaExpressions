package task;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.time.LocalDate;

public class TestCustomerLambda {

	public static List<CustomerClass> sortListByID(List<CustomerClass> list)
	{
		ArrayList<CustomerClass> sortedList = new ArrayList<>();
		
		for (CustomerClass customerClass : list)
		{
			if(customerClass.getId() > 103)
				{
					sortedList.add(customerClass);
				}
		}
		return sortedList;
	}

	public static List<CustomerClass> sortListByName(List<CustomerClass> list)
	{
		ArrayList<CustomerClass> sortedList = new ArrayList<>();
		
		for (CustomerClass customerClass : list) 	
		{
			if(customerClass.getName().charAt(0) == 'I')
				{
					sortedList.add(customerClass);
				}
		}
		return sortedList;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CustomerClass> cusList = new ArrayList<>();
		
		cusList.add(new CustomerClass(102, "Hary","NYC","hary@mail.com",LocalDate.of(1993, 1, 3)));
		cusList.add(new CustomerClass(104, "Archana","HYD","archana@mail.com",LocalDate.of(1995, 4, 4)));
		cusList.add(new CustomerClass(101, "Noa","NJ","noa@mail.com",LocalDate.of(1969, 8, 31)));
		cusList.add(new CustomerClass(105, "Anil","Mum","anil@mail.com",LocalDate.of(1985, 10, 8)));
		cusList.add(new CustomerClass(103, "Kumar","WC","kumar@mail.com",LocalDate.of(1976, 9, 21)));
		
	List<CustomerClass> sortById = sortListByID(cusList);
		
	for (CustomerClass customerClass : sortById) 	
	{
		System.out.println(customerClass);
	}
	
	List<CustomerClass> sortByNameStartLetter = sortListByName(cusList);
	
	if(sortByNameStartLetter.size()>0)
	{
		for (CustomerClass customerClass : sortByNameStartLetter) 
		{
			System.out.println(customerClass);
		}
	}
	else
	{
		System.out.println("no customers whose name start with the given letter");	
	}
	
	//lambda expression to compare customers by date
		Comparator<CustomerClass> compareByDate = (CustomerClass c1, CustomerClass c2) ->{
			return c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
		};
		
	Collections.sort(cusList, compareByDate);
	
	for (CustomerClass customerClass : cusList) 
	{
		System.out.println(customerClass);
	}
	
	}
}
