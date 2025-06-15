import javax.sound.sampled.SourceDataLine;

public class Recursion {

    public int fib(int n){
        if(n == 1 || n == 0){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    public int Triangle(int n){
        // base case: Triangle 1 =1, Triangle 0 = 0
        if(n <= 1){
            return n;
        }else{
            return Triangle(n-1)+n;
        }
    }

    // 5 = 1+2+3+4+5
    public int naturalSum(int n){
        if(n == 0 || n == 1){
            return n;
        }else{
            return naturalSum(n-1)+n;
        }
    }

    // 245 = 2+4+5 = 11
    public int sumDigits(int n){
        if(n <= 9){
            return n;
        }else{
            return sumDigits(n/10) + (n%10);
        }
    }

    // if even: n/2, if odd: 3n+1
    public void hailstone(int n){
        if(n == 1){
            System.out.println(n);
        }else{
            System.out.println(n);
            if(n%2 == 0){
                hailstone(n/2);
            }else{
                hailstone(3*n+1);
            }
        }
    }

    // is the word spelled the same way back or not
    public boolean isPalindrome(String word){
        if(word.length() == 1){
            return true;
        }else{
            if(word.charAt(0) == word.charAt(word.length()-1)){
                return isPalindrome(word.substring(1, word.length()-1));
            }else{
                return false;
            }
        }
    }

    final char WALL = '█';

    public void printMaze(char[][] maze){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public boolean solveMaze(char[][] maze, int row, int col){
        if(row < 0 || col < 0){
            return false;
        }else if(row >= maze.length || col >= maze[row].length){
            return false;
        }else if(maze[row][col] == 'E'){ // found the exit, show solution
            //show solution
            printMaze(maze);
            return true;
        }else if(maze[row][col] == WALL){
            // if we found a wall stop
            return false;
        }else if(maze[row][col] == '.'){
            // if we are on a spot already been, stop
            return false;
        }
        // on an unvisited square
        // mark as visited
        maze[row][col] = '.';
        // move in every direction to look for solution
        boolean moveUp = solveMaze(maze, row-1, col);
        boolean moveRight = solveMaze(maze, row, col+1);
        boolean moveDown = solveMaze(maze, row+1, col);
        boolean moveLeft = solveMaze(maze, row, col-1);

        // did we find a solution?
        if(moveUp || moveDown || moveLeft || moveRight){
            return true;
        }else{
            return false;
        }
    }

    public int countGroups(char[] letters, int index, int length, String group){
        // already have my group
        if(length == 0){
            // print the group
            System.out.println(group);
            // found one group
            return 1;
        }
        // ran out of letters
        else if(index >= letters.length){
            //ran out of letters, no group found
            return 0;
        }
        // use the letter
        int withletter = countGroups(letters, index + 1, length - 1, group + letters[index]);
        //without using the letter
        int withoutLetter = countGroups(letters, index + 1, length, group);

        // how many combos all together
        return withletter + withoutLetter;
    }

    // reverse a word (animal = lamina)

    public String reverseString(String word){
        if(word.length() == 0){
            return "";
        }else{
            char s = word.charAt(word.length()-1);
            return s + reverseString(word.substring(0, word.length()-1));
        }
    }


    // multiplying without using multiplication
    public int product(int x, int y){
        if(y == 0 || x == 0){
            return 0;
        }else{
            return x + product(x,y-1);
        }
    }

    
    // converting decimal to binary
    public String toBinary(int number){
        String s = "";
        if(number == 0){
            return "";
        }else{
            if(number%2 == 0){
                s = "0" + s;
            }else if(number%2 == 1){
                s = "1" + s;
            }
            return toBinary(number/2) + s;
        }
    }


    // remove double letters
    public String stringCleaning(String word){
        if(word.length() < 2){
            return word;
        }else{
            if(word.charAt(0) == word.charAt(1)){
                return stringCleaning(word.substring(1, word.length()));
            }else{
                char s = word.charAt(0);
                return s + stringCleaning(word.substring(1, word.length()));
            }
        }
    }

    // max amount of chocolates a person can buy 
    public int countMaxChocolates(int money, int price, int wrap){
            int num = money/price;
            // call recursion method, add the original number of chocolates bought
            return num + extraWrap(num, wrap);
    }

    // method to determine extra chocolates
    public int extraWrap(int chocs, int wrap){
        // if you divide the choclates by the wrappers needed for a redeem but the answer is not enough to buy you another chocolate
        if(chocs/wrap < wrap){
            // can get you one more wrapper
            if(chocs == wrap){
                return 1;
            }// the remainder
            else{
            return chocs%wrap;
            }
        }else{
            int extra = chocs/wrap;
            return extra + extraWrap(extra, wrap);
        }
    }

    // remove all Xs from the word
    public static String removeX(String word){
        // base case: if the word length is zero, return empty string
        if(word.length() == 0){
            return "";
        }else{
            // if the beginging of the word is a 'x'
            if(word.charAt(0) == 'x' || word.charAt(0) == 'X'){
                // remove it and shorten the word using substring
                return removeX(word.substring(
                    1, word.length()));
            }
            // if the first letter is not a x
            else{
                // save the first letter as a char
                char starting = word.charAt(0);
                // repeat the method but the word has been shortened using substring to remove the first letter
                return starting + removeX(word.substring(1, word.length()));
            }
        }
    }
    


    

    public static void main(String[] args) {
        // object made to run your recursive methods  (test.______)
        Recursion test = new Recursion();
        

        // run your methods here using the test object
        /* char[][] maze ={{'█','S','█','█','█','█','█','█','█','█'}, 
                        {'█',' ',' ',' ','█',' ',' ',' ',' ','█'},
                        {'█',' ','█','█','█',' ','█',' ','█','█'},
                        {'█',' ',' ',' ',' ',' ',' ','█',' ','█'},
                        {'█',' ','█',' ','█','█',' ',' ',' ','█'},
                        {'█','█','█',' ','█',' ','█',' ','█','█'},
                        {'█',' ','█',' ','█',' ',' ',' ',' ','█'},
                        {'█',' ',' ',' ','█',' ','█','█',' ','█'},
                        {'█',' ','█',' ','█',' ',' ','█',' ','█'},
                        {'█','█','█','█','█','█','E','█','█','█'}};

        test.solveMaze(maze,0,1);   

        // create list of letters
        char[] letters = {'a','b','c','d','e','f'};
        int numGroups = test.countGroups(letters, 0, 3, "");
        System.out.println(numGroups);

        */

        String x = test.reverseString("help");
        System.out.println(x);

        int b = test.product(7,3);
        System.out.println(b);

        String i = test.toBinary(47);
        System.out.println(i);

        String a = test.stringCleaning("xxxyyabby");
        System.out.println(a);

        int y = test.countMaxChocolates(20,3,5);
        System.out.println(y);

        System.out.println(removeX("hexxen"));

    }
    
}
