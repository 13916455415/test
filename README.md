test
===========================

###  Project Description  

1. After the operation of the project, the parking lot will be initialized. The length and width of the parking lot shall not be less than 3, and the length and width shall be 3-10 random lengths (the length and width of the parking lot shall not be less than 3).  

2. After initializing the parking lot, an autonomous vehicle will be initialized. The xy coordinate is a non-boundary random position in the parking lot, and the direction is a random direction of southeast and northwest.  

3. The car runs one unit at a time by default. Each time, it randomly decides whether to turn or maintain the current direction.  

4. When the car turns and runs, it will determine whether it will reach the boundary of the parking lot. If it will reach the boundary of the parking lot, it will throw MoveOutOfBoundsException and calculate the driving route again until it is determined that it will not reach the boundary of the parking lot.  

After four hours of driving, the car will sleep for half an hour

### Runtime Environment  

jdk 1.8  

### Running Steps  

Run the test method in com.leo. Test.test  
