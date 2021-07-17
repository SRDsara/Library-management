package com.library;

import java.util.InputMismatchException;

public class KidsAndTeens extends Book {
    private char ageGroup;

    /**constructor*/
    public KidsAndTeens(String name, String writer, String translator, String publisher, String genre, int year,char ageGroup) {
        super(name, writer, translator, publisher, genre, year);
        this.setGenre("Kids And Teens");
        setAgeGroup(ageGroup);
    }

    /**setters*/
    public void setAgeGroup(char ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**getter*/
    public char getAgeGroup() {
        return this.ageGroup;
    }
    /**overriding methods */
    @Override
    public void readBo() {
        super.readBo();
        System.out.println("book's age group=    " + this.getAgeGroup());
    }
    @Override
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
                nwr = this.getWriter();
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

            System.out.print("New Age Group: ");
            String nxag = sc.nextLine();
            char nag;
            if (nxag.isEmpty()) {
                nag = this.getAgeGroup();
            } else {
                while (nxag.charAt(0) != 'a' && nxag.charAt(0) != 'b' && nxag.charAt(0) != 'c' && nxag.charAt(0) != 'd'&& nxag.charAt(0) != 'e' && nxag.charAt(0) != 'A' && nxag.charAt(0) != 'B' && nxag.charAt(0) != 'C' && nxag.charAt(0) != 'D'&& nxag.charAt(0) != 'E') {
                    System.out.println("invalid , try again:  ");
                    nxag = sc.nextLine();
                }
                nag = nxag.charAt(0);
            }
            this.setName(nname);
            this.setWriter(nwr);
            this.setTranslatore(ntrn);
            this.setPublisher(npb);
            this.setGenre("Kids And Teens");
            this.setYear(nyear);
            this.setAgeGroup(nag);
            this.setCallNum(nwr,nyear);
            System.out.println("book number " + (this.getCode()) + " is updated and the new call number is:"+this.getCallNum());
            return (this.getCallNum()+" , "+this.getName()+" , "+this.getWriter()+" , "+this.getTranslator()+" , "+this.getPublisher()+" , "+this.getGenre()+" , "+this.getYear()+","+this.getAgeGroup());
            
        }
        catch(NumberFormatException e){
            System.out.println("enter year correctly");
        }
        return "";
        
    }
    
    /**show appropriate book for the given age*/
    public static int showApprBook(KidsAndTeens [] k,short age){       
            int ans=-1;
            int c=0;
            try{
                for(int i=0; i<k.length; i++){  
                    if(k[i] !=null){ 
                        char a=k[i].getAgeGroup();
                        if(age<6){
                            if(a=='a' ||a=='A' ){
                                System.out.println("* book number " + (i + 1) + " *");
                                System.out.println("book's call number=     " + k[i].getCallNum());
                                System.out.println("book's name=            " + k[i].getName());
                                System.out.println("book's writer=          " + k[i].getWriter());
                                System.out.println("book's translator=      " + k[i].getTranslator());
                                System.out.println("bookr's publisher=      " + k[i].getPublisher());
                                System.out.println("bookr's genre=          " + k[i].getGenre());
                                System.out.println("bookr's age group=      " + k[i].getAgeGroup());
                                System.out.println("book's year=            " + k[i].getYear());
                                System.out.println("--------------------------------------------");
                                c++;
                
                            } 

                        }else if(age==6 ||age==7){
                            if(a=='b' ||a=='B' ){
                                System.out.println("* book number " + (i + 1) + " *");
                                System.out.println("book's call number=     " + k[i].getCallNum());
                                System.out.println("book's name=            " + k[i].getName());
                                System.out.println("book's writer=          " + k[i].getWriter());
                                System.out.println("book's translator=      " + k[i].getTranslator());
                                System.out.println("bookr's publisher=      " + k[i].getPublisher());
                                System.out.println("bookr's genre=          " + k[i].getGenre());
                                System.out.println("bookr's age group=      " + k[i].getAgeGroup());
                                System.out.println("book's year=            " + k[i].getYear());
                                System.out.println("--------------------------------------------"); 
                                c++;

                            } 

                        }else if(age==8 ||age==9){
                            if(a=='C' ||a=='c' ){
                                System.out.println("* book number " + (i + 1) + " *");
                                System.out.println("book's call number=     " + k[i].getCallNum());
                                System.out.println("book's name=            " + k[i].getName());
                                System.out.println("book's writer=          " + k[i].getWriter());
                                System.out.println("book's translator=      " + k[i].getTranslator());
                                System.out.println("bookr's publisher=      " + k[i].getPublisher());
                                System.out.println("bookr's genre=          " + k[i].getGenre());
                                System.out.println("bookr's age group=      " + k[i].getAgeGroup());
                                System.out.println("book's year=            " + k[i].getYear());
                                System.out.println("--------------------------------------------");  
                                c++;
                            } 

                        }else if(age==10 ||age==11){
                            if(a=='d' ||a=='D' ){
                                System.out.println("* book number " + (i + 1) + " *");
                                System.out.println("book's call number=     " + k[i].getCallNum());
                                System.out.println("book's name=            " + k[i].getName());
                                System.out.println("book's writer=          " + k[i].getWriter());
                                System.out.println("book's translator=      " + k[i].getTranslator());
                                System.out.println("bookr's publisher=      " + k[i].getPublisher());
                                System.out.println("bookr's genre=          " + k[i].getGenre());
                                System.out.println("bookr's age group=      " + k[i].getAgeGroup());
                                System.out.println("book's year=            " + k[i].getYear());
                                System.out.println("--------------------------------------------");  
                                c++;
                            } 

                        }else if(age>=12 ||age<=14){
                            if(a=='e' ||a=='E' ){
                                System.out.println("* book number " + (i + 1) + " *");
                                System.out.println("book's call number=     " + k[i].getCallNum());
                                System.out.println("book's name=            " + k[i].getName());
                                System.out.println("book's writer=          " + k[i].getWriter());
                                System.out.println("book's translator=      " + k[i].getTranslator());
                                System.out.println("bookr's publisher=      " + k[i].getPublisher());
                                System.out.println("bookr's genre=          " + k[i].getGenre());
                                System.out.println("bookr's age group=      " + k[i].getAgeGroup());
                                System.out.println("book's year=            " + k[i].getYear());
                                System.out.println("--------------------------------------------");  
                                c++;
                            }  
                        }
                        else{ System.out.println("wrong choise!");}                  
                    }                                          
                }     
                if(c>0){
                    System.out.println("now choose your favorite book");
                    int f=sc.nextInt();
                    //sc.next();                                   
                    if(k[f-1]!= null){
                        ans=k[f-1].getCode()-1001;
                    }                       
                }              
        }
            catch(InputMismatchException e){
                System.out.println("enter number correctly");
                sc.next();
            }
        return ans;
        }
        /** check if the book's age group matches the member's age grop */
    public boolean CheckAgeGroup(int age){
        boolean flag=false;
        if(this.getAgeGroup()=='a' || this.getAgeGroup()=='A'){
            if(age>-1 && age<=5){
                flag=true;
            }
        }
        else if(this.getAgeGroup()=='b' || this.getAgeGroup()=='B'){
            if(age==6 || age==7){
                flag=true;
            }
        }
        else if(this.getAgeGroup()=='c' || this.getAgeGroup()=='C'){
            if(age==8 || age==9){
                flag=true;
            }
        }
        else if(this.getAgeGroup()=='d' || this.getAgeGroup()=='D'){
            if(age==10 || age==11){
                flag=true;
            }
        }
        else if(this.getAgeGroup()=='e' || this.getAgeGroup()=='E'){
            if(age>11 && age<=14){
                flag=true;
            }
        } 
        return flag;
    }
    /**search for index of a book in kids and teens' array */
    public static int searchKat(String callNum, KidsAndTeens[] k) {
        for (int i = 0; i < k.length; i++) {  
            if(k[i] != null){          
                if (callNum.equals(k[i].getCallNum())) {
                    return i;
                }            
            }
        }
        return -1;
    }
}
