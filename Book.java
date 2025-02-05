//book implementing borrowable interface
//it defines the methods of the interface
class Book implements Borrowable{
    private String title;
    private String author;
    private String ISBN;
    private int quantity;

    //initialising instance variables
    Book(String title,String author,String ISBN,int quantity) {
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.quantity=quantity;
    }

    //accessing data members through getters enhancing encapsulation
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public int getQuantity() {
        return this.quantity;
    }

    //borrowable methods
    public boolean borrow() {
        if(quantity>0) {
            quantity--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        quantity++;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ", Quantity: " + quantity + ")";
    }
}
