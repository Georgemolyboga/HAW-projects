#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

int arraySum(int data[], int size);

int main(void) {

	int data[] = { 1,2,3,4,5,6,7,8 };
	int size = sizeof data / sizeof data[0];

	printf("Sum = %d", arraySum(data, size));

	getchar();
	return 0;
}

int arraySum(int data[], int size) {
	int accumulator = 0;

	for (int i = 0; i < size; i++) {
		accumulator += data[i];
	}
	return accumulator;
}