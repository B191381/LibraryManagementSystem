//inheritance nonfictionbook class extending the base class
class NonFictionBook extends Book {
    private String field;
    NonFictionBook(String title, String author, String ISBN, int quantity,String field) {
        //call the parent class constructor
        super(title,author,ISBN,quantity);
        this.field=field;
    }
        public String toString() {
            return super.toString() + " [Non-Fiction, Field: " + field + "]";
        }
}