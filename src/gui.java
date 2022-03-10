import javax.swing.*;
class gui{
    public static void main(String[] args){
        JFrame frame = new JFrame("Contact List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,800);
        JButton showContacts = new JButton("Display Contacts");
        JButton addContacts = new JButton("Add Contacts");
        JButton removeContacts = new JButton("Remove Contact");
        JButton searchContact = new JButton("Display Contact");
        frame.getContentPane().add(showContacts); // Adds Button to content pane of frame
        frame.getContentPane().add(addContacts);
        frame.getContentPane().add(removeContacts);
        frame.getContentPane().add(searchContact);
        frame.setVisible(true);

    }
}