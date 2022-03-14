/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class Gui extends JFrame implements ActionListener{

    */
/*for absolute values*//*

*/
/*    final int width = 100;
    final int height = 40;
    final int x = 50;
    final int y = 50;*//*


    int total;

    JButton displayContactBtn;
    JButton addContactBtn;
    JButton searchBtn;

    JButton[] editBtn = new JButton[total];
    JButton[] deleteBtn = new JButton[total];

    JTextField searchBar;

    int index;

    JTextField[] text = new JTextField[total];


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayContactBtn) {
            System.out.println("display");
            for (int i = 0; i < total; i++) {
                text[i].setVisible(true);
                editBtn[i].setVisible(true);
                deleteBtn[i].setVisible(true);
            }
        } else if (e.getSource() == addContactBtn) {
            System.out.println("added Contact");
        } else if (e.getSource() == searchBtn) {
            String value = searchBar.getText();
            System.out.println(value);
        }

        for(int i = 0; i < total; i++) {
            if (e.getSource() == editBtn[i]) {
                JLabel textInput = new JLabel(text[i].getText());
                String newValue = textInput.getText();
                text[i].setText(newValue);
            } else if (e.getSource() == deleteBtn[i]) {
                text[i].setVisible(false);
                editBtn[i].setVisible(false);
                deleteBtn[i].setVisible(false);
            }
        }
    }

    Gui() {

//        String[] contacts = new String[10];
//        Arrays.fill(contacts, " Contact");

        total = contacts.length;

        this.setName("Contacts Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        */
/*===========display btn ==============*//*


        displayContactBtn = new JButton("Display Contacts");
        this.add(displayContactBtn);
        displayContactBtn.addActionListener(this);

        addContactBtn = new JButton("Add");
        this.add(addContactBtn);
        addContactBtn.addActionListener(this);

        searchBar = new JTextField("Search For Name");
        searchBar.setEditable(true);
        this.add(searchBar);

        searchBtn = new JButton("search");
        this.add(searchBtn);
        searchBtn.addActionListener(this);

        */
/*============*//*


        for (int i = 0; i < contacts.length; i++) {

            text = new JTextField("hello")[10];
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
*/
