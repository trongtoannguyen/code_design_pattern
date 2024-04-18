# Getting Started
The Data Access Object (or **DAO**) pattern:

* separates a data resource's client interface from its data access mechanisms
* adapts a specific data resource's access API to a generic client interface

### Reference Documentation
Implementation strategies. Designing a DAO interface and implementation is a tradeoff between simplicity and flexibility. 
The sample application provides examples of several strategies for implementing the Data Access Object pattern:

* _Implement the interface directly as a class_. The simplest (but least flexible) way to implement a data access object is to write it as a class.
  This approach separates the data access interface from the details of how it is implemented, providing the benefits of the DAO pattern. The data access mechanism can be changed easily by writing a new class that implements the same interface, and changing client code to use the new class. Yet this approach is inflexible because it requires a code changes to modify the data access mechanism.
* _Improve flexibility by making DAOs "pluggable"_. A pluggable DAO allows an application developer or deployer to select a data access mechanism with no changes to program code. 
  In this approach, the developer accesses a data source only in terms of an abstract DAO interface. Each DAO interface has one or more concrete classes that implement that interface for a particular type of data source. The application uses a factory object to select the DAO implementation at runtime, based on configuration information.