#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

int isNorthernHemisphere(latitude, equator);
int isSouthernHemisphere(latitude, equator);

int main(void) {
    int latitude;
    const int equator = 0;  

    printf("Hemisphere test:\n\n");

    printf("Please enter the y coordinates for latitude (from -90 to 90 degrees): ");
    scanf("%u", &latitude);

    if (latitude > 90 || latitude < -90) {
        printf("The input is out of range.\n");

        getchar();
        return 0;
    }

    if (latitude == equator) {
        printf("The coordinates are at the equator!\n");
    }
    else if (isNorthernHemisphere(latitude, equator) == 1) {
        printf("It is the Northern Hemisphere\n");
    }
    else if (isSouthernHemisphere(latitude, equator) == 1) {
        printf("It is the Southern Hemisphere\n");
    }
    else
        printf("logical error\n");

    getchar();
    return 0;
}

int isNorthernHemisphere(latitude, equator) {
    if (latitude > equator)
        return 1;
    else
        return 0;
}

int isSouthernHemisphere(latitude, equator) {
    if (latitude < equator)
        return 1;
    else
        return 0;
}
