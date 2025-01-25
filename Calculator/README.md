The Calculator application performs both basic and scientific operations. The application provides
user an option to choose between the basic mode and scientific mode. Based on the option
selected by the user, the application calls the corresponding class and the user can perform
various mathematical operations provided in the class. There is a base class in the application
which contains all the methods for calculation, basic as well as scientific. The application
validates the user input also and provides appropriate messages when wrong input is given by
the user.<br>
To create the Calculator application, 5 java files were created. First, an interface iCalc, with the
file name “iCalc.java” is created. Then, we create the base class Calculate, with the file name
“Calculate.java” which contains all the methods for calculation. After the base class, two classes,
Calculator and ScientificCalculator, with the file names as “Calculator.java” and
“ScientificCalculator.java” are created. These classes call the methods defined in the base class
Calculate. Class Calculator contains an instance of Class Calculate, whereas Class
ScientificCalculator inherits Class Calculate and then uses its methods. After creation of all the
above classes, a main class UseCalculate is created, with the file name “UseCalculate.java”
which provides creates instances of Class Calculator or Class ScientificCalculator, based on the
option selected by user.
