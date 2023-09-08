package com.teacher.data;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Teacher_Driver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1: AddData\n 2: FetchData");
		System.out.println("Enter the choice");
		int choice = sc.nextInt();
		while (true) {
			switch (choice) {
			case 1: {
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the email");
				String mail = sc.next();
				System.out.println("Enter the phno");
				Long phno = sc.nextLong();

				Teacher t = new Teacher(id, name, mail, phno);
				et.begin();
				em.persist(t);
				System.out.println("Data has been sotred successfully");
				et.commit();
			}
				break;
			case 2: {
				System.out.println("Enter the id");
				int id = sc.nextInt();
				Query query = em.createQuery("select s from Teacher s");
				List<Teacher> list = query.getResultList();
				for (Teacher teacher : list) {
					if (teacher.getId() == id) {
						System.out.println("id : " + teacher.getId());
						System.out.println("id : " + teacher.getName());
						System.out.println("id : " + teacher.getEmail());
						System.out.println("id : " + teacher.getPhno());
					}
				}
				}
			}
		}
	}
}
