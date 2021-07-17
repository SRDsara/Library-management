package com.library;

import java.util.*;
import java.io.*;
import java.nio.file.*;
/**library project
 * @autor Sara Sadeghi
 * @see com.library.Member
 * @see com.library.Book
 * @see com.library.ExquisiteBook
 * @see com.library.KidsAndTeens
 */

public class Main {

    public static void main(String[] args) {
        /**  list of members , max number of members is 999_999 */
        Member[] members = new Member[999999];
        /**  list of books,, max number of books is 9_999 */
        Book[] books = new Book[9999];
        /**  list of books for kids and teens, max number of these books is 9_999 */
        KidsAndTeens[] katbooks=new KidsAndTeens[9999];        
        int numMem = 0;
        int numkat=0;        
        int numBo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Sara's library! ");
        /** this part is just for testing */     
        try{   
            //Member m1=new Member("member number 1",19,'f',"1111111");
            //Member m2=new Member("member number 2",19,'f',"2222222");
            //Member m3=new Member("member number 3",19,'m',"3333333");
            Member m1=new Member("member 1", (short)11, 'f', "1111");
            Member m2=new Member("member 2", (short)22, 'f', "2222");
            Member m3=new Member("member 3", (short)33, 'm', "3333");
            members[0]=m1;
            members[1]=m2;
            members[2]=m3;
            numMem+=3;
            Book b1=new Book("book 1", "writer 1", "translator 1", "publisher 1", "genre 1", 1111);
            ExquisiteBook b2=new ExquisiteBook("book 2", "writer 2", "translator 2", "publisher 2", "genre 2", 2222,"leather");
            KidsAndTeens b3=new KidsAndTeens("book 3", "writer 3", "translator 3", "publisher 3", "genre 3", 3333,'a');
            books[0]=b1;
            books[1]=b2;
            books[2]=b3;
            katbooks[0]=b3;
            numBo+=3;
            FileWriter mems=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt",true);                        
            mems.write(m1.getid()+" , "+m1.getName()+" , "+m1.getAge()+" , "+m1.getSex()+" , "+m1.getPhoneNumber()+"\n");
            mems.write(m2.getid()+" , "+m2.getName()+" , "+m2.getAge()+" , "+m2.getSex()+" , "+m2.getPhoneNumber()+"\n");
            mems.write(m3.getid()+" , "+m3.getName()+" , "+m3.getAge()+" , "+m3.getSex()+" , "+m3.getPhoneNumber()+"\n");
            mems.close();
            FileWriter boks=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt",true);                        
            boks.write(b1.getCallNum()+" , "+b1.getName()+" , "+b1.getWriter()+" , "+b1.getTranslator()+" , "+b1.getPublisher()+" , "+b1.getGenre()+" , "+b1.getYear()+"\n");
            boks.write(b2.getCallNum()+" , "+b2.getName()+" , "+b2.getWriter()+" , "+b2.getTranslator()+" , "+b2.getPublisher()+" , "+b2.getGenre()+" , "+b2.getYear()+" , "+b2.getType()+"\n");
            boks.write(b3.getCallNum()+" , "+b3.getName()+" , "+b3.getWriter()+" , "+b3.getTranslator()+" , "+b3.getPublisher()+" , "+b3.getGenre()+" , "+b3.getYear()+" , "+b3.getAgeGroup()+"\n");
            boks.close();
        }
        catch(IOException e){
            System.out.println("file problems");
        }

        /**  repeat menu forever */
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("1-Create member");
            System.out.println("2-Read member");
            System.out.println("3-Update member's info");
            System.out.println("4-Delete member");
            System.out.println("5-Search member");
            System.out.println("6-Search member's id");            
            System.out.println("7-Create book");
            System.out.println("8-Read book");
            System.out.println("9-Update book's info");
            System.out.println("10-Delete book");
            System.out.println("11-Search book");
            System.out.println("12-Search book's call number");  
            System.out.println("13-Lend Book");
            System.out.println("14-show member's borrowed book");
            System.out.println("15-lend special books to children and teenagers");
            System.out.println("16-Take back a book");
            System.out.println("17-show the members who borrowed the book your considering");
            System.out.println("Choose one to continue... ");
            System.out.println("--------------------------------------------");
            int c=0;
            try{c = sc.nextInt();}
            catch(Exception e){System.out.println("invalid type,enter a number!");}
            sc.nextLine();            
            switch (c) {

                /**create member and save it in members.txt*/
                case 1:
                    Member m=Member.createMem();
                    try{                        
                        members[numMem] = m;
                        numMem++;
                        System.out.println("member's id=" + (m.getid()));
                        FileWriter mems=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt",true);                        
                        mems.write(m.getid()+" , "+m.getName()+" , "+m.getAge()+" , "+m.getSex()+" , "+m.getPhoneNumber()+"\n");
                        mems.close();                        
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("member's storage is full. you can not add new");
                    }
                    catch(NullPointerException e){
                        System.out.println("member did not created, enter age correctly");
                    }
                    catch(IOException e){
                        System.out.println("file problems");
                    }
                    break;
                /**read member's info */
                case 2:
                    System.out.println("member's id: ");
                    try{
                        long id0 = sc.nextLong();                    
                        int a0 = Member.searchMem(id0, members);
                        members[a0].readMem(id0);                    
                    }
                    catch(InputMismatchException e){
                        System.out.println("enter id correctly!!");
                        sc.next();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this member dose not exists!!");
                        }
                    break;
                /**update member's info and saing new changes in members.txt*/
                case 3:
                    try{
                        System.out.println("member's id: ");
                        long id1 = sc.nextLong();
                        int a1 = Member.searchMem(id1, members);                        
                        members[a1].upMem();
                        String newLine=members[a1].getid()+" , "+members[a1].getName()+" , "+members[a1].getAge()+" , "+members[a1].getSex()+" , "+members[a1].getPhoneNumber();
                        File memfile=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt");
                        Scanner msc=new Scanner(memfile);
                        File temp=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\members0.txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));                        
                        while(msc.hasNextLine()) {
                            String line=msc.nextLine();
                            if (! (line.startsWith(String.valueOf(id1)))){                                
                                writer.write(line+"\n");
                            }
                            else{
                                writer.write(newLine+"\n");
                            }                        
                        } 
                        Path from=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\members0.txt");
                        Path to=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt");
                        msc.close();
                        writer.close();                        
                        Files.move(from,to,StandardCopyOption.REPLACE_EXISTING);                
                    }
                    catch(InputMismatchException e){
                        System.out.println("enter id correctly!!");
                        sc.next();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this member dose not exists!!");
                    }
                    catch(IOException e){
                        System.out.println("file problems");
                    }
                    break;
                /** delete member and removing it from members.txt */
                case 4:
                    try{
                        System.out.println("id: ");
                        long id2 = sc.nextLong();
                        int a2 = Member.searchMem(id2, members);
                        Member.delMem(a2, members);
                        numMem--;
                        File memfile=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt");
                        Scanner msc=new Scanner(memfile);
                        File temp=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\members0.txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));                        
                        while(msc.hasNextLine()) {
                            String line=msc.nextLine();
                            if (! (line.startsWith(String.valueOf(id2)))){                                
                                writer.write(line+"\n");
                            }                        
                        }                                              
                        Path from=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\members0.txt");
                        Path to=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\members.txt");
                        msc.close();
                        writer.close();                        
                        Files.move(from,to,StandardCopyOption.REPLACE_EXISTING);                      
                    }
                    catch(InputMismatchException e){
                        System.out.println("enter id correctly!!");
                        sc.next();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this member dose not exists!!");
                        }
                    catch(IOException e){
                        System.out.println("file problems");
                        e.printStackTrace();
                    }
                    break;
                /** search member and return its index*/
                case 5:
                try{
                    System.out.println("member's id: ");
                    long id3 = sc.nextLong();
                    System.out.println(Member.searchMem(id3, members));
                    }
                    catch(InputMismatchException e){
                        System.out.println("enter id correctly!!");
                        sc.next();
                    }
                    break;
                /** search for member's id*/
                case 6:
                    System.out.println("Enter the name(or part of that): ");                    
                    String name1 = sc.nextLine();
                    Member.searchMemID(name1, members);
                    break;
                /** create new book and save it in books.txt*/
                case 7:
                    try{                    
                        System.out.println("Name: ");
                        String name2 = sc.nextLine();
                        System.out.println("Writer: ");
                        String writer = sc.nextLine();
                        System.out.println("Translator: ");
                        String trns = sc.nextLine();
                        if (trns.isEmpty()) {
                            trns = "----";
                        }
                        System.out.println("Publisher: ");
                        String pb = sc.next();
                        System.out.println("genre: ");
                        sc.nextLine();
                        String gn = sc.nextLine();
                        System.out.println("year: ");
                        int xy = sc.nextInt();
                        while (xy < 1000 || xy >= 10000) {
                            System.out.println("invalid , try again:  ");
                            xy = sc.nextInt();
                        }
                        int y = xy;
                        if (gn.equals("Exquisite")||gn.equals("exquisite")) {
                            System.out.println("type:\n handwritten ,leather ,aromatic  ");
                            String xtype = sc.next();
                            while (!(xtype.equals("handwritten")) && !(xtype.equals("leather")) && !(xtype.equals("aromatic"))) {
                                System.out.println("invalid , try again:  ");
                                xtype = sc.next();
                            }
                            String type = xtype;
                            ExquisiteBook b = new ExquisiteBook(name2, writer, trns, pb, gn, y, type);
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));
                            FileWriter boks=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt",true);                        
                            boks.write(b.getCallNum()+" , "+b.getName()+" , "+b.getWriter()+" , "+b.getTranslator()+" , "+b.getPublisher()+" , "+b.getGenre()+" , "+b.getYear()+" , "+b.getType()+"\n");
                            boks.close();

                        }else if(gn.equals("kids and teens")||gn.equals("Kids And Teens")){
                            System.out.println("age group:\n a/A :0-5 \n b/B :6,7 \n c/C :8,9 \n d/D :10,11 \n e/E :12-14 ");
                            char xag=sc.next().charAt(0);
                            while (xag != 'a' && xag != 'b' && xag != 'c' && xag != 'd'&& xag != 'e' && xag != 'A' && xag != 'B' && xag != 'C' && xag != 'D'&& xag != 'E') {
                                System.out.println("invalid , try again:  ");
                                xag = sc.next().charAt(0);
                            }
                            char ag=xag;
                            KidsAndTeens b=new KidsAndTeens(name2, writer, trns, pb, gn, y,ag );                        
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));
                            katbooks[numkat]=b;
                            numkat++;
                            FileWriter boks=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt",true);                        
                            boks.write(b.getCallNum()+" , "+b.getName()+" , "+b.getWriter()+" , "+b.getTranslator()+" , "+b.getPublisher()+" , "+b.getGenre()+" , "+b.getYear()+" , "+b.getAgeGroup()+"\n");
                            boks.close();
                        }else {
                            Book b = new Book(name2, writer, trns, pb, gn, y);
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));  
                            FileWriter boks=new FileWriter("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt",true);                        
                            boks.write(b.getCallNum()+" , "+b.getName()+" , "+b.getWriter()+" , "+b.getTranslator()+" , "+b.getPublisher()+" , "+b.getGenre()+" , "+b.getYear()+"\n");
                            boks.close();                      
                        }
                        
                    }
                    catch(InputMismatchException e){
                        System.out.println("enter year correctly!!");
                        sc.next();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("book's storage is full,you can not add new book!!");
                        }
                    catch(IOException e){
                        System.out.println("file problems");
                    }
                    break;
                /** reading book's info */
                case 8:    
                    try{            
                        System.out.println("enter the book's call number:  ");
                        String s0 = sc.nextLine();
                        int i0 = Book.searchBo(s0, books);                    
                        books[i0].readBo(); 
                    }                   
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this book dose not exists!!");
                    }
                    break;
                /** updating book's info and save the changes in books.txt*/
                case 9:
                    try{                    
                        System.out.println("book's call number: ");
                        String s1 = sc.nextLine();
                        int i1 = Book.searchBo(s1, books);                        
                        String newLine=books[i1].upBo();                   
                        File bookfile=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt");
                        Scanner msc=new Scanner(bookfile);
                        File temp=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\books0.txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));                        
                        while(msc.hasNextLine()) {
                            String line=msc.nextLine();
                            if (! (line.startsWith(s1))){                                
                                writer.write(line+"\n");
                            } 
                            else{
                                writer.write(newLine+"\n");
                            }                       
                        }                                              
                        Path from=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\books0.txt");
                        Path to=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt");
                        msc.close();
                        writer.close();                        
                        Files.move(from,to,StandardCopyOption.REPLACE_EXISTING);               
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this book dose not exists!!");
                    }
                    catch(IOException e){
                        System.out.println("file problems");
                    }
                    break;
                 /** deleting book's info and removing it from books.txt */
                case 10:     
                    try{               
                        System.out.println("enter the book's call number:  ");
                        String s2 = sc.nextLine();
                        int i2 = Book.searchBo(s2, books);
                        Book.delBo(i2, books);           
                        File bookfile=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt");
                        Scanner msc=new Scanner(bookfile);
                        File temp=new File("C:\\Users\\sargo\\java vscode\\com\\Library\\books0.txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));                        
                        while(msc.hasNextLine()) {
                            String line=msc.nextLine();
                            if (! (line.startsWith(s2))){                                
                                writer.write(line+"\n");
                            }                        
                        }                                              
                        Path from=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\books0.txt");
                        Path to=Paths.get("C:\\Users\\sargo\\java vscode\\com\\Library\\books.txt");
                        msc.close();
                        writer.close();                        
                        Files.move(from,to,StandardCopyOption.REPLACE_EXISTING);         
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("this book dose not exists!!");
                    }
                    catch(IOException e){
                        System.out.println("file problems");
                    }
                        break;
                    /** searching book's info */
                    case 11:
                        System.out.println("book's call number: ");
                        String id4 = sc.next();
                        System.out.println(Book.searchBo(id4, books));
                        break;
                    /** enter name or part of it and search for call number */
                    case 12:
                        System.out.println("enter the name or part of it: ");
                        String name3 = sc.next();
                        Book.searchCallNum(name3, books);
                        break;       
                    /** lend book */
                    case 13:
                        try{
                            System.out.println("which member? enter id: ");
                            long ida = sc.nextLong();
                            int idb = Member.searchMem(ida, members);

                            System.out.println("which book? enter call number: ");
                            String callNum6 = sc.next();
                            int callNum1 = Book.searchBo(callNum6, books);                        
                        
                                if (!(books[callNum1].getGenre()).equals("Exquisite")&&!(books[callNum1].getGenre()).equals("exquisite") ) {

                                    if((!(books[callNum1].getGenre()).equals("kids and teens")||!(books[callNum1].getGenre()).equals("Kids And Teens"))&& members[idb].getAge()>=15) {

                                        if (books[callNum1].getExistance() == true) {

                                            boolean x1 = members[idb].borrow(books[callNum1]);
                                            boolean x2=books[callNum1].perBoro(members[idb]);
                                            if (x1 == true && x2== true) {

                                                books[callNum1].setExistance(false);
                                                System.out.println("book " + books[callNum1].getCallNum() + " is borrowed by " + members[idb].getid());

                                            } else { System.out.println("you can not borrow more than 5 books!! OR library's storage is full");
                                                }
                                            } else {System.out.println("this book is not available");
                                                }
                                    }else if(((books[callNum1].getGenre()).equals("kids and teens")||(books[callNum1].getGenre()).equals("Kids And Teens"))&& members[idb].getAge()<15){
                                        int s=KidsAndTeens.searchKat(callNum6,katbooks);
                                        if(katbooks[s].CheckAgeGroup(members[idb].getAge())==true){

                                            if (books[callNum1].getExistance() == true) {

                                                boolean x1 = members[idb].borrow(books[callNum1]);
                                                boolean x2=books[callNum1].perBoro(members[idb]);
                                                if (x1 == true && x2==true) {
    
                                                    books[callNum1].setExistance(false);
                                                    System.out.println("book " + books[callNum1].getCallNum() + " is borrowed by " + members[idb].getid());
    
                                                } else { System.out.println("you can not borrow more than 5 books!! OR library's storage is full");
                                                    }
                                            } else {System.out.println("this book is not available");
                                                }
                                        }else{System.out.println("this book is out of your age group");
                                            }                           
                                    }else {System.out.println("sorry! your age is out of limitation and you can not borrow this book!");
                                        }
                                } else { System.out.println("Sorry ! you can not borrow an exquisite book!!");
                                    }                        
                                }                        
                        catch(InputMismatchException e){
                            System.out.println("enter id correctly!!");
                            sc.next();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("wrong id or wrong call number!!");
                        }
                        break;
                    /** show the books which are borrowed by member */
                    case 14:
                        try{
                            System.out.println("which member? enter id: ");
                            long id6 = sc.nextLong();
                            int id7 = Member.searchMem(id6, members);                           
                            Member.showMemBorrow(members[id7]);                            
                        }
                        catch(InputMismatchException e){
                            System.out.println("enter id correctly!!");
                            sc.next();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("this member dose not exists!!");
                        }
                        break;
                    /**lend books to kids and teenagers*/ 
                    case 15:
                        try{
                            System.out.println("which member? enter id: ");
                            long idc = sc.nextLong();
                            int idd = Member.searchMem(idc, members);                        
                            if(idd>-1 && members[idd]!=null && members[idd].getAge()<15 ){
                                short age0=members[idd].getAge();
                                int a=KidsAndTeens.showApprBook(katbooks, age0);                            
                                if (a>-1 && books[a]!= null && books[a].getExistance() == true) {
                                    boolean x3 = members[idd].borrow(books[a]);
                                    boolean x4=books[a].perBoro(members[idd]);
                                    if (x3 == true && x4==true) {
                                        books[a].setExistance(false);
                                        System.out.println("book " + books[a].getCallNum() + " is borrowed by " + members[idd].getid());
                                    } else {
                                        System.out.println("you can not borrow more than 5 books!! OR library's storage is full");
                                    }
                                } else {
                                    System.out.println("this book is not available OR there is not suitable books");
                                }                       
                            } 
                        }
                        catch(InputMismatchException e){
                            System.out.println("enter id correctly!!");
                            sc.next();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("nothing happened,try again carefully!!");
                        }                        
                        break;
                    /** take back a book */
                    case 16:
                        try{
                            System.out.println("which member? enter id: ");
                            long id9 = sc.nextLong();
                            int id8 = Member.searchMem(id9, members);
                            System.out.println("which book? enter call number: ");
                            String callNum5 = sc.next();
                            int callNuma = Book.searchBo(callNum5, books);
                            boolean x0 = members[id8].remBorrow(books[callNuma]);
                            if (x0 == true) {
                                books[callNuma].setExistance(true);
                                System.out.println("book " + callNum5 + " is deleted!");
                            }else {
                                System.out.println("sth is wrong");
                            }
                        }
                        catch(InputMismatchException e){
                            System.out.println("enter id correctly!!");
                            sc.next();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("book or member dose not exists!!");
                        }
                        break;
                    /** printing list of members who borrowed your fav book */
                    case 17:
                        System.out.println("which book do you consider? enter call number: ");
                        String callNumbb = sc.next();
                        int callnum = Book.searchBo(callNumbb, books);
                        for(int i=0;i<10000000;i++){
                            if(books[callnum].whoBorrowed[i]!= null){
                                System.out.println(books[callnum].whoBorrowed[i].getid()+"-"+books[callnum].whoBorrowed[i].getName());
                            }
                        }
                    default:
                        break;    
            }
        }
    }
}
