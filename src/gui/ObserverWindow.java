package gui;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class that define an observer window that can attach observers to subjects
 * and that will detach them when closed.
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public abstract class ObserverWindow extends JFrame implements Observer {
    private final LinkedList<Subject> subjects;

    protected ObserverWindow(String title) {
        super(title);
        subjects = new LinkedList<>();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
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
