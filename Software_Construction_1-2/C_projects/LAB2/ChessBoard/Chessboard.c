#define _CRT_SECURE_NO_DEPRECATE  //Avoid conflict when using the scanf
#include <stdio.h>

int main(void) {
	printf("This is the representation of the chessboard: \n\n");

	printf("+----+----+----+----+----+----+----+----+ \n");		// Beginning of the table

	for (int row = 8; row >= 1; row--) {                        // Creating the rows
		for (char column = 'a'; column <= 'h'; column++) {      // Creating the columns

			printf("| %c%d ", column, row);                     // Printing the columns and rows
		}
		printf("| \n");
		printf("+----+----+----+----+----+----+----+----+ \n"); // The end line of the table
	}

	getchar();
	return 0;
}