/*
** Task Name:** Lab 4, task 16.1, Calculate Route Length
** Team Members:** Georgii Molyboga, Nooshin Pourkamali
** Lab Date:** Dec 16, 2024
** Description:** This program calculates the total length of a route, given an array of latitude and longitude coordinates.
*/

#include <stdio.h> // Standard input/output library
#include <math.h> // Mathematical functions library
#define M_PI 3.14159265358979323846264338327950288 //Define pi constant

// Function prototypes
double localDistance(double lat1, double lon1, double lat2, double lon2); // Calculates distance between two coordinates
double getRouteLengthKM(int numberOfLocations, const double* latitude, const double* longitude); //Calculate total route length

int main(void) {

    double latitude[9] = { 53.557029, 53.557166, 53.557274, 53.560288, 53.561306, 53.562015, 53.558241, 53.557900, 53.557203 }; // Array of latitude coordinates
    double longitude[9] = { 10.022918,10.021343, 10.020297, 10.014906, 10.015426, 10.016568, 10.023244, 10.022142, 10.022632 }; // Array of longitude coordinates
    
    int numberOfLocations = sizeof latitude / sizeof latitude[0]; // Calculates number of Locations using sizeof operator

    printf("This code calculates the sum of the distances between the points on the map using the coordinates\n\n");

    printf("The length of the Route is equal to: %.2lf Km\n", getRouteLengthKM(numberOfLocations, latitude, longitude)); // Calls getRouteLengthKM() to calculate and print route length

    getchar();
    return 0;
}

double getRouteLengthKM(int numberOfLocations, const double* latitude, const double* longitude)
{
    double sum = 0; //Initializes sum to 0

    for (int i = 0; i < numberOfLocations - 1; i++) //Calculates distance between consecutive points
    {
        sum += localDistance(latitude[i], longitude[i], latitude[i + 1], longitude[i + 1]); //Adds the distance between each pair to the sum
    };

    return sum; //Returns the sum as the total route length
}

// Function to calculate local distance
double localDistance(double lat1, double lon1, double lat2, double lon2) {

    double longitudinal_distance = 111.3 * cos((lat1 + lat2) * M_PI / 360) * fabs(lon1 - lon2); // Calculates the longitudinal distance
    double latitudinal_distance = 111.3 * fabs(lat1 - lat2); // Calculate latitudinal distance

    // Calculate local distance using the Pythagorean theorem
    double localDistanceInKm = sqrt(pow(longitudinal_distance, 2) + pow(latitudinal_distance, 2));
    return localDistanceInKm;
}