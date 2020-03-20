package com.galvanize.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="Note")

public class Note{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noteKey")
    private int noteKey;
    @Column(name = "dateTime")
    private Timestamp timeOfNote;
    @Column(name = "note")
    private String noteDescription;
    @Column(name = "customerRequestNumber")
    private int customerRequestNumber;

    public Note() {
    };

    public Note(String noteDescription, int customerRequestNumber) {
        this(Timestamp.valueOf(LocalDateTime.now()), noteDescription, customerRequestNumber);
    }

    public Note(Timestamp timeOfNote, String noteDescription, int customerRequestNumber) {
        this.timeOfNote = timeOfNote;
        this.noteDescription = noteDescription;
        this.customerRequestNumber = customerRequestNumber;
    }

    public Note(int noteKey,Timestamp timeOfNote, String noteDescription, int customerRequestNumber) {
        this(timeOfNote, noteDescription, customerRequestNumber);
        this.noteKey = noteKey;
    }

    public int getNoteKey() {
        return noteKey;
    }

    public void setNoteKey(int noteKey) {
        this.noteKey = noteKey;
    }

    public Timestamp getTimeOfNote() {
        return timeOfNote;
    }

    public void setTimeOfNote(Timestamp timeOfNote) {
        this.timeOfNote = timeOfNote;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public int getCustomerRequestNumber() {
        return customerRequestNumber;
    }

    public void setCustomerRequestNumber(int customerRequestNumber) {
        this.customerRequestNumber = customerRequestNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(getTimeOfNote(), note.getTimeOfNote()) &&
                Objects.equals(getNoteDescription(), note.getNoteDescription());    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimeOfNote(), getNoteDescription());
    }
}