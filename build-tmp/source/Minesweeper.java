import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import de.bezier.guido.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Minesweeper extends PApplet {


int NUM_ROWS = 20;
int NUM_COLS = 20;
private MSButton[][] buttons; //2d array of minesweeper buttons
private ArrayList <MSButton> bombs; //ArrayList of just the minesweeper buttons that are mined

public void setup ()
{
    bombs = new ArrayList <MSButton>();
    size(400, 400);
    textAlign(CENTER,CENTER);
    
    // make the manager
    Interactive.make( this );
    
    

    //declare and initialize buttons
    buttons = new MSButton[NUM_ROWS][NUM_COLS];
    for(int j = 0; j<NUM_ROWS; j++)
    {
        for(int i = 0; i<NUM_COLS; i++)
        {
            buttons[i][j]= new MSButton(i,j);
        }
    }
    setBombs();
}
public void setBombs()
{
    int rowB = (int)(Math.random()*NUM_ROWS);
    int colB = (int)(Math.random()*NUM_COLS);
    if(!bombs.contains(buttons[rowB][colB]))
    {
        bombs.add(buttons[rowB][colB]);
    }
    //your code
}

public void draw ()
{
    background( 0 );
    if(isWon())
        displayWinningMessage();
}
public boolean isWon()
{
    //your code here
    return false;
}
public void displayLosingMessage()
{
    //your code here
}
public void displayWinningMessage()
{
    //your code here
}

public class MSButton
{
    private int r, c;
    private float x,y, width, height;
    private boolean clicked, marked;
    private String label;
    
    public MSButton ( int rr, int cc )
    {
        width = 400/NUM_COLS;
        height = 400/NUM_ROWS;
        r = rr;
        c = cc; 
        x = c*width;
        y = r*height;
        label = "";
        marked = clicked = false;
        Interactive.add( this ); // register it with the manager
    }
    public boolean isMarked()
    {
        return marked;
    }
    public boolean isClicked()
    {
        
        return clicked;
    }
    // called by manager
    
    public void mousePressed () 
    {
        clicked = true;
        //your code here
    }

    public void draw () 
    {    
        if (marked)
            fill(0);
        else if( clicked && bombs.contains(this) ) 
             fill(255,0,0);
        else if(clicked)
            fill( 200 );
        else 
            fill( 100 );

        rect(x, y, width, height);
        fill(0);
        text(label,x+width/2,y+height/2);
    }
    public void setLabel(String newLabel)
    {
        label = newLabel;
    }
    public boolean isValid(int r, int c)
    {
        if(r== NUM_ROWS && c==NUM_COLS)
        {
            return true;
        }
        //your code here
        return false;
    }
    public int countBombs(int row, int col)
    {
        int numBombs = 0;
        for (int q=-1;q<=1;q++)
        {
            for (int w=-1;w<=1;w++)
            {
                // if(isValid(r,c) && buttons[r][c].isClicked == false)
                // {
                //     buttons[r+q][c+w].mousePressed();
                // }
            }
        }
        //your code here
        return numBombs;
    }
}




  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Minesweeper" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
