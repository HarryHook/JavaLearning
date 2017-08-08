package com.nowcoder;

public class ReverseMatrix {
    public static int[][] transformImage(int[][] mat, int n) {
	if (mat == null) {
	    return null;
	}
	/*
	int temp = 0;
	for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
	
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n/2; j++) {
		temp = mat[i][j];
		mat[i][j] = mat[i][n-j-1];
		mat[i][n-j-1] = temp;
	    }

	}
	
	return mat;
	*/
	for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
               
                if(mat[i][j] == 0) {
               
                    for(int k=0; k<n; k++){
            	    	mat[i][k] = 0;
                    }
                    for(int k=0; k<n; k++){
            	    	mat[k][j] = 0;
                    }
                    return mat;
                }
                
            }
        }
	 return mat;

    }

    public static void main(String[] args) {
	int[][] mat = new int[][] { { 1, 1, 3 }, { 0, 5, 6 }, { 7, 8, 9 } };
	transformImage(mat, 3);
	for (int i = 0; i < 3; i++) {
	    System.out.println();
	    for (int j = 0; j < 3; j++) {
		System.out.print(mat[i][j] + " ");
	    }
	}
    }
}
