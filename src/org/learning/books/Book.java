package org.learning.books;

public class Book {
    String title;
    int pageNumber;
    String author;
    String editor;

    public Book(String title, int pageNumber, String author, String editor) throws IllegalArgumentException {
        setTitle(title);
        setPageNumber(pageNumber);
        setAuthor(author);
        setEditor(editor);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditor() {
        return editor;
    }

    // Setters
    public void setTitle(String title) throws IllegalArgumentException {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("The book must have a title!");
        }
        this.title = title;
    }

    public void setPageNumber(int pageNumber) throws IllegalArgumentException {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("The number of page must be greater than 0!");
        }
        this.pageNumber = pageNumber;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("The book must have an author!");
        }
        this.author = author;
    }

    public void setEditor(String editor) throws IllegalArgumentException {
        if (editor.isEmpty()) {
            throw new IllegalArgumentException("The book must have an editor!");
        }
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nPage Number: " + pageNumber + "\nAuthor: " + author + "\nEditor: " + editor;
    }

}
