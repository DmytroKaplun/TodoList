package org.spring.demo.todolist;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes;
    private final Random r;

    public NoteService() {
        this.notes = new HashMap<>();
        this.r = new Random();
    }

    public Note add(Note note) {
        note.setId(r.nextLong());
        notes.put(note.getId(), note);
        return note;
    }

    public Note getById(long id) {
        return notes.get(id);
    }

    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else throw new NoSuchElementException();
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else throw new NoSuchElementException();
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }
}
