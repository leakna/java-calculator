import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Demo extends Frame implements ActionListener {
    TextField txt=new TextField();
    Button[] button= {new Button("%"),new Button("√"),new Button("x²"),new Button("1/x")
    ,new Button("7"),new Button("8"),new Button("9"),new Button("÷"),
            new Button("4"),new Button("5"),new Button("6"),new Button("x"),
            new Button("1"),new Button("2"),new Button("3"),new Button("-")
            ,new Button("."),new Button("0"),new Button("="),new Button("+")};
    Button[] del={new Button("c"),new Button("del")};
    Panel panel=new Panel();
    Font myfont=new Font(null,Font.PLAIN,20);
    Demo(){
        setTitle("Calculator");
        setSize(400,500);
        setLayout(null);
        setBackground(Color.lightGray);
        txt.setBounds(20,50,360,50);
        txt.setFont(myfont);
        txt.setEditable(false);
        add(txt);

        panel.setBounds(20, 110, 360, 300);
        panel.setLayout(new GridLayout(5,4,5,5));
        //panel.setBackground(Color.CYAN);
        for(int i=0;i<button.length;i++){
            button[i].setFont(myfont);
         //   button[i].setBackground(Color.LIGHT_GRAY);
            button[i].addActionListener(this);
            panel.add(button[i]);
        }
        int x=20;
        for(int i=0;i<del.length;i++){
            del[i].setBounds(x,420,175,50);
            del[i].addActionListener(this);
            x+=180;
            add(del[i]);
        }
        add(panel);
        addWindowListener(new WindowAdapter() {
                              public void windowClosing (WindowEvent e) {
                                  dispose();
                              }
                          }
        );
        setVisible(true);
    }
    String op;
    String number="";
    String display="";
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if (e.getSource() == button[0]) {
                    txt.setText(Double.toString(Double.valueOf(txt.getText()) / 100));
            }
            else if (e.getSource() == button[1]) {
                    txt.setText(Double.toString(Math.sqrt(Double.valueOf(txt.getText()))));
            }
            else if (e.getSource() == button[2]) {
                    txt.setText(Double.toString(Math.pow(Double.valueOf(txt.getText()),2)));
            }

            else if (e.getSource() == button[3]) {
                    txt.setText(Double.toString(1 / Double.valueOf(txt.getText())));
            }
            else if (e.getSource() == button[4]) {
               Display("7");
            }
            else if (e.getSource() == button[5]) {
                Display("8");

            }
            else if (e.getSource() == button[6]) {
                Display("9");

            }
            else if (e.getSource() == button[7]) {
                Display("÷");
                op="÷";
            }
            else if (e.getSource() == button[8]) {
                Display("4");
            }
            else if (e.getSource() == button[9]) {
                Display("5");
            }
            else if (e.getSource() == button[10]) {
                Display("6");
            }
            else if (e.getSource() == button[11]) {
                Display("x");
                op="x";
            }
            else if (e.getSource() == button[12]) {
                Display("1");
            }
            else if (e.getSource() == button[13]) {
                Display("2");
            }
            else if (e.getSource() == button[14]) {
                Display("3");
            }
            else if (e.getSource() == button[15]) {
                if (txt.getText().equals("")) {
                    Display("-");
                }
                else {
                    System.out.println("first");
                    Display("-");
                    op="-";
                }
            }


            else if (e.getSource() == button[16]) {
                if (txt.getText().equals("")) txt.setText("");
                else Display(".");
            }
            else if (e.getSource() == button[17]) {
                Display("0");

            }
            else if (e.getSource() == button[18]) {
              String[] arr=new String[10];
              String pass="";
              if(display.charAt(0)=='-'){
                  for (int i=1;i<display.length();i++)
                      pass=pass+display.charAt(i);
                  System.out.println(pass);
                  arr=pass.split(op);
                  arr[0]="-"+arr[0];
//                  for(int j=0;j<arr.length;j++)
//                      arr[j]=arr[j+1];
                  System.out.println(arr.length);
              }
              else arr=display.split(op);
              for (int i=0;i<arr.length;i++)
                  System.out.println(arr[i]);

                switch(op){
                    case "\\+": {
                        double sum = Double.valueOf(arr[0]);
                        for (int i = 1; i < arr.length; i++) {
                            System.out.println(arr[i]);
                            sum = Double.valueOf(arr[i]) + sum;
                        }
                        Result(sum);
                        break;
                    }
                    case "-": {
                        double diff =  Double.valueOf(arr[0]);
                        for (int i = 1; i < arr.length; i++) {
                            diff =diff- Double.valueOf(arr[i]);
                        }
                        Result(diff);
                        break;
                    }
                    case "x": {
                        double pro =  Double.valueOf(arr[0]);
                        for (int i = 1; i < arr.length; i++) {
                            pro =pro* Double.valueOf(arr[i]);
                        }
                        Result(pro);
                        break;
                    }
                    case "÷": {
                        double divi =  Double.valueOf(arr[0]);
                        for (int i = 1; i < arr.length; i++) {
                            divi =divi/Double.valueOf(arr[i]);
                        }
                        Result(divi);
                        break;
                    }
                    default:
                        System.out.println("wrong one");
                }
                op="";
            }

            else if (e.getSource() == button[19]) {
                Display("+");
                op="\\+";
                System.out.println(op);
            }
            else if (e.getSource()==del[0]){
                String temp="";
                for (int i=0;i<display.length()-1;i++)
                    temp=temp+display.charAt(i);
                display=temp;
                txt.setText(display);
            }
            else if (e.getSource()==del[0]){
                String temp="";
                for (int i=0;i<display.length()-1;i++)
                    temp=temp+display.charAt(i);
                txt.setText(temp);
            }
            else if (e.getSource()==del[1]){
                txt.setText("");
            }


        }
        catch (Exception E) {
            txt.setText("error");
        }
        }

    void Display(String character){
        display = txt.getText().concat(character);
        txt.setText(display);
    }
    void Result(double num){
        if(num%1==0){
            int intergerNum=(int)num;
            txt.setText(Integer.toString(intergerNum));
            display=Integer.toString(intergerNum);
        }
        else {
            txt.setText(Double.toString(num));
            display=Double.toString(num);
        }
    }
    }



