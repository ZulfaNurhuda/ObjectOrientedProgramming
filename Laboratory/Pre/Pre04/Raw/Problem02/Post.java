/**
 * Post.java
 * 
 * Pahami bahwa Post memanglah abstract class, namun ia tidak harus memiliki method abstract
 * Ia memang abstract class karena ia tidak dapat diinstansiasi sebagai objek Post secara langsung, sehingga kita harus menggunakan kelas turunannya
 */

public abstract class Post {
    private String author;
    private String caption;
    private int likes;
    private int comments;
    private int shares;

    public Post(String author, String caption) {
        this.author = author;
        this.caption = caption;
        this.likes = 0;
        this.comments = 0;
        this.shares = 0;
    }
    
    public void like()    { likes++; }
    public void comment() { comments++; }
    public void share()   { shares++; }

    protected int baseScore() {
        return likes * 1 + comments * 2 + shares * 3;
    }

    public String getAuthor() {
        return author;
    }

    public String getCaption() {
        return caption;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getShares() {
        return shares;
    }
}