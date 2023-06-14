import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.lang.Math;
import javafx.scene.layout.GridPane;
import java.util.Scanner;

/*
 * This class represents Slide Game Application
 * @Author:Merve Ziya
 */
public class SlideGame extends Application {
  
  //stores the array of buttons that represents the screen
  private Button[][] buttons;
  
 /** 
   * creates the GUI display
   * @param primaryStage the main window
   */
  public void start(Stage primaryStage) {
    //stores the width/length of the board
    int width = 4;
    int length = 4;
    
    buttons = new Button[length][width];
    GridPane grid = new GridPane();
    
   //initializes every button as a blank button
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        buttons[i][j] = new Button("  ");
      }
      grid.addRow(i, buttons[i]);
    }
  
     //stores the two indices to start one random square off as one
    int indOne = (int) (Math.random() * width);
    int indTwo = (int) (Math.random() * length);
    buttons[indOne][indTwo].setText("1");
    
    
    // Sets the actions for buttons in the lef column
    for (int i = 1; i < length - 1; i++) {
      int row = i;
      buttons[row][0].setOnAction(e -> {
        int[][] board = buttonToInt(buttons);
        boolean moved = slideLeft(board);
        if (moved) {
          board = addOne(board);
          intToButton(board);
        }
      });
    }
    
    // Sets the actions for buttons in the right column
    for (int i = 1; i < length - 1; i++) {
      int row = i;
      buttons[row][width - 1].setOnAction(e -> {
        int[][] board = buttonToInt(buttons);
        boolean moved = slideRight(board);
        if (moved) {
          board = addOne(board);
          intToButton(board);
        }
      });
    }
    
    // Sets the actions for buttons in the top row
    for (int j = 1; j < width - 1; j++) {
      int col = j;
      buttons[0][col].setOnAction(e -> {
        int[][] board = buttonToInt(buttons);
        boolean moved = slideUp(board);
        if (moved) {
          board = addOne(board);
          intToButton(board);
        }
      });
    }
    
     // Sets the actions for buttons in the bottom row
    for (int j = 1; j < width - 1; j++) {
      int col = j;
      buttons[length - 1][col].setOnAction(e -> {
        int[][] board = buttonToInt(buttons);
        boolean moved = slideDown(board);
        if (moved) {
          board = addOne(board);
          intToButton(board);
        }
      });
    }
    
    Scene scene = new Scene(grid);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  
  /**
   * Slides the elements of the board to the left.
   * @param board the board represented as a 2D array
   * @return true if any element is moved, false otherwise
   */
    public boolean slideLeft(int[][] board) {
    boolean isMoved = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 1; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          int m = j;
          while (m > 0 && (board[i][m - 1] == 0 || board[i][m - 1] == board[i][m])) {
            if (board[i][m - 1] == 0) {
              board[i][m - 1] = board[i][m];
              board[i][m] = 0;
            } else {
              board[i][m - 1] += board[i][m];
              board[i][m] = 0;
            }
            m-=1;
            isMoved = true;
          }
        }
      }
    }
    return isMoved;
  }
  
 
 /**
   * Slides the elements of the board to the right.
   * @param board the board represented as a 2D array
   * @return true if any element is moved, false otherwise
   */
  public boolean slideRight(int[][] board) {
    boolean isMoved = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = board[i].length - 2; j >= 0; j--) {
        if (board[i][j] != 0) {
          int m = j;
          while (m < board[i].length - 1 && (board[i][m + 1] == 0 || board[i][m + 1] == board[i][m])) {
            if (board[i][m + 1] == 0) {
              board[i][m + 1] = board[i][m];
              board[i][m] = 0;
            } else {
              board[i][m + 1] += board[i][m];
              board[i][m] = 0;
            }
            m++;
            isMoved = true;
          }
        }
      }
    }
    return isMoved;
  }
  
  
  /**
   * Slides the elements of the board upwards.
   * @param board the board represented as a 2D array
   * @return true if any element is moved, false otherwise
   */
  public boolean slideUp(int[][] board) {
    boolean moved = false;
    for (int j = 0; j < board[0].length; j++) {
      for (int i = 1; i < board.length; i++) {
        if (board[i][j] != 0) {
          int k = i;
          while (k > 0 && (board[k - 1][j] == 0 || board[k - 1][j] == board[k][j])) {
            if (board[k - 1][j] == 0) {
              board[k - 1][j] = board[k][j];
              board[k][j] = 0;
            } else {
              board[k - 1][j] += board[k][j];
              board[k][j] = 0;
            }
            k--;
            moved = true;
          }
        }
      }
    }
    return moved;
  }
  
  
  /**
   * Slides the elements of the board downwards.
   * @param board the board represented as a 2D array
   * @return true if any element is moved, false otherwise
   */
  public boolean slideDown(int[][] board) {
    boolean moved = false;
    for (int j = 0; j < board[0].length; j++) {
      for (int i = board.length - 2; i >= 0; i--) {
        if (board[i][j] != 0) {
          int k = i;
          while (k < board.length - 1 && (board[k + 1][j] == 0 || board[k + 1][j] == board[k][j])) {
            if (board[k + 1][j] == 0) {
              board[k + 1][j] = board[k][j];
              board[k][j] = 0;
            } else {
              board[k + 1][j] += board[k][j];
              board[k][j] = 0;
            }
            k++;
            moved = true;
          }
        }
      }
    }
    return moved;
  }
  
  

  
  
  /** 
   * helper method to convert from an array of ints to an array of buttons
   * @param ints an array of ints
   */
  public void intToButton(int[][] ints) {
    //loops through each of the ints to set the text on buttons
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          buttons[i][j].setText("  ");
        }
        else {
          buttons[i][j].setText(Integer.toString(ints[i][j]));
        }
      }
    }
  }
  
  /**
   * helper method to convert an array of buttons to an array of ints
   * @param buttons an array of buttons
   * @return an array of ints
   */
  public int[][] buttonToInt(Button[][] buttons) {
    //stores the final array of ints
    int[][] finalArray = new int[buttons.length][buttons[0].length];
    //runs through each button intiliaze ints based off the text
    for (int i = 0; i < buttons.length; i++) {
      for (int j = 0; j < buttons[i].length; j++) {
        if (buttons[i][j].getText().equals("  ")) {
          finalArray[i][j] = 0;
        }
        else {
          
          finalArray[i][j] = Integer.parseInt(buttons[i][j].getText());
        }
      }
    }
    return finalArray;
  }
  
  /**
   * helper method to generate an extra one
   * @param ints an array of ints
   * @return an array of ints with a new one tile
   */
  public static int[][] addOne(int[][] ints) {
    int indOne = (int) (Math.random() * ints.length);
    int indTwo = (int) (Math.random() * ints[0].length);
    //stores whether or not there is an empty space
    boolean isSpace = false;
    //checks to make sure that there is an empty space
    for (int i = 0; i < ints.length; i++) {
      for(int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] == 0) {
          isSpace = true;
        }
      }
    }
    //if there is space on the board, it will keep generating numbers until it hits a blank space
    while (ints[indOne][indTwo] != 0 && isSpace) {
      indOne = (int) (Math.random() * ints.length);
      indTwo = (int) (Math.random() * ints[0].length);
    } 
    ints[indOne][indTwo] = 1;
    return ints;
  }
  
    /**
   * helper to determine the number of non-zeroes in a method, to test addOne
   * @param ints a multidimensional array
   * @return the number of non-zeros in the method
   */
  public static int numberNonZero(int[][] ints) {
    int numNonZero = 0;
    //loops through the array
    for (int i = 0; i < ints.length; i++) {
      for (int j = 0; j < ints[i].length; j++) {
        if (ints[i][j] != 0) {
          numNonZero++;
        }
      }
    }
    return numNonZero;
  }
   
  /** 
    * The main method to run the program  
    * @param args the command line arguments  
    */ 
  public static void main(String[] args) { 
    SlideGame.launch(args);              
  }
}