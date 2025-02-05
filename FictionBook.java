//inheritance Fictionbook class extending the base class
class FictionBook extends Book {
    private String genre;
    FictionBook(String title, String author, String ISBN, int quantity,String genre) {
        //call the parent class constructor
        super(title,author,ISBN,quantity);
        this.genre=genre;
    }
        public String toString() {
            return super.toString() + " [Fiction, Genre: " + genre + "]";
        }
}
