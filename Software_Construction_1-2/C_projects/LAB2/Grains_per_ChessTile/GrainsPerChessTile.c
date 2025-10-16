#define _CRT_SECURE_NO_DEPRECATE																		//Avoid conflict when using the scanf
#include <stdio.h>

int main(void) {
	unsigned long long wheatOnField = 1;                                                                // Defining the wheats on the field 
	unsigned long long sum = 0;                                                                         // Defining the sum of the wheat grains
	double proportion;
	double weightWorldKg = 735.8e9;
	double weightGrainKg = 55.e-6;
	double weightBoardKg;

	printf("This is the representation of wheat being doubled in each chess-field: \n\n");

	printf(" %-4s | %-20s | %s\n", "Field", "On Field", "Sum");						                    // Creating the sections
	printf("-------+----------------------+---------------------------------+\n");

	for (int field = 1; field <= 64; field++) {															// Creating the fields 1-64
		sum += wheatOnField;																			// Calculating the sum of the grains for each field
		printf("|%5d | %20llu |%20llu (=%.2e) |\n", field, wheatOnField, sum, (double)sum);				// printing the inputs in the table
		wheatOnField *= 2;                                                                              // Multiplying the grains with each field				
	}

	printf("-------+----------------------+---------------------------------+\n");
	weightBoardKg = ((double)sum * weightGrainKg);
	proportion = weightBoardKg / weightWorldKg;														// Caluculating the proportion of the sum of the grains to the world production
	printf("\n\n The proportion of the wheat grain mass to the world production is ~ %.1f chess grains/world production", proportion);

	getchar();
	return 0;
}