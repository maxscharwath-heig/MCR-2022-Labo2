package gui;

import java.util.LinkedList;

/**
 * Defining the behaviour of an observable subject
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public abstract class Subject {
    private final LinkedList<Observer> observers;

    /**
     * Creates a new subject
     */
    public Subject() {
        observers = new LinkedList<>();
    }

    /**
     * Attach an observer to a subject
     *
     * @param o observer
     */
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * Detach an observer from a subject
     *
     * @param o observer
     */
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Notify observer of subject's mutation
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
