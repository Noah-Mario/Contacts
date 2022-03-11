import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Gui extends JFrame implements ActionListener {
    final int width = 100;
    final int height = 40;
    final int x = 50;
    final int y = 50;

    JButton displayContactBtn;
    JButton addContactBtn;

    JButton[] editBtn = new JButton[10];
    JButton[] deleteBtn = new JButton[10];

    JTextField searchBar;

    int index;

    JLabel[] text = new JLabel[10];


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayContactBtn) {
            System.out.println("display");
            for (int i = 0; i < 10; i++) {
                text[i].setVisible(true);
                editBtn[i].setVisible(true);
                deleteBtn[i].setVisible(true);
            }
        } else if (e.getSource() == addContactBtn) {
            System.out.println("added Contact");
        }
    }

    Gui() {
        this.setName("Contacts Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 500);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        /*===========display btn ==============*/

        displayContactBtn = new JButton("Display Contacts");
        //displayContactBtn.setBounds(x, y, width, height);
        this.add(displayContactBtn);
        displayContactBtn.addActionListener(this);

        addContactBtn = new JButton("Add Contact");
        //addContactBtn.setBounds(x * 2, y, width, height);
        this.add(addContactBtn);
        addContactBtn.addActionListener(this);

        searchBar = new JTextField("Search For Name");
        searchBar.setEditable(true);
        this.add(searchBar);

        /*============*/

        for (int i = 0; i < 10; i++) {

            text[i] = new JLabel(i + " contact");
            text[i].setVisible(false);
            this.add(text[i]);

            editBtn[i] = new JButton("Edit");
            editBtn[i].setVisible(false);
            this.add(editBtn[i]);
            editBtn[i].addActionListener(this);

            deleteBtn[i] = new JButton("Delete");
            deleteBtn[i].setVisible(false);
            this.add(deleteBtn[i]);
            deleteBtn[i].addActionListener(this);

        }
    }

}
