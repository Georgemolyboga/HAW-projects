/*
** Task Name:** Lab 4, task 16.2, Find Furthest Locations
** Team Members:** Georgii Molyboga, Nooshin Pourkamali
** Lab Date:** Dec 16, 2024
** Description:** This program calculates the distance between all pairs of locations and determines the two locations with the greatest distance.
*/

#include <stdio.h> // Include standard input/output library
#include <math.h> // Include mathematical functions library
#define M_PI 3.14159265358979323846264338327950288 // Define pi constant

// Function prototypes
double globalDistance(double lat1, double lon1, double lat2, double lon2);
double getMaximumDistance(int numberOfLocations, char* names[], const double coordinates[][2], char** location1, char** location2);

int main(void) 
{

    // Names of the locations
    char* names[] = { "HAW_Hamburg", "Eiffel Tower", "Palma de Mallorca", "Copacabana", "Las Vegas", "Waikiki Beach", "Surfer's Paradise" }; // Array of location names

    // Coordinates of the locations from an array "names[]" from above 
    double coordinates[][2] =
    {
        {53.557078, 10.023109},
        {48.858363, 2.294481},
        {39.562553, 2.661947},
        {-22.971177, -43.182543},
        {36.156214, -115.148736},
        {21.281004, -157.837456},
        {-28.002695, 153.431781}
    };

    // Pointers to store names of locations with maximum distance
    char* location1 = NULL;
    char* location2 = NULL;

    // Calculate and print maximum distance and locations
    int numberOfLocations = sizeof(coordinates) / sizeof(coordinates[0]);

    printf("This code finds and calculates the distance between 2 farthest given places\n\n");

    printf("%s and %s have the largest distance: %.2lf km\n", location1, location2, getMaximumDistance(numberOfLocations, names, coordinates, &location1, &location2));

    getchar();
    return 0;
}

// Find locations with maximum distance
double getMaximumDistance(int numberOfLocations, char* names[], const double coordinates[][2], char** location1, char** location2)
{
    double maxDistance = 0;

    // Going through the lacations
    for (int i = 0; i < numberOfLocations - 1; i++) 
    {
        for (int j = i + 1; j < numberOfLocations; j++) 
        {
            double distance = globalDistance(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]);

            if (distance > maxDistance) 
            {
                // Saving the bigger distance and location names
                maxDistance = distance;
                *location1 = names[i];
                *location2 = names[j];
            }
        }
    }

    return maxDistance;
}

// Calculate distance between two coordinates
double globalDistance(double lat1, double lon1, double lat2, double lon2)
{
    // Convert latitude and longitude to radians
    lat1 = lat1 * M_PI / 180;
    lon1 = lon1 * M_PI / 180;
    lat2 = lat2 * M_PI / 180;
    lon2 = lon2 * M_PI / 180;

    // Calculate global distance
    double globalDistanceInKm = 6378.388 * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1));
    return globalDistanceInKm;
}