package com.library;
import java.util.*;

/** 
 * @see com.library.Main
 * @see com.library.Book
 * @see com.library.Member
 * @see com.library.KidsAndTeens
 */ 
public class ExquisiteBook extends Book{
    private String type;

    /**constructor*/
    public ExquisiteBook(String name, String writer, String translator, String publisher,String genre, int year,String type) {
        super(name, writer, translator, publisher,genre, year);
        this.setGenre("exquisite");
        setType(type);
    }
    /**setter*/
    public void setType(String type){ this.type=type;    }
    /**getter*/
    public String getType(){return this.type;}
    /** overriding methods */
    @Override
    public void readBo() {
        super.readBo();
        System.out.println("book's type=         " + this.getType());
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
            System.out.print("New type:\n handwritten ,leather ,aromatic ");
            String xnty = sc.nextLine();
            String nty;
            if (xnty.isEmpty()) {
                nty = this.getType();
            }else{
                while (!(xnty.equals("handwritten")) && !(xnty.equals("leather")) && !(xnty.equals("aromatic"))) {
                    System.out.println("invalid , try again:  ");
                    xnty = sc.next();
                }
                nty=xnty;
                }

            this.setName(nname);
            this.setWriter(nwr);
            this.setTranslatore(ntrn);
            this.setPublisher(npb);
            this.setGenre("exquisite");
            this.setType(nty);
            this.setYear(nyear);
            this.setCallNum(nwr,nyear);
            System.out.println("book number " + (this.getCode()) + " is updated and the new call number is:"+this.getCallNum());
            return (this.getCallNum()+" , "+this.getName()+" , "+this.getWriter()+" , "+this.getTranslator()+" , "+this.getPublisher()+" , "+this.getGenre()+" , "+this.getYear()+","+this.getType());
           
        }
        catch(InputMismatchException e){
            System.out.println("enter year correctly");
        }
        return "";
    }
    

}
