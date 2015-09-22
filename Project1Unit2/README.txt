Project1 Unit2

Student : Ti-Fen Pan
Andrew ID : tpan

Note:
	1. I have five exceptions. But only implement one fix function. 
       This exception is for missing filename, the fix method is
       to set filename as default file name 
    2. Test by two ways:
       a. Unit tests 
       b. Drivers 

------------------------
File Content

UML:
	/UML/p1u2pa.pdf
	/UML/p1u2pb.pdf

Output:
	/Output/Driver_output.txt
	/Output/ProxyDriver_output.txt

Test Cases:
	Project1Unit2/testcases/Ford.txt
	Project1Unit2/testcases/MissingOption.txt
	Project1Unit2/testcases/MissingOptionSet.txt
	Project1Unit2/testcases/MissingPrice.txt
	Project1Unit2/testcases/Negative_BasePrice.txt
	Project1Unit2/testcases/Toyota.txt

Source Code:
Five packages:

--adapter
	--BuildAuto.java : Connect the proxyAutomobile and three interfaces in adapter
	--CreateAuto.java : An interface for build and print automobile object
	--FixAuto.java: An interface for fix the errors
	--proxyAutomobile.java: An abstract class to implement all methods in interfaces
	--UpdateAuto.java: An interface for update option set name and option price.
	
--driver
	--Driver.java: I constructed two different models and test
					all the functionalities of set choice and print its price
 	--ProxyDriver.java: test the functionalities in proxyAutomobile and exception handlers

--exception
	--AutoException.java: Handle and fix the exceptions
	--EnumAutoErrorCode.java: Encapsulate all custom excetpions
	--Fix1to100.java: Fix missing file exception

--model
	--Automobile.java: it encapsulates the cofiguration of a car model. 
		1.In each Automotive object, there is a set of attributes which is encapsulated by OptionSet.
		2.Outside classes can only access OptionSet via Automotive object.
		3.User can update/find/delete the option or optionset by using this class.
		4.Set the choices of a buyer and calculate its price.

	--OptionSet.java: it contains the properties of a certain attribute.
		1.There is an inner class called Option which encapsulates the price and value of a option.
		2.This class has a strong assosiation with Automotive class.
		3.All its methods are protected such that only automotive object can access it.
		4.We can set choice of a buyer in this class.

--util
	--Util.java: 
		1. read a text file and build the Automotive object.
