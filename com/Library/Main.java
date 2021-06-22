package com.library;

//library project by sara sadeghi**
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Member[] members = new Member[999999];
        Book[] books = new Book[9999];
        KidsAndTeens[] katbooks=new KidsAndTeens[9999];
        final int maxMem = 999_999;
        int numMem = 0;
        int numkat=0;
        final int maxBo = 9_999;
        int numBo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Sara's library! ");
        // repeat menu forever
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("1-Create member");
            System.out.println("2-Read member");
            System.out.println("3-Update member's info");
            System.out.println("4-Delete member");
            System.out.println("5-Search member");
            System.out.println("6-Search member's id");
            System.out.println("7-Show members' information");
            System.out.println("8-Create book");
            System.out.println("9-Read book");
            System.out.println("10-Update book's info");
            System.out.println("11-Delete book");
            System.out.println("12-Search book");
            System.out.println("13-Search book's call number");
            System.out.println("14-Show book's information");
            System.out.println("15-Lend Book");
            System.out.println("16-show member's borrowed book");
            System.out.println("17-lend special books to children and teenagers");
            System.out.println("18-remove book from borrowed list");
            System.out.println("Choose one to continue... ");
            System.out.println("--------------------------------------------");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {

                //create member
                case 1:
                        Member m=Member.createMem();
                        if (numMem < maxMem) {
                        members[numMem] = m;
                        numMem++;
                        System.out.println("member's id=" + (m.getid()));
                    } else {
                        System.out.println("member's storage is Full! ");
                    }
                    break;
                //read member's info
                case 2:
                    System.out.println("member's id: ");
                    long id0 = sc.nextLong();
                    int a0 = Member.searchMem(id0, members);
                    if (a0 != -1) {
                        members[a0].readMem(id0);
                    } else {
                        System.out.println("this member dose not exists!!");
                    }
                    break;
                //update member's info
                case 3:
                    System.out.println("member's id: ");
                    long id1 = sc.nextLong();
                    int a1 = Member.searchMem(id1, members);
                    if (a1 != -1) {
                        members[a1].upMem();
                    } else {
                        System.out.println("this member dose not exists!!");
                    }
                    break;
                //delete member
                case 4:
                    System.out.println("id: ");
                    long id2 = sc.nextLong();
                    int a2 = Member.searchMem(id2, members);
                    if (a2 != -1) {
                        Member.delMem(a2, members);
                        numMem--;
                    } else {
                        System.out.println("this member dose not exists!!");
                    }
                    break;
                //search member
                case 5:
                    System.out.println("member's id: ");
                    long id3 = sc.nextLong();
                    System.out.println(Member.searchMem(id3, members));
                    break;
                //search member's id
                case 6:
                    System.out.println("Enter the name(or part of that): ");
                    sc.nextLine();
                    String name1 = sc.nextLine();
                    Member.searchMemID(name1, members);
                    break;
                //show member's information
                case 7:
                    Member.showInfMem(members);
                    break;
                //create new book
                case 8:                    
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
                        if (numBo < maxBo) {
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));

                        } else {
                            System.out.println("book's storage is Full! ");
                        }
                    }else if(gn.equals("kids and teens")||gn.equals("Kids And Teens")){
                        System.out.println("age group:\n a/A :0-5 \n b/B :6,7 \n c/C :8,9 \n d/D :10,11 \n e/E :12-14 ");
                        char xag=sc.next().charAt(0);

                        while (xag != 'a' && xag != 'b' && xag != 'c' && xag != 'd'&& xag != 'e' && xag != 'A' && xag != 'B' && xag != 'C' && xag != 'D'&& xag != 'E') {
                            System.out.println("invalid , try again:  ");
                            xag = sc.next().charAt(0);
                        }
                        char ag=xag;

                        KidsAndTeens b=new KidsAndTeens(name2, writer, trns, pb, gn, y,ag );
                        if (numBo < maxBo) {
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));
                        } else {
                            System.out.println("book's storage is Full! ");
                        }
                        if(numkat<9999){
                            katbooks[numkat]=b;
                            numkat++;
                        }else {
                            System.out.println("kids and teens' book's storage is Full! ");
                        }
                    } else {
                        Book b = new Book(name2, writer, trns, pb, gn, y);
                        if (numBo < maxBo) {
                            books[numBo] = b;
                            numBo++;
                            System.out.println("book's call number=" + (b.getCallNum()));
                        } else {
                            System.out.println("book's storage is Full! ");
                        }
                    }

                    break;
                // reading book's info
                case 9:                    
                    System.out.println("enter the book's call number:  ");
                    String s0 = sc.nextLine();
                    int i0 = Book.searchBo(s0, books);
                    if (i0 != -1) {
                        books[i0].readBo();
                    } else {
                        System.out.println("this member dose not exists!!");
                    }
                    break;
                //updating book's info
                case 10:                    
                    System.out.println("book's call number: ");
                    String s1 = sc.nextLine();
                    int i1 = Book.searchBo(s1, books);
                    if (i1 != -1) {
                        books[i1].upBo(i1);
                        } else {
                            System.out.print("this book dose not exists!!");
                        }
                        break;
                 //deleting book's info
                case 11:                    
                    System.out.println("enter the book's call number:  ");
                    String s2 = sc.nextLine();
                    int i2 = Book.searchBo(s2, books);
                    if (i2 != -1) {
                        Book.delBo(i2, books);
                    } else {
                            System.out.println("this book dose not exists!!");
                        }
                        break;
                        //searching book's info
                    case 12:
                    System.out.println("book's call number: ");
                    String id4 = sc.next();
                    System.out.println(Book.searchBo(id4, books));
                        break;
                    //enter name or part of it and search for call number
                    case 13:
                        System.out.println("enter the name or part of it: ");
                        String name3 = sc.next();
                        Book.searchCallNum(name3, books);
                        break;
                    //showing all the book's info
                    case 14:
                        Book.showInfBo(books);
                        break;
                    //lend book
                    case 15:
                        System.out.println("which member? enter id: ");
                        long ida = sc.nextLong();
                        int idb = Member.searchMem(ida, members);

                        System.out.println("which book? enter call number: ");
                        String callNum6 = sc.next();
                        int callNum1 = Book.searchBo(callNum6, books);
                        if (idb != -1 && callNum1 != -1) {
                            if (!(books[callNum1].getGenre()).equals("Exquisite")&&!(books[callNum1].getGenre()).equals("exquisite") ) {

                                if((!(books[callNum1].getGenre()).equals("kids and teens")||!(books[callNum1].getGenre()).equals("Kids And Teens"))&& members[idb].getAge()>=15) {

                                    if (books[callNum1].getExistance() == true) {

                                        boolean x1 = members[idb].borrow(books[callNum1]);
                                        if (x1 == true) {

                                            books[callNum1].setExistance(false);
                                            System.out.println("book " + books[callNum1].getCallNum() + " is borrowed by " + members[idb].getid());

                                        } else { System.out.println("you can not borrow more than 5 books!!");
                                            }
                                        } else {System.out.println("this book is not available");
                                            }
                                }else if(((books[callNum1].getGenre()).equals("kids and teens")||(books[callNum1].getGenre()).equals("Kids And Teens"))&& members[idb].getAge()<15){
                                    int s=KidsAndTeens.searchKat(callNum6,katbooks);

                                    if(katbooks[s].CheckAgeGroup(members[idb].getAge())==true){

                                        if (books[callNum1].getExistance() == true) {

                                            boolean x1 = members[idb].borrow(books[callNum1]);
                                            if (x1 == true) {
    
                                                books[callNum1].setExistance(false);
                                                System.out.println("book " + books[callNum1].getCallNum() + " is borrowed by " + members[idb].getid());
    
                                            } else { System.out.println("you can not borrow more than 5 books!!");
                                                }
                                        } else {System.out.println("this book is not available");
                                            }
                                    }else{System.out.println("this book is out of your age group");
                                        }                           
                                }else {System.out.println("sorry! your age is out of limitation and you can not borrow this book!");
                                    }
                            } else { System.out.println("Sorry ! you can not borrow an exquisite book!!");
                                   }
                        } else { System.out.println("wrong id or wrong call number!!");
                            }
                        break;
                    //show the books which are borrowed by member
                    case 16:
                        System.out.println("which member? enter id: ");
                        long id6 = sc.nextLong();
                        int id7 = Member.searchMem(id6, members);
                        if (id7 != -1) {
                            Member.showMemBorrow(members[id7]);
                        } else {
                            System.out.println("this member dose not exists!!");
                        }
                        break;
                    //lend books to kids and teenagers   
                    case 17:
                        System.out.println("which member? enter id: ");
                        long idc = sc.nextLong();
                        int idd = Member.searchMem(idc, members);
                        if(idd != -1){
                        if(members[idd].getAge()<15){
                            short age0=members[idd].getAge();
                            int a=KidsAndTeens.showApprBook(katbooks, age0);
                            if(a>-1){
                            if (books[a].getExistance() == true) {
                                boolean x2 = members[idd].borrow(books[a]);
                                if (x2 == true) {
                                    books[a].setExistance(false);
                                    System.out.println("book " + books[a].getCallNum() + " is borrowed by " + members[idd].getid());
                                } else {
                                    System.out.println("you can not borrow more than 5 books!!");
                                }
                            } else {
                                System.out.println("this book is not available");
                            }
                        }
                        }else{System.out.println("sorry ! your age is out of limitation!!"); }
                        }  
                        break;
                    //take back a book
                    case 18:
                        System.out.println("which member? enter id: ");
                        long id9 = sc.nextLong();
                        int id8 = Member.searchMem(id9, members);
                        System.out.println("which book? enter call number: ");
                        String callNum5 = sc.next();
                        int callNuma = Book.searchBo(callNum5, books);
                        if (id8 != -1 && callNuma != -1) {
                            boolean x0 = members[id8].remBorrow(books[callNuma]);
                            if (x0 == true) {
                                books[callNuma].setExistance(true);
                                System.out.println("book " + callNum5 + " is deleted!");
                            } else {
                                System.out.println("sth is wrong");
                            }
                        } else {
                            System.out.println("wrong choise,try again");
                        }
                        break;
                }
            }
        }
    }
