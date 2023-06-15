import org.junit.Test;
import static org.junit.Assert.*;

public class SlideGameTest {
    @Test
    public void testSlideLeft() {
        SlideGame game = new SlideGame();
        
        int[][] board = {
            {2, 2, 0, 0},
            {2, 0, 2, 0},
            {0, 0, 0, 2},
            {0, 0, 0, 0}
        };
        
        boolean moved = game.slideLeft(board);
        
        assertTrue(moved); // Expect true because there are movable tiles
        
        int[][] expectedBoard = {
            {4, 0, 0, 0},
            {4, 0, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, board);
    }
    
    
    @Test
    public void testSlideLeft1() {
        SlideGame game = new SlideGame();
        
        int[][] board = {
            {1, 1, 0, 0},
            {2, 0, 2, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };
        
        boolean moved = game.slideLeft(board);
        
        assertTrue(moved); // Expect true because there are movable tiles
        
        int[][] expectedBoard = {
            {2, 0, 0, 0},
            {4, 0, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        assertArrayEquals(expectedBoard, board);
    }
    
    
    
    
     @Test
    public void testSlideRight() {
       SlideGame game = new SlideGame();
        int[][] board1 = {
            {0, 0, 2, 2},
            {0, 2, 0, 2},
            {2, 0, 0, 0},
            {0, 0, 0, 0}
        };

        boolean moved = game.slideRight(board1);

        assertTrue(moved);

        int[][] expectedBoard = {
            {0, 0, 0, 4},
            {0, 0, 0, 4},
            {0, 0, 0, 2},
            {0, 0, 0, 0}
        };

        assertArrayEquals(expectedBoard, board1);
    }
     
     
      @Test
    public void testSlideRight1() {
       SlideGame game = new SlideGame();
        int[][] board1 = {
            {2, 0, 8, 8},
            {0, 1, 0, 1},
            {2, 0, 0, 2},
            {0, 0, 1, 0}
        };

        boolean moved = game.slideRight(board1);

        assertTrue(moved);

        int[][] expectedBoard = {
            {0, 0, 2, 16},
            {0, 0, 0, 2},
            {0, 0, 0, 4},
            {0, 0, 0, 1}
        };

        assertArrayEquals(expectedBoard, board1);
    }
     
     
     
     
      @Test
    public void testSlideUp() {
        SlideGame game = new SlideGame();
        int[][] board = {
            {2, 0, 2, 0},
            {2, 0, 0, 0},
            {0, 0, 2, 0},
            {0, 2, 0, 0}
        };

        boolean moved = game.slideUp(board);

        assertTrue(moved);

        int[][] expectedBoard = {
            {4, 2, 4, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        assertArrayEquals(expectedBoard, board);
    }
      
      
      
      
       @Test
    public void testSlideUp1() {
        SlideGame game = new SlideGame();
        int[][] board = {
            {2, 0, 4, 0},
            {1, 0, 0, 0},
            {0, 0, 4, 0},
            {0, 2, 4, 0}
        };

        boolean moved = game.slideUp(board);

        assertTrue(moved);

        int[][] expectedBoard = {
            {2, 2, 8, 0},
            {1, 0, 4, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        assertArrayEquals(expectedBoard, board);
    }

       
       
       
    @Test
    public void testSlideDown() {
      SlideGame game = new SlideGame();
        int[][] board = {
            {0, 2, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 2, 2},
            {2, 0, 2, 2}
        };

        boolean moved = game.slideDown(board);

        assertTrue(moved);

        int[][] expectedBoard = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {4, 2, 4, 4}
        };

        assertArrayEquals(expectedBoard, board);
    }
    
    
    @Test
    public void testSlideDown1() {
      SlideGame game = new SlideGame();
        int[][] board = {
            {0, 0, 1, 0},
            {4, 0, 0, 0},
            {0, 0, 8, 1},
            {2, 0, 8, 1}
        };

        boolean moved = game.slideDown(board);

        assertTrue(moved);

        int[][] expectedBoard = {
            {0, 0, 0, 0 },
            {0, 0, 0, 0 },
            {4, 0, 1, 0 },
            {2, 0, 16, 2}
        };

        assertArrayEquals(expectedBoard, board);
    }
    
    
    @Test
    public void testAddOne() {
       SlideGame game = new SlideGame();
        int[][] board = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        board = game.addOne(board);

        int numberOfOnes = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    numberOfOnes++;
                }
            }
        }

        assertEquals(1, numberOfOnes);
    }
     
}
