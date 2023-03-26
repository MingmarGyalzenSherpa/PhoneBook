import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PhoneBook implements ActionListener {

    final int columnLength = 3;
    final int labelWidth = 50, labelHeight = 50, fieldWidth = 200, fieldHeight = 30,btnWidth = 90, btnHeight = 40;
    private String[] columnNames = {"Name","City","Phone"};
    String[][] data = new String[0][columnLength];


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
        renderInputField();
        renderTable();
        frame.setVisible(true);

    }

    private void renderInputField(){

        nameLabel.setBounds(60,40,labelWidth,labelHeight);
        nameField.setBounds(110,50,fieldWidth,fieldHeight);


        cityLabel.setBounds(60,70,labelWidth,labelHeight);
        cityField.setBounds(110,80,fieldWidth,fieldHeight );

        phoneLabel.setBounds(60,100,labelWidth,labelHeight);
        phoneField.setBounds(110,110,fieldWidth,fieldHeight);

        insertBtn.setFocusable(false);
        resetBtn.setFocusable(false);
        insertBtn.setBounds(110,150,btnWidth,btnHeight);
        resetBtn.setBounds(220,150,btnWidth,btnHeight);

        frame.add(nameLabel);
        frame.add(cityLabel);
        frame.add(phoneLabel);

        frame.add(nameField);
        frame.add(cityField);
        frame.add(phoneField);

        frame.add(insertBtn);
        frame.add(resetBtn);

        insertBtn.addActionListener(this);
        resetBtn.addActionListener(this);


    }

    private void renderTable(){
        record = new JTable(data,columnNames);
        record.setRowHeight(30);
        JScrollPane tableScroll = new JScrollPane(record,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tableScroll.setBounds(10,200,365,260);
        frame.add(tableScroll);
    }

    public void actionPerformed(ActionEvent e){


        if(e.getSource() == insertBtn)
        {
            if(Objects.equals(nameField.getText(), "") || Objects.equals(cityField.getText(), "") || Objects.equals(phoneField.getText(), "")){
                return;
            }

            String[] entry = {nameField.getText(),cityField.getText(),phoneField.getText()};

            nameField.setText("");
            cityField.setText("");
            phoneField.setText("");

            if(data.length == 0) // if table is empty
            {
                data = new String[1][columnLength]; //new array of lenght 1 to store record
                for(int i = 0; i < 3; i++) {
                    data[0][i] = entry[i];
                }
            }else{ //if table isnt empty
                int newLength = data.length + 1; //increase size to record the new data;
                String[][] tempData = data;
                data = new String[newLength][columnLength];
                for(int i = 0 ; i < newLength ; i++)
                {
                    for(int j = 0 ; j < columnLength;j++ )
                    {
                        if(i > newLength - 2)
                        {
                            data[i][j] = entry[j];
                        }else{
                            data[i][j] = tempData[i][j];
                        }
                    }
                }

            }

            renderTable();
        }
        if(e.getSource() == resetBtn)
        {
            data = new String[0][];
            renderTable();
        }
    }
}
