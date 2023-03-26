import javax.swing.*;

public class PhoneBook {

    private String[] columnNames = {"Name","City","Phone"};
    String[][] data = new String[0][];


    private JFrame frame = new JFrame();

    //label
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel cityLabel = new JLabel("City: ");
    private JLabel phoneLabel = new JLabel("Phone: ");

    //text field
    private JTextField nameField = new JTextField();
    private JTextField cityField = new JTextField();

    private JTextField phoneField = new JTextField();

    //buttons
    private JButton insertBtn = new JButton("INSERT");
    private JButton resetBtn = new JButton("RESET");

    //table
    private JTable record;

    public void renderFrame(){

        frame.setTitle("Phone Book");
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        renderInputField();
        renderTable();
    }

    private void renderInputField(){

        nameLabel.setBounds(60,40,50,50);
        nameField.setBounds(110,50,200,30);


        cityLabel.setBounds(60,70,50,50);
        cityField.setBounds(110,80,200,30 );

        phoneLabel.setBounds(60,100,50,50);
        phoneField.setBounds(110,110,200,30);

        insertBtn.setFocusable(false);
        resetBtn.setFocusable(false);
        insertBtn.setBounds(110,150,90,40);
        resetBtn.setBounds(220,150,90,40);

        frame.add(nameLabel);
        frame.add(cityLabel);
        frame.add(phoneLabel);

        frame.add(nameField);
        frame.add(cityField);
        frame.add(phoneField);

        frame.add(insertBtn);
        frame.add(resetBtn);


    }

    private void renderTable(){
        record = new JTable(data,columnNames);
        JScrollPane tableScroll = new JScrollPane(record);
        tableScroll.setBounds(10,200,365,260);
        frame.add(tableScroll);
    }
}
