import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class Gui extends JFrame implements ActionListener {
    int numberOfContacts = ContactCtrl.scanContacts(main.filepath).size();

    JButton displayContactBtn;
    JButton addContactBtn;
    JButton searchBtn;

    JButton[] editBtn = new JButton[numberOfContacts];
    JButton[] deleteBtn = new JButton[numberOfContacts];

    JTextField searchBar;

    JLabel[] text = new JLabel[numberOfContacts];


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayContactBtn) {
            System.out.println("display");
            for (int i = 0; i < numberOfContacts; i++) {
                text[i].setVisible(true);
                editBtn[i].setVisible(true);
                deleteBtn[i].setVisible(true);
            }
        } else if (e.getSource() == addContactBtn) {
            System.out.println("added Contact");
        } else if (e.getSource() == searchBtn) {
            String value = searchBar.getText();
            try {
                String foundName = ContactCtrl.searchContact(main.filepath, value);
                for(int i = 0; i < numberOfContacts; i++) {
                    if(text[i].getText().contains(foundName)) {
                        text[i].setVisible(true);
                    } else {
                        text[i].setVisible(false);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < numberOfContacts; i++) {
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

    Gui() throws IOException {

        //==========================
        //convert List to Array
        String[] contacts = new String[ContactCtrl.scanContacts(main.filepath).size()];
        ContactCtrl.scanContacts(main.filepath).toArray(contacts);
        //============================

        this.setName("Contacts");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

//===========display btn ==============


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

//============

        //obtener el numero de contactos de el documento
        for (int i = 0; i < numberOfContacts; i++) {
            text[i] = new JLabel(contacts[i]);
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
