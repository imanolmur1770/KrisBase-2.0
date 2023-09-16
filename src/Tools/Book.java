package Tools;

//The purpose of this .java file is to establish the object-oriented structure of the Tools.Book data
public class Book implements java.io.Serializable {
    private String BookName;
    //The name of the book goes in a string
    private String Author;
    //The name of the author goes in a string
    private String Genre;
    //The name of the genre goes in a string
    private String Read;
    //The status if it has been read or not goes in a string. Only permits yes/no/DNF
    private String Rating;
    //The rating goes in a double. Only up to 1-6
    private String Barcode;
    //The barcode goes ina string

    public Book(String BN, String Au, String Ge, String Re, String Ra, String Ba){
        //constructor
        BookName = BN;
        Author = Au;
        Genre = Ge;
        Read = Re;
        Rating = Ra;
        Barcode = Ba;
    }
    public Book(){
        BookName= "";
        Author= "";
        Genre= "";
        Read= "";
        Rating = "";
    }
    public String getBookName(){
        return BookName;
    }
    public String getAuthor(){
        return Author;
    }
    public String getGenre(){
        return Genre;
    }
    public String getRead(){
        return Read;
    }
    public String getRating(){
        return Rating;
    }
    public String getBarcode() {
        return Barcode;
    }

    public void setBookName(String bookname){
        BookName=bookname;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setRead(String read) {
        Read = read;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
