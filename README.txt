Group 4: Elevator

Name:   Loulia Massarani
    Shan Ramashkanna
    Shady Eloraby 
    Hussain Anwar


BreakDown of responsibilities of each team member,
Loulia Massarani:-  UML class Diagram and programming the Main_Runner and Designing
Shan Ramashakanna:- Designing of a Sequence Diagrams and Coding a part of an Elevator
Shady Elobraby:-    programing the interference class, such us:- FloorRequested and MoveEnum
Hussian Anwar:-     programming the floorSubsystem and Desing the floors system
Tinsae Debele:      programming the Scheduler subsystem and write READM

Project Specification 

 the program has six class, Which are,  Elevator, FloorSubsystem, Main_runner, Scheduler and to a class of enum and FloorRequested
As indicated on the UML class diagram and sequence diagram each class have there owned task
The main_runner:  This class start the thread of floorSubsystem, Elevator and Scheduler.
FloorSubsystme: This class is a thread. it is the responsibility of reading the text file and store it in a common shared memory of the FloorRequered
        and send the information to the Scheduler. The text file is stored in the same folder as the codes, which is called inputData.txt
Scheduler:  The class the extends from a thread, which makes it a thread itself. it is responsible for controlling and communication system. it will
        it gives access to the shared memory between the floors system and Elevator.
Elevator: This is the elevator class, currently it only responsible for receiving the information for the Schedular and output.

How to run the code
1.    Unzip the folder
2.    Open your eclipse 
3.    File -> Import -> General -> Existing project 
4.    On Select root directory, locate your unzipped folder 
5.    Select Finish
6.    After that, you can run the program by running the Main_runner.java
        
         
Texting the code:

You can test the code in two ways
    1. The first way is to run the code and using the text file provided.
        and change the data and check, if it can output correctly.
    2. As indcated in the file, we tried to use a Junit test but it is not succesfully done 
	As result, out JUNit test doesn't work.

PS: To Run the program. please Run the main_runner.java

    
