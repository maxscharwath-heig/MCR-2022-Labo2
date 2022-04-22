package gui;

/**
 * Define the behaviour of an observer
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 * @version 1.0
 * @date 2022-04-22
 */
public interface Observer {
    /**
     * Define behaviour of observer on subject update
     *
     * @param subject observed subject
     */
    void update(Subject subject);
}
