package com.library;

import java.util.*;

/** 
 * @see com.library.Main
 * @see com.library.Book
 * @see com.library.ExquisiteBook
 * @see com.library.KidsAndTeens
 */
 
public class Member {
    private long id;
    private static int counter = 0;
    private String name;
    private short age;
    private char sex;
    private String phoneNumber;   
    private Book[] borrowed = new Book[5];  
    static Scanner sc = new Scanner(System.in);

    /** constructor */
    public Member(String name, short age, char sex, String PhoneNumber) {
        setName(name);
        setAge(age);
        setSex(sex);
        setPhoneNumber(PhoneNumber);
        id = counter++;
        setid();

    }

    /** setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public void setid() {
        this.id += 1000001;
    }

    /** getters */
    public String getName() {
        return this.name;
    }

    public short getAge() {
        return this.age;
    }

    public char getSex() {
        return this.sex;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public long getid() {
        return this.id;
    }

    /**the index of member in array is returned by getting id */
    public static int searchMem(long id, Member[] m) {
        for (int i = 0; i < m.length; i++) {            
            if (m[i]!= null && id == m[i].getid()) {
                return i;
            }            
        }
        
        return -1;
    }

    /** create new member and add to member's list */
    public static Member createMem(){
        try{
            System.out.println("Name: ");
            String name0 = sc.nextLine();
        
            System.out.println("Age: ");
            short xage = sc.nextShort();

            while (xage < 0 || xage > 100) {
                System.out.println("invalid , try again:  ");
                xage = sc.nextShort();
                }
            short age = xage;
            System.out.println("Sex(f/m): ");
            char xsex = sc.next().charAt(0);

            while (xsex != 'f' && xsex != 'm' && xsex != 'F' && xsex != 'M') {
                System.out.println("invalid , try again:  ");
                xsex = sc.next().charAt(0);
                }
            char sex = xsex;
            sc.nextLine();
            System.out.println("Phone number: ");
            String phoneNumber = sc.nextLine();

            Member m = new Member(name0, age, sex, phoneNumber);
            return m;
        }
        catch(InputMismatchException e){
            sc.nextLine();
        }
        return null;
        
    }

    /** showing member's information by getting id*/
    public void readMem(long id) {
        System.out.println("* member number " +(this.getid()-1000000)  + " *");
        System.out.println("member's id=           " + this.getid());
        System.out.println("member's name=         " + this.getName());
        System.out.println("member's age=          " + this.getAge());
        System.out.println("member's sex=          " + this.getSex());
        System.out.println("member's phone number= " + this.getPhoneNumber());
    }

    /**deleting member by getting index (index by search method)*/
    public static void delMem(int a, Member[] m) {
        if (m == null) {
            System.out.println("non-existing member!!");
        } else {
            for (int i = a; i < m.length - 1; i++) {
                m[i] = m[i + 1];
            }
            System.out.println("member number " + (a + 1) + " is deleted");
        }
    }

    /** updating member's info */
    public void upMem() {
            //sc.nextLine();
        try{
            System.out.println("New Name: ");
            String nname = sc.nextLine();
            if (nname.isEmpty()) {
                nname = this.getName();
            }
            
            System.out.println("New Age: ");
            String nxage = "";
            nxage = sc.nextLine();
            short nage;
            if (nxage.isEmpty()) {
                nage = this.getAge();
            } else {
                while (Short.valueOf(nxage) < 0 || Short.valueOf(nxage) > 100) {
                    System.out.println("invalid , try again:  ");
                    nxage = sc.nextLine();
                }
                nage = Short.valueOf(nxage);
            }

            System.out.println("New Sex(f/m): ");
            String nxsex = sc.nextLine();
            char nsex;
            if (nxsex.isEmpty()) {
                nsex = this.getSex();
            } else {
                while (nxsex.charAt(0) != 'f' && nxsex.charAt(0) != 'F' && nxsex.charAt(0) != 'm' && nxsex.charAt(0) != 'M') {
                    System.out.println("invalid , try again:  ");
                    nxsex = sc.nextLine();
                }
                nsex = nxsex.charAt(0);
            }

            System.out.println("New Phone number: ");
            String nphoneNumber = sc.nextLine();
            if (nphoneNumber.isEmpty()) {
                nphoneNumber = this.getPhoneNumber();
            }
            this.setName(nname);
            this.setAge(nage);
            this.setSex(nsex);
            this.setPhoneNumber(nphoneNumber);
            System.out.println("member number " + (this.getid()-1000000) + " is updated!");
        }
        catch(NumberFormatException e){
            System.out.println("enter age correctly!!");
            
        }

    }

    /** searching member'id by getting name */
    public static void searchMemID(String a, Member[] m) {
        try{
            int c=0;
            for (int i = 0; i < m.length - 1; i++) {
                if ( (m[i] != null) && m[i].getName().contains(a)) {
                    System.out.println("* member number " + (i + 1) + " *");
                    System.out.println("member's name=         " + m[i].getName());
                    System.out.println("member's age=          " + m[i].getAge());
                    System.out.println("member's sex=          " + m[i].getSex());
                    System.out.println("member's phone number= " + m[i].getPhoneNumber());
                    System.out.println("---------------------------------------------------");
                    c+=1;                  
                }               
            }
            
            if(c>0){            
                System.out.println("which one do you mean? Enter the number: ");
                int num = sc.nextInt();
                              
                    if(m[num-1] !=null && num>=1){
                            System.out.println("* member number " + (num) + " *");
                            System.out.println("member's id=           " + m[num-1].getid());
                            System.out.println("member's name=         " + m[num-1].getName());
                            System.out.println("member's age=          " + m[num-1].getAge());
                            System.out.println("member's sex=          " + m[num-1].getSex());
                            System.out.println("member's phone number= " + m[num-1].getPhoneNumber());
                    }else{System.out.println("invalid choise");}
            }
            else{System.out.println("no member found");}
        }
        catch(InputMismatchException e){
            System.out.println("enter number correctly!!");
            sc.next();
        }  
            
    }
    /**lend books to members*/
    public boolean borrow(Book b) {
        try{
            for (int i = 0; i < 5; i++) {                
                borrowed[i] = b;
                return true;                
            }
        }
        catch(NullPointerException e){
            //do nothing
        }
        return false;
    }

    /**show each member's borrowed book*/
    public static void showMemBorrow(Member m) {
        for (int i = 0; i < 5; i++) {
            if (m.borrowed[i] != null) {
                System.out.println(m.borrowed[i].getCallNum());
            }
            else{System.out.println("null");}
        }
    }
    /** remove a book from member;s borrowed list */
    public boolean remBorrow(Book b) {
        for (int i = 0; i < 5; i++) {
            if (this.borrowed[i] == b) {
                this.borrowed[i]=null;
                sortArr(this.borrowed);
                return true;
            }
        }
        return false;
    }
    /**sorting elements in array */
    public void sortArr(Book [] borrowed){
        for(int i=0;i<4;i++){
            if(borrowed[i]==null) {
                borrowed[i] = borrowed[i+1];
                borrowed[i+1]=null;
            }
        }
    }

    

}