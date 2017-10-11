package e1;
import java.util.Arrays;
public class Grid
{
protected int rows;         // number of grid rows
protected int cols;         // number of grid columns
 
protected boolean [][] grid;     // the grid containing blobs

boolean marked[][];

public Grid(int rows, int cols, boolean[][] grid)

{
 this.rows = rows;
 this.cols = cols;
 this.grid = grid;
 
}

public String toString()
{
 String gridString = "";
 for (int i = 0; i < rows; i++)
 {
   for (int j = 0; j < cols; j++)
   {
     if (grid[i][j])
       gridString = gridString + "X";
     else
       gridString = gridString + ".";
    }
   gridString = gridString + "\n";   // end of row
 }  
 return gridString;
}

//Returns the number of blobs in the Grid
public int blobCount()
{
 //Initialize Variables
 int count = 0;
 marked = new boolean[rows][cols];
 
 //For each index, checks to see if a blob exists and if it is not marked
 //Then calls blobMark to check the adjacent areas
 for(int i = 0; i < rows; i++) {
	 for(int j = 0; j < cols; j++) {
		 if(grid[i][j] && !marked[i][j]) {
			 count+=1;
			 blobMark(i, j);	 
		 }
	 }
 }
 return count;
}

//Marks position if there exists a blob and has not been marked before
public void blobMark(int i, int j) {
	//Must be marked first 
	marked[i][j] = true;
	
	//Variables for better code readability
	int left = i-1;
	int right = i+1;
	int top = j-1;
	int bottom = j+1;

	//Checks to the left for unmarked blob
	if((left >= 0) && grid[left][j] && !marked[left][j]) {
		blobMark(left, j);
	}
	//Checks to the right for unmarked blob
	if((right < rows) && grid[right][j] && !marked[right][j]) {
		blobMark(right, j);
	}
	//Checks to the top for unmarked blob
	if((top >= 0) && grid[i][top] && !marked[i][top]) {
		blobMark(i, top);
	}
	//Checks to the bottom for unmarked blob
	if((bottom < cols) && grid[i][bottom] && !marked[i][bottom]) {
		blobMark(i, bottom);
	}
	//Checks to the top left for unmarked blob
	if((left >= 0) && (top >= 0) && grid[left][top] && !marked[left][top]) {
		blobMark(left, top);
	}
	//Checks to the bottom left for unmarked blob
	if((left >= 0) && (bottom < cols) && grid[left][bottom] && !marked[left][bottom]) {
		blobMark(left, bottom);
	}
	//Checks to the top right for unmarked blob
	if((right < rows) && (top >= 0) && grid[right][top] && !marked[right][top]) {
		blobMark(right, top);
	}
	//Checks to the bottom right for unmarked blob
	if((right < rows) && (bottom < cols) && grid[right][bottom] && !marked[right][bottom]) {
		blobMark(right, bottom);
	}
}
}

