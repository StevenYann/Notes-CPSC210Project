package model;

import java.util.LinkedList;
import java.util.List;

public class Notes {
    private String title;
    private List<String> body;

    // CONSTRUCTOR
    // EFFECTS: Creates a new note with the given title
    public Notes(String title) {
        this.title = title;
        body = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a string into the body of the notes
    public void addEntryToBody(String entry) {
        body.add(entry);
    }

    // REQUIRES: body must have an entry in the given index number
    // MODIFIES: this
    // EFFECTS: deletes the string from the body at the given index number
    public void deleteBodyByIndex(int i) {
        body.remove(i);
    }

    // EFFECTS: returns true if title is the same as the given string, false otherwise
    public boolean hasTitle(String s) {
        return s.equals(title);
    }

    // REQUIRES: body must have an entry at the given index
    // EFFECTS: returns the specified entry in body, with index / line number as its first character
    public String getEntryWithLineNumber(int i) {
        String lineNumber = Integer.toString(i + 1);
        return "Line " + lineNumber + ": " + body.get(i);
    }

    // EFFECTS: prints out all entries in body, with their corresponding line numbers
    public void printAllLines() {
        for (int i = 0; i < body.size(); i++) {
            System.out.println(getEntryWithLineNumber(i));
        }
    }

    // EFFECTS: returns true if i is less than the body size (is in the index of the body)
    public boolean withinIndex(int i) {
        return i < body.size();
    }

    // EFFECTS: gets title of note
    public String getTitle() {
        return title;
    }

    // EFFECTS: sets the title to the given string
    public void setTitle(String title) {
        this.title = title;
    }

}
