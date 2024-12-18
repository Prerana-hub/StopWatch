import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {
    //global variables and objects
    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel  timeLabel = new JLabel();  // to hold the current time
    int elapsedTime = 0;
    int seconds = 0;
    int minutes =0;
    int hours =0;
    boolean started = false; //to determine the timer has started or not.
    //we are going to create a string that will act as a placeholder that
    // will hold a bunch of zeroes as the time is going up.

    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    //creating a timer
    Timer timer = new Timer(1000, new ActionListener() {         //the first argument that we pass is how often
                                                                    // we want the timer to do something,like if we want the timer to do something every second, then we pass it in milliseconds.
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime +=1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000)   % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            //update the time label with new strings of hours,minutes,seconds
            timeLabel.setText(hours_string +":" + minutes_string +":"+seconds_string);
        } //everything inside the curly braces is what the timer will do every 1000 milliseconds
    });



    Stopwatch(){

       timeLabel.setText(hours_string+ ":"+ minutes_string+ ":"+seconds_string); //setthe text of time label
        timeLabel.setBounds(100,100,200,100);//formatting
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);




        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){

            if(started==false){
                started =true;
                startButton.setText("STOP");
                start();
            }
            else{
                started =false;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetButton){
            started = false;
            startButton.setText("START");
            reset();
        }

    }
    void start(){
        timer.start();
    }
    void stop(){
        timer.stop();

    }
    void reset(){
    timer.stop();
    elapsedTime=0;
    seconds=0;
    minutes=0;
    hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);

        timeLabel.setText(hours_string +":" + minutes_string +":"+seconds_string);
    }

}
