This is the Workout Tracker App. This README file includes pertinent information
    on the data structures and algorithms used, as well as necessary steps to 
    test the app using its test classes. 

This app uses the following structures and algorithms:
    
 - Superclass/subclass relationships
 - Scanner for files and strings
 - Stacks and complete emptying of the stack
 
!!! TESTING INFORMATION !!! 
When testing this app, it is important to keep in mind that saving is done by 
    going to a text file local to the phone or emulator. Thus, testing fixtures
    often cannot be changed directly, and the files themselves need to be set 
    up for the tests. Thus, when testing the full app, there are some lines in 
    the main code which need to be changed, and they are as follows:
    
 - line 65 in WorkoutScreen needs to be changed so that the file accessed is the
   one desired. The default is the file which the app reads and uses. The other 
   options are a file used to test WorkoutScreen, and a file used to test 
   WorkoutProgress.
 - line 66 in WorkoutScreen needs to be changed to true. This way, before each 
   test, the file will be cleared, and also endWorkout will not exit the current
   activity and fail the test.
 - line 76 in WorkoutProgress needs to be changed so that the file accessed is 
   the one desired. This is done in the same manner as testing WorkoutScreen, 
   but the SAVER_FILE is not needed to test this class. An example of the 
   built-in PROGRESS_FILE is in this file system under the same name, 
   "progresstest.txt". To put this file on the emulator, there is an import 
   option in the DDMS menu, and the file needs to be imported to 
   data\data\com.anderson_cooke_mazer.workouttracker\files. There, the app will 
   access it correctly.
   
For regular usage of this app, none of the previous notes apply.