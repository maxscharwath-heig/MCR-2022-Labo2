package gui;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class ObserverWindow extends JFrame implements Observer {
    private final LinkedList<Subject> subjects;

    protected ObserverWindow(String title) {
        super(title);
        subjects = new LinkedList<>();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * Start observing subjects
     *
     * @param subjects List of subjects to observe
     */
    protected void attach(LinkedList<? extends Subject> subjects) {
        for (Subject s : subjects) {
            this.subjects.add(s);
            s.attach(this);
        }
    }

    /**
     * Start observing subjects
     *
     * @param subjects Subjects to observe
     */
    protected void attach(Subject... subjects) {
        LinkedList<Subject> list = new LinkedList<>(Arrays.asList(subjects));
        attach(list);
    }

    /**
     * Stop observing registered subjects
     */
    @Override
    public void dispose() {
        super.dispose();
        for (Subject s : subjects) {
            s.detach(this);
        }
    }
}
