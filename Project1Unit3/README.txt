Project1 Unit3

Student : Ti-Fen Pan
Andrew ID : tpan

Note:
	1. I have three threads: t1, t2 and t3
		t1 tries to update the OptionSet Color name to t1Color
		t2 tries to update the OptionSet t1Color name to t2Color
		t3 tries to update the Option price 
		So as I start those threads, t1 first following with t2,
		I have to ensure that while t1 is modifying, t2 cannot
		access the OptionSet name or it couldn't find the name
		it wants to modify.

		To avoid the situation described above, I added synchronized
		line in update methods in Automobile class to lock the object.
		On the other hand, if I didn't add the synchronized keyword, the 
		result may be unpredictable.
    2. Test:
       a. Driver -- it tests the synchronized update methods

------------------------
File Content

UML:
	/UML/p1u3.pdf

Output:
	/Output/Without_Sync.txt
	/Output/With_Sync.txt

Test Cases:
	Project1Unit3/testcases/Ford.txt

Source Code:
Six packages:

--adapter
	--BuildAuto.java : Connect the proxyAutomobile and three interfaces in adapter
	--CreateAuto.java : An interface for build and print automobile object
	--FixAuto.java: An interface for fix the errors
	--proxyAutomobile.java: An abstract class to implement all methods in interfaces
	--UpdateAuto.java: An interface for update option set name and option price.
	
--driver
	--Driver.java: 

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

--scale
	--EditOptions.java: it implements runnable interface for running multiple threads.
		In driver class, we could instantiate this class to update our data and use
		SyncUpdateAuto interface to communicate with Automobile objects.

	--SyncUpdateAuto.java: it is an interface for synchronizing updating data.
		It build a bridge between Automobile and EditOptions.
--util
	--Util.java: 
		1. read a text file and build the Automotive object.
