package ui;

import model.NoTitleException;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteCreationGUI extends JFrame {

    private static final int WIDTH = 320;
    private static final int HEIGHT = 240;

    JTextPane pane;

    // https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
    NoteCreationGUI() {
        super("Note Creation");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);

        addUIElements();

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setVisible(true);
    }

    private void addUIElements() {
        pane = new JTextPane();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        pane.setParagraphAttributes(center, true);
        pane.setBorder(BorderFactory.createTitledBorder("Note Title"));
        pane.setSize(new Dimension(WIDTH / 10, HEIGHT / 4));

        JSplitPane divider = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pane, createButton());
        divider.setDividerLocation(HEIGHT / 2);
        divider.setDividerSize(5);
        divider.setEnabled(false);
        add(divider);

    }

    private JButton createButton() {
        JButton button = new JButton("Create Note");
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainGUI(pane.getText());
                    dispose();
                } catch (NoTitleException noTitleException) {
                    createTitleWarning();
                }
            }
        });
        return button;
    }

    // TODO: fix this
    private void createTitleWarning() {
        JLabel titleWarning = new JLabel("Enter a proper title!");
        titleWarning.setForeground(Color.RED);
        add(titleWarning);
    }
}