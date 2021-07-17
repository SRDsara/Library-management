package com.library;

import java.util.*;
/**
 * @see com.library.Member
 * @see com.library.Main
 * @see com.library.ExquisiteBook
 * @see com.library.KidsAndTeens
 */
public class Book {
    private int code;
    private static int counter = 0;
    private String name;
    private String writer;
    private String translator;
    private String publisher;
    private int year;
    private String callNum;
    private boolean existance=true;
    private String genre;
    Member[] whoBorrowed=new Member[10000000];
    static Scanner sc = new Scanner(System.in);

    /** constructor*/
    public Book(String name, String writer, String translator, String publisher,String genre, int year) {
        setName(name);
        setWriter(writer);
        setTranslatore(translator);
        setPublisher(publisher);
        setGenre(genre);
        setYear(year);
        code = counter++;
        setCode();
        setCallNum(name, year);
    }

    /**settters*/
    public void setName(String name) {
        this.name = name;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTranslatore(String translator) {
        this.translator = translator;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCode() {
        this.code += 1001;
    }

    public void setCallNum(String writer, int year) {
        String ny = String.valueOf(this.year % 100);
        this.callNum = this.code + "/" + ((this.writer).toUpperCase()).charAt(0) + (((this.writer).substring(((this.writer).indexOf(" ")) + 1)).toUpperCase()).charAt(0) + "/" + ny;
    }
    public void setExistance(boolean type){
        this.existance=type;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    /**getters*/

    public String getName() {
        return this.name;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getTranslator() {
        return this.translator;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getYear() {
        return this.year;
    }

    public int getCode(){ return this.code;}

    public String getCallNum() {
        return this.callNum;
    }

    public boolean getExistance(){return this.existance;}

    public String getGenre() { return this.genre; }

    /**the index of book in array is returned by getting call number*/
    public static int searchBo(String callNum, Book[] b) {
        try{
            for (int i = 0; i < b.length; i++) {
                if(b[i] != null && callNum.equals(b[i].getCallNum())) {
                    return i;
                }
            }
        }
        catch(NullPointerException e){
            //do nothing
        }
        return -1;
    }

    /**showing book's information*/
    public void readBo() {
        System.out.println("* book number " + (this.code) + " *");
        System.out.println("book's id=           " + this.getCallNum());
        System.out.println("book's name=         " + this.getName());
        System.out.println("book's writer=       " + this.getWriter());
        System.out.println("book's translator=   " + this.getTranslator());
        System.out.println("book's publisher=    " + this.getPublisher());
        System.out.println("book's genre=        " + this.getGenre());
        System.out.println("book's year=         " + this.getYear());

    }
    /**updating book's info
     * @return book's information
    */
    public String upBo() {
        try{
            System.out.print("New Name: ");
            String nname = sc.nextLine();
            if (nname.isEmpty()) {
                nname = this.getName();
            }

            System.out.print("New Writer: ");
            String nwr = sc.nextLine();
            if (nwr.isEmpty()) {
                nwr =this.getWriter();
            }

            System.out.print("New Translator: ");
            String ntrn = sc.nextLine();
            if (ntrn.isEmpty()) {
                ntrn = this.getTranslator();
            }

            System.out.print("New Publisher: ");
            String npb = sc.nextLine();
            if (npb.isEmpty()) {
                npb = this.getPublisher();
            }
        
            System.out.print("New Year: ");
            String nxyear = "";
            nxyear = sc.nextLine();
            int nyear;
            if (nxyear.isEmpty()) {
                nyear = this.getYear();
            } else {
                while (Integer.valueOf(nxyear) < 1000 || Integer.valueOf(nxyear) >= 10000) {
                    System.out.println("invalid , try again:  ");
                    nxyear = sc.nextLine();
                }
                nyear = Integer.valueOf(nxyear);
            }
       

            System.out.print("New genre: ");
            String nxgn = sc.nextLine();
            String ngn="";
            if (nxgn.isEmpty()) {
                ngn =this.getGenre();
            }
            while(nxgn.equals("exquisite") ||nxgn.equals("Exquisite")||nxgn.equals("kids and teens")||nxgn.equals("Kids And Teens")){
                System.out.println("permission denied!! try again");
                nxgn = sc.nextLine();
            }
                ngn=nxgn;

            this.setName(nname);
            this.setWriter(nwr);
            this.setTranslatore(ntrn);
            this.setPublisher(npb);
            this.setGenre(ngn);
            this.setYear(nyear);
            this.setCallNum(nwr,nyear);
            System.out.println("book number " + (this.code) + " is updated and the new call number is:"+this.getCallNum());                 
            return (this.getCallNum()+" , "+this.getName()+" , "+this.getWriter()+" , "+this.getTranslator()+" , "+this.getPublisher()+" , "+this.getGenre()+" , "+this.getYear());   
        }
        catch(NumberFormatException e){
            System.out.println("enter year correctly");
        }
        return "";
    }
    /**deleting member by getting index (index by search method)*/
    public static void delBo(int a, Book[] b) {
        if (b == null) {
            System.out.println("non-existing book!!");
        } else {
            for (int i = a; i < b.length - 1; i++) {
                b[i] = b[i + 1];
            }
            System.out.println("book number " + (a + 1) + " is deleted");
        }
    }
    /**searching member'id by getting name*/
    public static void searchCallNum(String a,Book [] b) {
        int c=0;
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] != null && b[i].getName().contains(a)) {
                System.out.println("* book number " + (i + 1) + " *");
                System.out.println("book's name=         " + b[i].getName());
                System.out.println("book's writer=       " + b[i].getWriter());
                System.out.println("book's translator=   " + b[i].getTranslator());
                System.out.println("book's publisher=    " + b[i].getPublisher());
                System.out.println("book's genre=        " + b[i].getGenre());
                System.out.println("book's year=         " + b[i].getYear());
                System.out.println("---------------------------------------------------");
                c++;
            }
        }
        if(c>0) {
            System.out.println("which one do you mean? Enter the number: ");
            int num = sc.nextInt();

            try{                
                if(b[num-1] !=null && num>=1){
                    System.out.println("* book number " + (num) + " *");
                    System.out.println("book's Call Number=  " + b[num - 1].getCallNum());
                    System.out.println("book's name=         " + b[num - 1].getName());
                    System.out.println("book's Writer=       " + b[num - 1].getWriter());
                    System.out.println("book's Translator=   " + b[num - 1].getTranslator());
                    System.out.println("book's Publisher=    " + b[num - 1].getPublisher());
                    System.out.println("book's genre=        " + b[num - 1].getGenre());
                    System.out.println("book's year=         " + b[num - 1].getYear());

                } else { System.out.println("invalid choise!"); }
            }catch(InputMismatchException e){
                System.out.println("enter year correctly");
        }
        } else { System.out.println("nothing found!"); }
    }
    /**add a member who borrowed this book to the list*/
    public boolean perBoro(Member m) {
        for (int i = 0; i <10000000 ; i++) {
                if (this.whoBorrowed[i] == null) {
                    whoBorrowed[i]=m;
                    return true;
                }
        }
        return false;
    }
}
