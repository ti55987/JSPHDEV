Project1 Unit1

Student : Ti-Fen Pan
Andrew ID : tpan

Three packages:

--driver
	--Driver.java: I constructed two different models and test
					all the functionalities like delete/update/find

--model
	--Automotive.java: it encapsulates the cofiguration of a car model. 
		In each Automotive object, there is a set of attributes which is encapsulated by OptionSet.
		Outside classes can only access OptionSet via Automotive object.
		User can update/find/delete the option or optionset by using this class.
		It implements Serializable interface.

	--OptionSet.java: it contains the properties of a certain attribute.
		There is an inner class called Option which encapsulates the price and value of a option.
		This class has a strong assosiation with Automotive class.
		All its methods are protected such that only automotive object can access it.
		It implements Serializable interface.

--util
	--Util.java: 
		1. read a text file and build the Automotive object.
		2. Serialize and Deserialize the Automotive object
